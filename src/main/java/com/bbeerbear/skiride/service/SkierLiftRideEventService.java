package com.bbeerbear.skiride.service;

import com.bbeerbear.skiride.dto.ResortSkiers;
import com.bbeerbear.skiride.entity.Resort;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class SkierLiftRideEventService {
    private final MongoTemplate mongoTemplate;

    public SkierLiftRideEventService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ResortSkiers getNumOfSkiersByResortIdAndSeasonIdAndDayId(int resortId, String seasonId, String dayId){
        Aggregation aggregation = newAggregation(
                Aggregation.match(Criteria.where("resortId").is(resortId)
                        .and("seasonId").is(seasonId)
                        .and("dayId").is(dayId)),
                Aggregation.group(Aggregation.fields("resortId","seasonId","dayId","skierId")),
                Aggregation.group("_id.resortId").count().as("numOfSkiers")
        );
        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "skiers", Document.class);
        Document document = results.getUniqueMappedResult();
        int numOfSkiers = document != null ? document.getInteger("numOfSkiers", 0) : 0;
        Query query = new Query(Criteria.where("resortId").is(resortId));
        query.fields().include("resortName");
        Resort resort = mongoTemplate.findOne(query, Resort.class, "resorts");
        return new ResortSkiers(resort != null ? resort.getResortName() : null, numOfSkiers);
    }
}

package com.bbeerbear.skiride.service;

import com.bbeerbear.skiride.entity.Resort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResortService {
    private final MongoTemplate mongoTemplate;

    public ResortService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void addSeasonByResortId(int resortId, String season){
        Query query = new Query(Criteria.where("resortId").is(resortId));
        Update update = new Update().addToSet("seasons", season);
        mongoTemplate.updateFirst(query,update, Resort.class);
    }
}

package com.bbeerbear.skiride.dao;

import com.bbeerbear.skiride.entity.Resort;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ResortRepository extends MongoRepository<Resort, Integer> {
}

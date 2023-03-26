package com.bbeerbear.skiride.dao;

import com.bbeerbear.skiride.entity.SkierLiftRideEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SkierLiftRideEventRepository extends MongoRepository<SkierLiftRideEvent, String> {
}

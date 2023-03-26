package com.bbeerbear.skiride.service;

import com.bbeerbear.skiride.dto.ResortSkiers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SkierLiftRideEventServiceTest {
    @Autowired
    SkierLiftRideEventService skierLiftRideEventService;

    @Test
    public void getNumOfSkiersByResortIdAndSeasonIdAndDayIdTest(){
        ResortSkiers resortSkiers = skierLiftRideEventService.getNumOfSkiersByResortIdAndSeasonIdAndDayId(1, "2022", "366");
        System.out.println(resortSkiers.toString());
    }
}
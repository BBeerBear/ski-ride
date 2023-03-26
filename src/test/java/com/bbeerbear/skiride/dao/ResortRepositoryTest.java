package com.bbeerbear.skiride.dao;

import com.bbeerbear.skiride.entity.Resort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResortRepositoryTest {
    @Autowired
    private ResortRepository resortRepository;

    @Test
    public void createResort(){
        resortRepository.save(new Resort(1,"Whildre", List.of("2001","2013")));
    }

    @Test
    public void addSeasonByResortId(){

    }
}
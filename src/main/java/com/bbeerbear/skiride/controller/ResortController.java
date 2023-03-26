package com.bbeerbear.skiride.controller;

import com.bbeerbear.skiride.dao.ResortRepository;
import com.bbeerbear.skiride.dto.Season;
import com.bbeerbear.skiride.entity.Resort;
import com.bbeerbear.skiride.exception.ResortSeasonNotFoundException;
import com.bbeerbear.skiride.service.ResortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResortController {
    private final ResortRepository resortRepository;
    private final ResortService resortService;
    public ResortController(ResortRepository resortRepository, ResortService resortService) {
        this.resortRepository = resortRepository;
        this.resortService = resortService;
    }

    // get a list of ski resorts in the database
    @GetMapping("/resorts")
    public List<Resort> getResorts(){
        return resortRepository.findAll();
    }

    @PostMapping("/resorts")
    public ResponseEntity<Resort> createResort(@RequestBody Resort resort){
        Resort savedResort = resortRepository.save(resort);
        return ResponseEntity.created(null).build();
    }

    // Get a list of seasons for the specified resort
    @GetMapping("/resorts/{resortID}/seasons")
    public List<String> getResortSeasons(@PathVariable int resortID){
        Optional<Resort> resort = resortRepository.findById(resortID);
        if(resort.isEmpty()){
            throw new ResortSeasonNotFoundException(null);
        }
        return resort.get().getSeasons();
    }

    //  Add a new season for a resort
    @PostMapping("/resorts/{resortID}/seasons")
    public void createResortSeasons(@PathVariable int resortID, @RequestBody Season season){
        resortService.addSeasonByResortId(resortID,season.getYear());
    }
}

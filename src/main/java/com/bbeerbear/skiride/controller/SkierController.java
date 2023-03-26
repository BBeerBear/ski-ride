package com.bbeerbear.skiride.controller;

import com.bbeerbear.skiride.dao.SkierLiftRideEventRepository;
import com.bbeerbear.skiride.dto.LiftRide;
import com.bbeerbear.skiride.dto.ResortSkiers;
import com.bbeerbear.skiride.entity.SkierLiftRideEvent;
import com.bbeerbear.skiride.service.SkierLiftRideEventService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SkierController {
    private final SkierLiftRideEventRepository skierLiftRideEventRepository;
    private final SkierLiftRideEventService skierLiftRideEventService;
    public SkierController(SkierLiftRideEventRepository skierLiftRideEventRepository, SkierLiftRideEventService skierLiftRideEventService) {
        this.skierLiftRideEventRepository = skierLiftRideEventRepository;
        this.skierLiftRideEventService = skierLiftRideEventService;
    }

    // Write a new lift ride for the skier
    @PostMapping("/skiers/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}")
    public void createSkierLiftRide(@PathVariable int resortID, @PathVariable String seasonID,
                                    @PathVariable String dayID, @PathVariable int skierID,
                                    @RequestBody LiftRide liftRide){
        LiftRide liftRide1 = new LiftRide(liftRide.getLiftId(), liftRide.getTime());
        SkierLiftRideEvent skierLiftRideEvent = new SkierLiftRideEvent(null, resortID, seasonID, dayID, skierID, liftRide1);
        skierLiftRideEventRepository.save(skierLiftRideEvent);
    }

    // Get number of unique skiers at resort/season/day
    @GetMapping("/resorts/{resortID}/seasons/{seasonID}/day/{dayID}/skiers")
    public ResortSkiers getNumOfSkiersByResortAndSeasonAndDay(@PathVariable int resortID, @PathVariable int dayID, @PathVariable int seasonID){
        return skierLiftRideEventService.getNumOfSkiersByResortIdAndSeasonIdAndDayId(resortID,String.valueOf(dayID),String.valueOf(seasonID));
    }
}

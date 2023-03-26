package com.bbeerbear.skiride.entity;

import com.bbeerbear.skiride.dto.LiftRide;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "skierLiftRideEvents")
@AllArgsConstructor
public class SkierLiftRideEvent {
    @Id
    private String id;
    private int resortId;
    private String seasonId;
    private String dayId;
    private int skierId;
    private LiftRide liftRide;
}

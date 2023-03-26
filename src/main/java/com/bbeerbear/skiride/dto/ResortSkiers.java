package com.bbeerbear.skiride.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResortSkiers {
    private String resortName;
    private int numSkiers;
}

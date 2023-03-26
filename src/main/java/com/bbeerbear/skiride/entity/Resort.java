package com.bbeerbear.skiride.entity;


import com.bbeerbear.skiride.dto.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("resorts")
@AllArgsConstructor
@NoArgsConstructor
public class Resort {
    @Id
    private int resortId;
    private String resortName;
    private List<String> seasons;
}

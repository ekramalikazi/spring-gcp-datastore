package com.example.datastore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpaceShip {
    //@JsonTypeId
    @Id
    private Long id;
    private String model;
    private String captain;
    private Integer fuel;
    private LocalDateTime launchTime;
}
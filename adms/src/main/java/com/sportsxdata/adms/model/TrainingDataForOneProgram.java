package com.sportsxdata.adms.model;

import lombok.Data;

@Data
public class TrainingDataForOneProgram {

    private String id;

    private String maxSpeed;

    private String avgSpeed;

    private String maxPower;

    private String avgPower;

    private String timeReal;

    private String strengthReal;

    private String intervalReal;

    private String durationReal;
}

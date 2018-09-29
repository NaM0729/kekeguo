package com.sportsxdata.adms.model;

import lombok.Data;

import java.util.regex.Pattern;

@Data
public class ActionDataPojo {

    private String id;

    private String planId;

    private String modifyTime;

    private String sectionId;

    private String themeId;

    private String actionId;

    private String groupNum;

    private String maxSpeed;

    private String avgSpeed;

    private String maxPower;

    private String avgPower;

    private String assess;

    private String timeReal;

    private String strengthReal;

    private String intervalReal;

    private String durationReal;

    private String unit;

}

package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class TrainingPlanPojo {
    private String planId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;
    private List<SectionPojo> sectionPojos;
}

@Data
class SectionPojo {
    private String sectionId;
    private String sectionName;
    private List<ThemePojo> themePojos;
}
@Data
class ThemePojo {
    private String themeId;
    private String themeName;
    private List<ActionPojo> actionPojos;
}
@Data
class ActionPojo {
    private String order;
    private String actionId;
    private String actionName;
    private List<PlanActionRelationPojo> planActionRelationPojos;
}
@Data
class PlanActionRelationPojo{

    private String pid;

    private String planId;

    private String athleteId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

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

}

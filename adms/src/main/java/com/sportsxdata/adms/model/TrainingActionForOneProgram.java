package com.sportsxdata.adms.model;

import lombok.Data;

import java.util.List;
@Data
public class TrainingActionForOneProgram {

    private String themeId;

    private String actionId;

    private String athleteId;

    private String assess;

    private List<TrainingDataForOneProgram> dataForOnePrograms;
}

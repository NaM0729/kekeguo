package com.sportsxdata.adms.model;

import lombok.Data;

import java.util.List;

@Data
public class TrainingDataForAllPrograms {

    private String planId;

    private List<TrainingActionForOneProgram> actionForOnePrograms;

}


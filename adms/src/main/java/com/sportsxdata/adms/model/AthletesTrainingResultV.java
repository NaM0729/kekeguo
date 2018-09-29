package com.sportsxdata.adms.model;

import java.util.List;

public class AthletesTrainingResultV extends UserImge{

    public List<AthletesTrainingResult> list;
    public String coachId;

    public List<AthletesTrainingResult> getList() {
        return list;
    }

    public void setList(List<AthletesTrainingResult> list) {
        this.list = list;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }
}

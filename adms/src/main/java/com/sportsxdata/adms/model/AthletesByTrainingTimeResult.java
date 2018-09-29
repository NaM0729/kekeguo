package com.sportsxdata.adms.model;

import java.util.List;

/**
 * 数字录入中 展示运动员列表（通过训练时间段来分类） 结果接收类
 * @author zyn
 * @date 2018-06-30
 * @return
 */
public class AthletesByTrainingTimeResult {
    public String trainingPlanId;
    public String time;
    public String state;
    public List<UserImge> users;

    public String getTrainingPlanId() {
        return trainingPlanId;
    }

    public void setTrainingPlanId(String trainingPlanId) {
        this.trainingPlanId = trainingPlanId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<UserImge> getUsers() {
        return users;
    }

    public void setUsers(List<UserImge> users) {
        this.users = users;
    }
}

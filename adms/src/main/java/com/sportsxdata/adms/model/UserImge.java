package com.sportsxdata.adms.model;

/**
 * 用于获取运动员名字和头像的对象
 * @author zyn
 * @date 2018/4/19
 */
public class UserImge {
    String athleteId;
    String name;
    String Image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId;
    }
}


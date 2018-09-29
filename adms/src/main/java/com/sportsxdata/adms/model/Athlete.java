package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Athlete {
    private String id;

    private String admsAthleteGroupId;

    private String admsCoachId;

    private String name;

    private String sex;

    private String birthday;

    private String area;

    private String code;

    private String worldCode;

    private String levelId;

    private String avatar;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String projectName;
    private String organizationName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdmsAthleteGroupId() {
        return admsAthleteGroupId;
    }

    public void setAdmsAthleteGroupId(String admsAthleteGroupId) {
        this.admsAthleteGroupId = admsAthleteGroupId == null ? null : admsAthleteGroupId.trim();
    }

    public String getAdmsCoachId() {
        return admsCoachId;
    }

    public void setAdmsCoachId(String admsCoachId) {
        this.admsCoachId = admsCoachId == null ? null : admsCoachId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getWorldCode() {
        return worldCode;
    }

    public void setWorldCode(String worldCode) {
        this.worldCode = worldCode == null ? null : worldCode.trim();
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
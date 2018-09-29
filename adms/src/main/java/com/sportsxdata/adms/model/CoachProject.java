package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CoachProject {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String admsProjectId;

    private String admsCoachId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getAdmsProjectId() {
        return admsProjectId;
    }

    public void setAdmsProjectId(String admsProjectId) {
        this.admsProjectId = admsProjectId == null ? null : admsProjectId.trim();
    }

    public String getAdmsCoachId() {
        return admsCoachId;
    }

    public void setAdmsCoachId(String admsCoachId) {
        this.admsCoachId = admsCoachId == null ? null : admsCoachId.trim();
    }
}
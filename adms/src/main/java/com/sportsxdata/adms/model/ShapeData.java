package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ShapeData {
    private String id;

    private String admsAthleteId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Date measureTime;

    private String athleteHeight;

    private String athleteWeight;

    private String athleteUpperLimbLength;

    private String athleteLowerExtremityLength;

    private String athleteForearmLength;

    private String xiaoTuiChang;

    private String shangBiWei;

    private String daTuiWei;

    private String athleteBust;

    private String xiaoTuiWei;

    private String athleteHipline;

    private String athleteWaistline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdmsAthleteId() {
        return admsAthleteId;
    }

    public void setAdmsAthleteId(String admsAthleteId) {
        this.admsAthleteId = admsAthleteId == null ? null : admsAthleteId.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(Date measureTime) {
        this.measureTime = measureTime;
    }

    public String getAthleteHeight() {
        return athleteHeight;
    }

    public void setAthleteHeight(String athleteHeight) {
        this.athleteHeight = athleteHeight == null ? null : athleteHeight.trim();
    }

    public String getAthleteWeight() {
        return athleteWeight;
    }

    public void setAthleteWeight(String athleteWeight) {
        this.athleteWeight = athleteWeight == null ? null : athleteWeight.trim();
    }

    public String getAthleteUpperLimbLength() {
        return athleteUpperLimbLength;
    }

    public void setAthleteUpperLimbLength(String athleteUpperLimbLength) {
        this.athleteUpperLimbLength = athleteUpperLimbLength == null ? null : athleteUpperLimbLength.trim();
    }

    public String getAthleteLowerExtremityLength() {
        return athleteLowerExtremityLength;
    }

    public void setAthleteLowerExtremityLength(String athleteLowerExtremityLength) {
        this.athleteLowerExtremityLength = athleteLowerExtremityLength == null ? null : athleteLowerExtremityLength.trim();
    }

    public String getAthleteForearmLength() {
        return athleteForearmLength;
    }

    public void setAthleteForearmLength(String athleteForearmLength) {
        this.athleteForearmLength = athleteForearmLength == null ? null : athleteForearmLength.trim();
    }

    public String getXiaoTuiChang() {
        return xiaoTuiChang;
    }

    public void setXiaoTuiChang(String xiaoTuiChang) {
        this.xiaoTuiChang = xiaoTuiChang == null ? null : xiaoTuiChang.trim();
    }

    public String getShangBiWei() {
        return shangBiWei;
    }

    public void setShangBiWei(String shangBiWei) {
        this.shangBiWei = shangBiWei == null ? null : shangBiWei.trim();
    }

    public String getDaTuiWei() {
        return daTuiWei;
    }

    public void setDaTuiWei(String daTuiWei) {
        this.daTuiWei = daTuiWei == null ? null : daTuiWei.trim();
    }

    public String getAthleteBust() {
        return athleteBust;
    }

    public void setAthleteBust(String athleteBust) {
        this.athleteBust = athleteBust == null ? null : athleteBust.trim();
    }

    public String getXiaoTuiWei() {
        return xiaoTuiWei;
    }

    public void setXiaoTuiWei(String xiaoTuiWei) {
        this.xiaoTuiWei = xiaoTuiWei == null ? null : xiaoTuiWei.trim();
    }

    public String getAthleteHipline() {
        return athleteHipline;
    }

    public void setAthleteHipline(String athleteHipline) {
        this.athleteHipline = athleteHipline == null ? null : athleteHipline.trim();
    }

    public String getAthleteWaistline() {
        return athleteWaistline;
    }

    public void setAthleteWaistline(String athleteWaistline) {
        this.athleteWaistline = athleteWaistline == null ? null : athleteWaistline.trim();
    }
}
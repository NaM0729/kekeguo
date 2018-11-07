package com.kekeguo.admin.model;

import java.util.Date;

public class EntExamArrangeBaseinfo {
    private Integer id;

    private Integer examPlanId;

    private Integer examCourseId;

    private Date registerStart;

    private Date registerEnd;

    private Byte hasExam;

    private Date examTime;

    private String period;

    private Date limitBizDateStart;

    private Date limitBizDateEnd;

    private Byte weight;

    private Date createTime;

    private Date updateTime;

    private String operator;

    private Byte deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamPlanId() {
        return examPlanId;
    }

    public void setExamPlanId(Integer examPlanId) {
        this.examPlanId = examPlanId;
    }

    public Integer getExamCourseId() {
        return examCourseId;
    }

    public void setExamCourseId(Integer examCourseId) {
        this.examCourseId = examCourseId;
    }

    public Date getRegisterStart() {
        return registerStart;
    }

    public void setRegisterStart(Date registerStart) {
        this.registerStart = registerStart;
    }

    public Date getRegisterEnd() {
        return registerEnd;
    }

    public void setRegisterEnd(Date registerEnd) {
        this.registerEnd = registerEnd;
    }

    public Byte getHasExam() {
        return hasExam;
    }

    public void setHasExam(Byte hasExam) {
        this.hasExam = hasExam;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Date getLimitBizDateStart() {
        return limitBizDateStart;
    }

    public void setLimitBizDateStart(Date limitBizDateStart) {
        this.limitBizDateStart = limitBizDateStart;
    }

    public Date getLimitBizDateEnd() {
        return limitBizDateEnd;
    }

    public void setLimitBizDateEnd(Date limitBizDateEnd) {
        this.limitBizDateEnd = limitBizDateEnd;
    }

    public Byte getWeight() {
        return weight;
    }

    public void setWeight(Byte weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
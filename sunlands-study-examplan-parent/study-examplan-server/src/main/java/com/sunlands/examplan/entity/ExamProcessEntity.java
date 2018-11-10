package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 报考流程表实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-08 11:41:02
 */
public class ExamProcessEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 考区
     */
    private String examArea;
    /**
     * 4/10考期
     */
    private Integer examPeriod;
    /**
     * 201904/201910 日期转化成的整形数字，便于查找
     */
    private Integer examStart;
    /**
     * (1、老生，2、新生)
     */
    private Integer examineeFlag;
    /**
     * (1、本科，2、专科)
     */
    private Integer examLevel;
    /**
     * 日期类型(0=正常，1=日不确定，2=年不确定，3=年不确定，但是展示在次年，4=年不确定，但是展示在次次年)
     */
    private Integer dateType;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 事件名称
     */
    private String eventName;
    /**
     * 事件描述
     */
    private String eventDesc;
    /**
     * 链接
     */
    private String eventLink;
    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：考区
     */
    public void setExamArea(String examArea) {
        this.examArea = examArea;
    }

    /**
     * 获取：考区
     */
    public String getExamArea() {
        return examArea;
    }

    /**
     * 设置：4/10考期
     */
    public void setExamPeriod(Integer examPeriod) {
        this.examPeriod = examPeriod;
    }

    /**
     * 获取：4/10考期
     */
    public Integer getExamPeriod() {
        return examPeriod;
    }

    /**
     * 设置：201904/201910 日期转化成的整形数字，便于查找
     */
    public void setExamStart(Integer examStart) {
        this.examStart = examStart;
    }

    /**
     * 获取：201904/201910 日期转化成的整形数字，便于查找
     */
    public Integer getExamStart() {
        return examStart;
    }

    /**
     * 设置：(1、老生，2、新生)
     */
    public void setExamineeFlag(Integer examineeFlag) {
        this.examineeFlag = examineeFlag;
    }

    /**
     * 获取：(1、老生，2、新生)
     */
    public Integer getExamineeFlag() {
        return examineeFlag;
    }

    /**
     * 设置：(1、本科，2、专科)
     */
    public void setExamLevel(Integer examLevel) {
        this.examLevel = examLevel;
    }

    /**
     * 获取：(1、本科，2、专科)
     */
    public Integer getExamLevel() {
        return examLevel;
    }

    /**
     * 设置：日期类型(0=正常，1=日不确定，2=年不确定，3=年不确定，但是展示在次年，4=年不确定，但是展示在次次年)
     */
    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }

    /**
     * 获取：日期类型(0=正常，1=日不确定，2=年不确定，3=年不确定，但是展示在次年，4=年不确定，但是展示在次次年)
     */
    public Integer getDateType() {
        return dateType;
    }

    /**
     * 设置：开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取：开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置：结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取：结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置：开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取：开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置：结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置：事件名称
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 获取：事件名称
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * 设置：事件描述
     */
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    /**
     * 获取：事件描述
     */
    public String getEventDesc() {
        return eventDesc;
    }

    /**
     * 设置：链接
     */
    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    /**
     * 获取：链接
     */
    public String getEventLink() {
        return eventLink;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }
}

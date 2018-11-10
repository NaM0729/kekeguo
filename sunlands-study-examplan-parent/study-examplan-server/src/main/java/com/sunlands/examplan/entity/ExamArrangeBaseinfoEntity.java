package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 考试安排base表实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class ExamArrangeBaseinfoEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 考试计划id
     */
    private Integer examPlanId;
    /**
     * 考试科目id
     */
    private Integer examCourseId;
    /**
     * 报考开始
     */
    private Date registerStart;
    /**
     * 报考结束
     */
    private Date registerEnd;
    /**
     * 是否有考试  0 没有 1  有
     */
    private Integer hasExam;
    /**
     * 考试时间
     */
    private Date examTime;
    /**
     * 考试时间的段（am/pm）
     */
    private String period;
    /**
     * 限制报名时间开始
     */
    private Date limitBizDateStart;
    /**
     * 限制报名时间结束
     */
    private Date limitBizDateEnd;
    /**
     * 分配权重，1代表优先分配，2代表次级分配，3代表最后分配，0代表不主动分配。
     */
    private Integer weight;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
    /**
     *
     */
    private String operator;
    /**
     *
     */
    private Integer deleteFlag;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：考试计划id
     */
    public void setExamPlanId(Integer examPlanId) {
        this.examPlanId = examPlanId;
    }

    /**
     * 获取：考试计划id
     */
    public Integer getExamPlanId() {
        return examPlanId;
    }

    /**
     * 设置：考试科目id
     */
    public void setExamCourseId(Integer examCourseId) {
        this.examCourseId = examCourseId;
    }

    /**
     * 获取：考试科目id
     */
    public Integer getExamCourseId() {
        return examCourseId;
    }

    /**
     * 设置：报考开始
     */
    public void setRegisterStart(Date registerStart) {
        this.registerStart = registerStart;
    }

    /**
     * 获取：报考开始
     */
    public Date getRegisterStart() {
        return registerStart;
    }

    /**
     * 设置：报考结束
     */
    public void setRegisterEnd(Date registerEnd) {
        this.registerEnd = registerEnd;
    }

    /**
     * 获取：报考结束
     */
    public Date getRegisterEnd() {
        return registerEnd;
    }

    /**
     * 设置：是否有考试  0 没有 1  有
     */
    public void setHasExam(Integer hasExam) {
        this.hasExam = hasExam;
    }

    /**
     * 获取：是否有考试  0 没有 1  有
     */
    public Integer getHasExam() {
        return hasExam;
    }

    /**
     * 设置：考试时间
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * 获取：考试时间
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * 设置：考试时间的段（am/pm）
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 获取：考试时间的段（am/pm）
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置：限制报名时间开始
     */
    public void setLimitBizDateStart(Date limitBizDateStart) {
        this.limitBizDateStart = limitBizDateStart;
    }

    /**
     * 获取：限制报名时间开始
     */
    public Date getLimitBizDateStart() {
        return limitBizDateStart;
    }

    /**
     * 设置：限制报名时间结束
     */
    public void setLimitBizDateEnd(Date limitBizDateEnd) {
        this.limitBizDateEnd = limitBizDateEnd;
    }

    /**
     * 获取：限制报名时间结束
     */
    public Date getLimitBizDateEnd() {
        return limitBizDateEnd;
    }

    /**
     * 设置：分配权重，1代表优先分配，2代表次级分配，3代表最后分配，0代表不主动分配。
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取：分配权重，1代表优先分配，2代表次级分配，3代表最后分配，0代表不主动分配。
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置：
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取：
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置：
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取：
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
}

package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 考试计划实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class ExamPlanEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 二级项目id
     */
    private Integer project2Id;
    /**
     * 名称
     */
    private String name;
    /**
     * 考试年份
     */
    private Integer year;
    /**
     * 考试月份
     */
    private Integer month;
    /**
     *
     */
    private Integer totalTermNum;
    /**
     * 是不是当前默认考试计划
     */
    private Integer current;
    /**
     *
     */
    private Integer status;
    /**
     * 备注信息
     */
    private String remark;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
    /**
     * 操作人（最近一次）
     */
    private String operator;
    /**
     *
     */
    private Integer deleteFlag;
    /**
     * 所属考期
     */
    private String examSession;

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
     * 设置：二级项目id
     */
    public void setProject2Id(Integer project2Id) {
        this.project2Id = project2Id;
    }

    /**
     * 获取：二级项目id
     */
    public Integer getProject2Id() {
        return project2Id;
    }

    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：考试年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取：考试年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置：考试月份
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 获取：考试月份
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 设置：
     */
    public void setTotalTermNum(Integer totalTermNum) {
        this.totalTermNum = totalTermNum;
    }

    /**
     * 获取：
     */
    public Integer getTotalTermNum() {
        return totalTermNum;
    }

    /**
     * 设置：是不是当前默认考试计划
     */
    public void setCurrent(Integer current) {
        this.current = current;
    }

    /**
     * 获取：是不是当前默认考试计划
     */
    public Integer getCurrent() {
        return current;
    }

    /**
     * 设置：
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注信息
     */
    public String getRemark() {
        return remark;
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
     * 设置：操作人（最近一次）
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取：操作人（最近一次）
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

    /**
     * 设置：所属考期
     */
    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    /**
     * 获取：所属考期
     */
    public String getExamSession() {
        return examSession;
    }
}

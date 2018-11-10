package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮次规则表，OPEN开关：1开/0关；EXAM_PROVINCE考试计划省份：sch_local_province.id，多个用逗号分隔；ORDER_PERIOD报名时间段：yyyy-MM-dd，多个用逗号分隔；ALLOT同科目精讲轮次未结束时允许分配：1允许/0不允许;EXAM_PLAN限定分配的考期，如1703实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class RoundRuleEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 规则名称
     */
    private String code;
    /**
     * 规则值
     */
    private String value;
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
    private String createUserId;
    /**
     *
     */
    private String operatorId;
    /**
     * 轮次规则表
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
     * 设置：规则名称
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：规则名称
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置：规则值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取：规则值
     */
    public String getValue() {
        return value;
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
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取：
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置：
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取：
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置：轮次规则表
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取：轮次规则表
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
}

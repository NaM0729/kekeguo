package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮次与规则映射表实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class RoundRuleRelEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 轮次ID，关联ent_round
     */
    private Integer roundId;
    /**
     * 轮次规则ID，关联ent_round_rule
     */
    private Integer roundRuleId;
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
     * 有效标志，1有效；0无效
     */
    private Integer validateFlag;
    /**
     * 删除标志，0有效；1删除
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
     * 设置：轮次ID，关联ent_round
     */
    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    /**
     * 获取：轮次ID，关联ent_round
     */
    public Integer getRoundId() {
        return roundId;
    }

    /**
     * 设置：轮次规则ID，关联ent_round_rule
     */
    public void setRoundRuleId(Integer roundRuleId) {
        this.roundRuleId = roundRuleId;
    }

    /**
     * 获取：轮次规则ID，关联ent_round_rule
     */
    public Integer getRoundRuleId() {
        return roundRuleId;
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
     * 设置：有效标志，1有效；0无效
     */
    public void setValidateFlag(Integer validateFlag) {
        this.validateFlag = validateFlag;
    }

    /**
     * 获取：有效标志，1有效；0无效
     */
    public Integer getValidateFlag() {
        return validateFlag;
    }

    /**
     * 设置：删除标志，0有效；1删除
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取：删除标志，0有效；1删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
}

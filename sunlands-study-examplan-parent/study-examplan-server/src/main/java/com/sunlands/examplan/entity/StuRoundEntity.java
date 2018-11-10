package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 学员拥有的轮次实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class StuRoundEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 订单
     */
    private Integer ordId;
    /**
     * 对应的订单明细
     */
    private Integer ordDetailId;
    /**
     * 轮次
     */
    private Integer roundId;
    /**
     *
     */
    private Integer familyId;
    /**
     *
     */
    private Integer productLineId;
    /**
     *
     */
    private Integer productLineSubId;
    /**
     * 有效状态：0失效、1有效
     */
    private Integer status;
    /**
     * 资源性质：普通SRP_NORMAL、赠送SRP_ADDITIONAL
     */
    private String property;
    /**
     * 是否历史导入数据：0否、1是
     */
    private Integer ishistory;
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
     * 设置：订单
     */
    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取：订单
     */
    public Integer getOrdId() {
        return ordId;
    }

    /**
     * 设置：对应的订单明细
     */
    public void setOrdDetailId(Integer ordDetailId) {
        this.ordDetailId = ordDetailId;
    }

    /**
     * 获取：对应的订单明细
     */
    public Integer getOrdDetailId() {
        return ordDetailId;
    }

    /**
     * 设置：轮次
     */
    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    /**
     * 获取：轮次
     */
    public Integer getRoundId() {
        return roundId;
    }

    /**
     * 设置：
     */
    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    /**
     * 获取：
     */
    public Integer getFamilyId() {
        return familyId;
    }

    /**
     * 设置：
     */
    public void setProductLineId(Integer productLineId) {
        this.productLineId = productLineId;
    }

    /**
     * 获取：
     */
    public Integer getProductLineId() {
        return productLineId;
    }

    /**
     * 设置：
     */
    public void setProductLineSubId(Integer productLineSubId) {
        this.productLineSubId = productLineSubId;
    }

    /**
     * 获取：
     */
    public Integer getProductLineSubId() {
        return productLineSubId;
    }

    /**
     * 设置：有效状态：0失效、1有效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：有效状态：0失效、1有效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：资源性质：普通SRP_NORMAL、赠送SRP_ADDITIONAL
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * 获取：资源性质：普通SRP_NORMAL、赠送SRP_ADDITIONAL
     */
    public String getProperty() {
        return property;
    }

    /**
     * 设置：是否历史导入数据：0否、1是
     */
    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }

    /**
     * 获取：是否历史导入数据：0否、1是
     */
    public Integer getIshistory() {
        return ishistory;
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

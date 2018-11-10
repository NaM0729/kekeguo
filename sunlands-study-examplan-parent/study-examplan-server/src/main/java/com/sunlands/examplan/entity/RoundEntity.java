package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 班号|轮次实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class RoundEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 模块
     */
    private Integer moduleId;
    /**
     * 轮次名称
     */
    private String name;
    /**
     * 状态：草稿DRAFT、可用AVAILABLE、禁用FORBIDDEN
     */
    private String statusCode;
    /**
     * 是否开班点,已经废弃，根据rule表中的open判断开班
     */
    private Integer startPointFlag;
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
     * 设置：模块
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取：模块
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * 设置：轮次名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：轮次名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：状态：草稿DRAFT、可用AVAILABLE、禁用FORBIDDEN
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 获取：状态：草稿DRAFT、可用AVAILABLE、禁用FORBIDDEN
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * 设置：是否开班点,已经废弃，根据rule表中的open判断开班
     */
    public void setStartPointFlag(Integer startPointFlag) {
        this.startPointFlag = startPointFlag;
    }

    /**
     * 获取：是否开班点,已经废弃，根据rule表中的open判断开班
     */
    public Integer getStartPointFlag() {
        return startPointFlag;
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

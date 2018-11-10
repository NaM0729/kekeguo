package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 一级项目基础信息实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class Proj1stEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 一级项目名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 显示排序
     */
    private Integer seq;
    /**
     * 状态：可用AVAILABLE、禁用FORBIDDEN
     */
    private String statusCode;
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
     * 新轮次变更flag，=1代表该一级项目下的学员必须进新轮次变更队列
     */
    private Integer newRoundChangeFlag;

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
     * 设置：一级项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：一级项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：显示排序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取：显示排序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置：状态：可用AVAILABLE、禁用FORBIDDEN
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 获取：状态：可用AVAILABLE、禁用FORBIDDEN
     */
    public String getStatusCode() {
        return statusCode;
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

    /**
     * 设置：新轮次变更flag，=1代表该一级项目下的学员必须进新轮次变更队列
     */
    public void setNewRoundChangeFlag(Integer newRoundChangeFlag) {
        this.newRoundChangeFlag = newRoundChangeFlag;
    }

    /**
     * 获取：新轮次变更flag，=1代表该一级项目下的学员必须进新轮次变更队列
     */
    public Integer getNewRoundChangeFlag() {
        return newRoundChangeFlag;
    }
}

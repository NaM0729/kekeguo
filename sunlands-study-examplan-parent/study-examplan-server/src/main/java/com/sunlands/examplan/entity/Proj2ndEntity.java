package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 学院与项目关系表实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class Proj2ndEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 所属一级项目
     */
    private Integer proj1stId;
    /**
     * 二级项目名称
     */
    private String name;
    /**
     * 备注
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
     * 设置：所属一级项目
     */
    public void setProj1stId(Integer proj1stId) {
        this.proj1stId = proj1stId;
    }

    /**
     * 获取：所属一级项目
     */
    public Integer getProj1stId() {
        return proj1stId;
    }

    /**
     * 设置：二级项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：二级项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
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
}

package com.sunlands.examplan.entity;

import java.io.Serializable;

import com.sunlands.examplan.base.entity.DataEntity;

import java.util.Date;

/**
 * 学院实体类
 *
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public class CollegeEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 学院名称
     */
    private String name;
    /**
     * 学院代码，如：狐逻学院HULUO、自变量学院ZBL、小筑学院XZHU
     */
    private String collegeNo;
    /**
     * logo，存储图片路径
     */
    private String logo;
    /**
     * 顶部图片，存储图片路径
     */
    private String picture;
    /**
     *
     */
    private String backPicture;
    /**
     * 所属大区
     */
    private Integer districtId;
    /**
     * 学院简介说明
     */
    private String dsc;
    /**
     * 0：失效、1：可用
     */
    private Integer status;
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
    private String operatorId;
    /**
     *
     */
    private String createUserId;
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
     * 设置：学院名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：学院名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：学院代码，如：狐逻学院HULUO、自变量学院ZBL、小筑学院XZHU
     */
    public void setCollegeNo(String collegeNo) {
        this.collegeNo = collegeNo;
    }

    /**
     * 获取：学院代码，如：狐逻学院HULUO、自变量学院ZBL、小筑学院XZHU
     */
    public String getCollegeNo() {
        return collegeNo;
    }

    /**
     * 设置：logo，存储图片路径
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取：logo，存储图片路径
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置：顶部图片，存储图片路径
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取：顶部图片，存储图片路径
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置：
     */
    public void setBackPicture(String backPicture) {
        this.backPicture = backPicture;
    }

    /**
     * 获取：
     */
    public String getBackPicture() {
        return backPicture;
    }

    /**
     * 设置：所属大区
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取：所属大区
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * 设置：学院简介说明
     */
    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    /**
     * 获取：学院简介说明
     */
    public String getDsc() {
        return dsc;
    }

    /**
     * 设置：0：失效、1：可用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：0：失效、1：可用
     */
    public Integer getStatus() {
        return status;
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

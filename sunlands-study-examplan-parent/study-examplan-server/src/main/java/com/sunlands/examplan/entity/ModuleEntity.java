package com.sunlands.examplan.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.sunlands.examplan.base.entity.DataEntity;

import java.util.Date;

/**
 * 模块实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:20
 */
public class ModuleEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模块主键id
     */
    private Integer id;
    /**
     * 二级项目表主键
     */
    private Integer collegeProjId;
    /**
     * 模块名称
     */
    private String name;
    /**
     * 模块描述
     */
    private String dsc;
    /**
     *
     */
    private BigDecimal price;
    /**
     * 模块类型：选修前导MD_PREVIEW、必修前导MD_REQUIRED_PREVIEW、正课（精讲）MD_NORMAL、串讲MD_CONSTRUE、题海MD_EXERCISES、实操MD_PRACTICAL、其他MD_OTHER
     */
    private String typeCode;
    /**
     * 状态：已创建MD_CREATED、已上架MD_AVAILABLE、已打包MD_PACKAGED、已下架MD_FORBIDDEN
     */
    private String statusCode;
    /**
     * 所属科目
     */
    private Integer subjectId;
    /**
     * 考试科目id
     */
    private Integer courseId;
    /**
     * 创建时间
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
     * 删除标识：0-未删除；1-已删除
     */
    private Integer deleteFlag;

    /**
     * 设置：模块主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：模块主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：二级项目表主键
     */
    public void setCollegeProjId(Integer collegeProjId) {
        this.collegeProjId = collegeProjId;
    }

    /**
     * 获取：二级项目表主键
     */
    public Integer getCollegeProjId() {
        return collegeProjId;
    }

    /**
     * 设置：模块名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：模块名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：模块描述
     */
    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    /**
     * 获取：模块描述
     */
    public String getDsc() {
        return dsc;
    }

    /**
     * 设置：
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置：模块类型：选修前导MD_PREVIEW、必修前导MD_REQUIRED_PREVIEW、正课（精讲）MD_NORMAL、串讲MD_CONSTRUE、题海MD_EXERCISES、实操MD_PRACTICAL、其他MD_OTHER
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * 获取：模块类型：选修前导MD_PREVIEW、必修前导MD_REQUIRED_PREVIEW、正课（精讲）MD_NORMAL、串讲MD_CONSTRUE、题海MD_EXERCISES、实操MD_PRACTICAL、其他MD_OTHER
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 设置：状态：已创建MD_CREATED、已上架MD_AVAILABLE、已打包MD_PACKAGED、已下架MD_FORBIDDEN
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 获取：状态：已创建MD_CREATED、已上架MD_AVAILABLE、已打包MD_PACKAGED、已下架MD_FORBIDDEN
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * 设置：所属科目
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取：所属科目
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 设置：考试科目id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取：考试科目id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
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
     * 设置：删除标识：0-未删除；1-已删除
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取：删除标识：0-未删除；1-已删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
}

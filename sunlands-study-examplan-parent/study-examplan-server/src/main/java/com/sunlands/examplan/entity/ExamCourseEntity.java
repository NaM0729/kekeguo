package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 考试科目实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class ExamCourseEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 区域id/报考省份id
     */
    private Integer areaId;
    /**
     * 目标分数
     */
    private Integer targetScore;
    /**
     * 科目id
     */
    private Integer courseId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
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
     * 是否有效标识位，1代表有效，0代表无效
     */
    private Integer validateFlag;

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
     * 设置：区域id/报考省份id
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取：区域id/报考省份id
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置：目标分数
     */
    public void setTargetScore(Integer targetScore) {
        this.targetScore = targetScore;
    }

    /**
     * 获取：目标分数
     */
    public Integer getTargetScore() {
        return targetScore;
    }

    /**
     * 设置：科目id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取：科目id
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
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
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
     * 设置：是否有效标识位，1代表有效，0代表无效
     */
    public void setValidateFlag(Integer validateFlag) {
        this.validateFlag = validateFlag;
    }

    /**
     * 获取：是否有效标识位，1代表有效，0代表无效
     */
    public Integer getValidateFlag() {
        return validateFlag;
    }
}

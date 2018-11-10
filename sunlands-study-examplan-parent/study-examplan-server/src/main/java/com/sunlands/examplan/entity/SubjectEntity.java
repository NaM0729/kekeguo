package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 学习科目实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:20
 */
public class SubjectEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 科目名称
     */
    private String name;
    /**
     * 性质：政治课SP_ZZ、专业课SP_ZY、文化基础课SP_WJ、其他选修课SP_QT、综合课SP_ZH
     */
    private String property;
    /**
     * 考试方式：笔试SE_W、非笔试SE_NW、论文/毕业设计SE_PAPER
     */
    private String examMode;
    /**
     * 是否选考课：0否、1是
     */
    private Integer isoptional;
    /**
     * 是否证书课：0否、1是
     */
    private Integer iscertificatecourse;
    /**
     * 科目说明
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
     * 是否有知识树，0代表没有，1代表有
     */
    private Integer hasKnowledgeTree;

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
     * 设置：科目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：科目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：性质：政治课SP_ZZ、专业课SP_ZY、文化基础课SP_WJ、其他选修课SP_QT、综合课SP_ZH
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * 获取：性质：政治课SP_ZZ、专业课SP_ZY、文化基础课SP_WJ、其他选修课SP_QT、综合课SP_ZH
     */
    public String getProperty() {
        return property;
    }

    /**
     * 设置：考试方式：笔试SE_W、非笔试SE_NW、论文/毕业设计SE_PAPER
     */
    public void setExamMode(String examMode) {
        this.examMode = examMode;
    }

    /**
     * 获取：考试方式：笔试SE_W、非笔试SE_NW、论文/毕业设计SE_PAPER
     */
    public String getExamMode() {
        return examMode;
    }

    /**
     * 设置：是否选考课：0否、1是
     */
    public void setIsoptional(Integer isoptional) {
        this.isoptional = isoptional;
    }

    /**
     * 获取：是否选考课：0否、1是
     */
    public Integer getIsoptional() {
        return isoptional;
    }

    /**
     * 设置：是否证书课：0否、1是
     */
    public void setIscertificatecourse(Integer iscertificatecourse) {
        this.iscertificatecourse = iscertificatecourse;
    }

    /**
     * 获取：是否证书课：0否、1是
     */
    public Integer getIscertificatecourse() {
        return iscertificatecourse;
    }

    /**
     * 设置：科目说明
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：科目说明
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
     * 设置：是否有知识树，0代表没有，1代表有
     */
    public void setHasKnowledgeTree(Integer hasKnowledgeTree) {
        this.hasKnowledgeTree = hasKnowledgeTree;
    }

    /**
     * 获取：是否有知识树，0代表没有，1代表有
     */
    public Integer getHasKnowledgeTree() {
        return hasKnowledgeTree;
    }
}

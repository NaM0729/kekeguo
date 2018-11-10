package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 科目表，不复用现在的ent_subject，因为含义不一致，现在科目隶属于二级项目实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-07 20:47:19
 */
public class CourseEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 科目id
     */
    private Integer id;
    /**
     * 科目代码
     */
    private String code;
    /**
     * 科目名称
     */
    private String name;
    /**
     * 科目类型id
     */
    private Integer typeId;
    /**
     * 学分
     */
    private Integer credit;
    /**
     * 二级项目id
     */
    private Integer project2Id;
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
     * 设置：科目id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：科目id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：科目代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：科目代码
     */
    public String getCode() {
        return code;
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
     * 设置：科目类型id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取：科目类型id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置：学分
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     * 获取：学分
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * 设置：二级项目id
     */
    public void setProject2Id(Integer project2Id) {
        this.project2Id = project2Id;
    }

    /**
     * 获取：二级项目id
     */
    public Integer getProject2Id() {
        return project2Id;
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
}

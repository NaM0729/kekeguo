package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 专业省份下科目考试轮次表实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-08 11:41:02
 */
public class ExamSessionPlanEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 专业
     */
    private String projectName;
    /**
     * 省份
     */
    private Integer areaId;
    /**
     * 总科目
     */
    private Integer courseNum;
    /**
     * 科目名称
     */
    private String courseName;
    /**
     * 上课时间（月）
     */
    private String classDate;
    /**
     * 考期轮次
     */
    private Integer examSessionNum;
    /**
     * 考期
     */
    private String examSession;
    /**
     * 学历
     */
    private String education;
    /**
     * 考试时间
     */
    private Date examTime;
    /**
     * 考试时间段
     */
    private String period;
    /**
     * 考试年
     */
    private String year;

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
     * 设置：专业
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取：专业
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置：省份
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取：省份
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置：总科目
     */
    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    /**
     * 获取：总科目
     */
    public Integer getCourseNum() {
        return courseNum;
    }

    /**
     * 设置：科目名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 获取：科目名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置：上课时间（月）
     */
    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    /**
     * 获取：上课时间（月）
     */
    public String getClassDate() {
        return classDate;
    }

    /**
     * 设置：考期轮次
     */
    public void setExamSessionNum(Integer examSessionNum) {
        this.examSessionNum = examSessionNum;
    }

    /**
     * 获取：考期轮次
     */
    public Integer getExamSessionNum() {
        return examSessionNum;
    }

    /**
     * 设置：考期
     */
    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    /**
     * 获取：考期
     */
    public String getExamSession() {
        return examSession;
    }

    /**
     * 设置：学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取：学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置：考试时间
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * 获取：考试时间
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * 设置：考试时间段
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 获取：考试时间段
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置：考试年
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取：考试年
     */
    public String getYear() {
        return year;
    }
}

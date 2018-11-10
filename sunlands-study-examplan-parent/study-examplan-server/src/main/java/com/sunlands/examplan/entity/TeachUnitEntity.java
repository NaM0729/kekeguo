package com.sunlands.examplan.entity;

import com.sunlands.examplan.base.entity.DataEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 教学活动表实体类
 *
 * @author _zhouyu
 * @email _zhouyu01@sunlands.com
 * @date 2018-11-08 11:13:44
 */
public class TeachUnitEntity extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 教学类型(M:面授;Z:直播)
     */
    private String teachTypeCode;
    /**
     * 教学单元名称
     */
    private String teachUnitName;
    /**
     * 班次
     */
    private String className;
    /**
     * 上课日期
     */
    private Date attendClassDate;
    /**
     * 上课时间
     */
    private String attendClassTime;
    /**
     * 上课地点
     */
    private String attendClassAddress;
    /**
     * 授课老师
     */
    private String attendClassTeacher;
    /**
     * 老师邮箱
     */
    private String teacherEmail;
    /**
     * 班主任
     */
    private String classManager;
    /**
     * 地图名称
     */
    private String mapName;
    /**
     * 备注
     */
    private String remark;
    /**
     *
     */
    private Date updateTime;
    /**
     * 分校名称
     */
    private String schoolName;
    /**
     * 教材下载地址
     */
    private String downloadUrl;
    /**
     * 提取码
     */
    private String password;
    /**
     *
     */
    private String creator;
    /**
     * 是否开放问答功能区0:不开放,1:开放
     */
    private Integer isOpenQuestion;
    /**
     * 状态(1、有效，0、无效)
     */
    private Integer status;
    /**
     * 课次(面授直播计划)
     */
    private Integer courseNumber;
    /**
     * 营销QQ号
     */
    private String qqCode;
    /**
     * 问卷调查地址
     */
    private String surveyAddress;
    /**
     * 是否有教学异动1、是，0、否
     */
    private Integer isTeachChange;
    /**
     * 是否来自嗨学，1、是，0：否
     */
    private Integer isFromHaixue;
    /**
     * 嗨学网直播课地址
     */
    private String haixueUrl;
    /**
     * 直播课程回放ID
     */
    private String playWebcastid;
    /**
     * 随堂考试卷组ID
     */
    private String quizzesGroupId;
    /**
     * 乐语ID
     */
    private String looyuId;
    /**
     * 小能ID
     */
    private String xiaonengId;
    /**
     * 做作业编号
     */
    private String homeworkId;
    /**
     * 与hadiths课次表关联字段
     */
    private Integer hadithsId;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 备用直播间ID
     */
    private String reserveLiveWebcastid;
    /**
     * 是否启用备用直播间(1、启用，0、未启用)
     */
    private Integer isEnableReserveLive;
    /**
     *
     */
    private Date recordStartTime;
    /**
     * 是否免费，1、是，0、否
     */
    private Integer isFree;
    /**
     * 直播服务商：gensee、展示互动；talk-fun、麦拓通讯
     */
    private String liveProvider;
    /**
     * 麦拓通讯直播间ID
     */
    private String ryeLiveRoomId;
    /**
     * 光慧直播ID
     */
    private String upudayLiveRoomId;
    /**
     * CC视频直播间ID
     */
    private String bokeccLiveRoomId;
    /**
     *
     */
    private Integer couponId;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 课时
     */
    private BigDecimal hour;
    /**
     * 排序号
     */
    private Integer lessonSeq;
    /**
     * 所属模块
     */
    private Integer moduleId;
    /**
     * 所属轮次
     */
    private Integer roundId;
    /**
     * 所属课程单元
     */
    private Integer unitId;
    /**
     * 上课时间
     */
    private String beginTime;
    /**
     * 下课时间
     */
    private String endTime;
    /**
     * 本次教学活动星期名称：周一MON、周二TUE、周三WED、周四THU、周五FRI、周六SAT、周日SUN
     */
    private String weekCode;
    /**
     * 授课教师
     */
    private Integer teacherId;
    /**
     * 助教ID
     */
    private Integer assistantId;
    /**
     *
     */
    private Integer ishistory;
    /**
     * 实时互动课堂标识
     */
    private Integer istraining;
    /**
     * 百家云直播ID
     */
    private String baijiaRoomId;
    /**
     * 是否开启礼物赠送功能（1是，0否）
     */
    private Integer isGiftFunction;
    /**
     * 课程预习帖地址
     */
    private String preparePostUrl;
    /**
     *
     */
    private String playWebcastidReserve;
    /**
     *
     */
    private String liveProviderReplayReserve;
    /**
     *
     */
    private Integer replayState;

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
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
     * 设置：教学类型(M:面授;Z:直播)
     */
    public void setTeachTypeCode(String teachTypeCode) {
        this.teachTypeCode = teachTypeCode;
    }

    /**
     * 获取：教学类型(M:面授;Z:直播)
     */
    public String getTeachTypeCode() {
        return teachTypeCode;
    }

    /**
     * 设置：教学单元名称
     */
    public void setTeachUnitName(String teachUnitName) {
        this.teachUnitName = teachUnitName;
    }

    /**
     * 获取：教学单元名称
     */
    public String getTeachUnitName() {
        return teachUnitName;
    }

    /**
     * 设置：班次
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取：班次
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置：上课日期
     */
    public void setAttendClassDate(Date attendClassDate) {
        this.attendClassDate = attendClassDate;
    }

    /**
     * 获取：上课日期
     */
    public Date getAttendClassDate() {
        return attendClassDate;
    }

    /**
     * 设置：上课时间
     */
    public void setAttendClassTime(String attendClassTime) {
        this.attendClassTime = attendClassTime;
    }

    /**
     * 获取：上课时间
     */
    public String getAttendClassTime() {
        return attendClassTime;
    }

    /**
     * 设置：上课地点
     */
    public void setAttendClassAddress(String attendClassAddress) {
        this.attendClassAddress = attendClassAddress;
    }

    /**
     * 获取：上课地点
     */
    public String getAttendClassAddress() {
        return attendClassAddress;
    }

    /**
     * 设置：授课老师
     */
    public void setAttendClassTeacher(String attendClassTeacher) {
        this.attendClassTeacher = attendClassTeacher;
    }

    /**
     * 获取：授课老师
     */
    public String getAttendClassTeacher() {
        return attendClassTeacher;
    }

    /**
     * 设置：老师邮箱
     */
    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    /**
     * 获取：老师邮箱
     */
    public String getTeacherEmail() {
        return teacherEmail;
    }

    /**
     * 设置：班主任
     */
    public void setClassManager(String classManager) {
        this.classManager = classManager;
    }

    /**
     * 获取：班主任
     */
    public String getClassManager() {
        return classManager;
    }

    /**
     * 设置：地图名称
     */
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    /**
     * 获取：地图名称
     */
    public String getMapName() {
        return mapName;
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
     * 设置：分校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * 获取：分校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置：教材下载地址
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * 获取：教材下载地址
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * 设置：提取码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：提取码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取：
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置：是否开放问答功能区0:不开放,1:开放
     */
    public void setIsOpenQuestion(Integer isOpenQuestion) {
        this.isOpenQuestion = isOpenQuestion;
    }

    /**
     * 获取：是否开放问答功能区0:不开放,1:开放
     */
    public Integer getIsOpenQuestion() {
        return isOpenQuestion;
    }

    /**
     * 设置：状态(1、有效，0、无效)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态(1、有效，0、无效)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：课次(面授直播计划)
     */
    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * 获取：课次(面授直播计划)
     */
    public Integer getCourseNumber() {
        return courseNumber;
    }

    /**
     * 设置：营销QQ号
     */
    public void setQqCode(String qqCode) {
        this.qqCode = qqCode;
    }

    /**
     * 获取：营销QQ号
     */
    public String getQqCode() {
        return qqCode;
    }

    /**
     * 设置：问卷调查地址
     */
    public void setSurveyAddress(String surveyAddress) {
        this.surveyAddress = surveyAddress;
    }

    /**
     * 获取：问卷调查地址
     */
    public String getSurveyAddress() {
        return surveyAddress;
    }

    /**
     * 设置：是否有教学异动1、是，0、否
     */
    public void setIsTeachChange(Integer isTeachChange) {
        this.isTeachChange = isTeachChange;
    }

    /**
     * 获取：是否有教学异动1、是，0、否
     */
    public Integer getIsTeachChange() {
        return isTeachChange;
    }

    /**
     * 设置：是否来自嗨学，1、是，0：否
     */
    public void setIsFromHaixue(Integer isFromHaixue) {
        this.isFromHaixue = isFromHaixue;
    }

    /**
     * 获取：是否来自嗨学，1、是，0：否
     */
    public Integer getIsFromHaixue() {
        return isFromHaixue;
    }

    /**
     * 设置：嗨学网直播课地址
     */
    public void setHaixueUrl(String haixueUrl) {
        this.haixueUrl = haixueUrl;
    }

    /**
     * 获取：嗨学网直播课地址
     */
    public String getHaixueUrl() {
        return haixueUrl;
    }

    /**
     * 设置：直播课程回放ID
     */
    public void setPlayWebcastid(String playWebcastid) {
        this.playWebcastid = playWebcastid;
    }

    /**
     * 获取：直播课程回放ID
     */
    public String getPlayWebcastid() {
        return playWebcastid;
    }

    /**
     * 设置：随堂考试卷组ID
     */
    public void setQuizzesGroupId(String quizzesGroupId) {
        this.quizzesGroupId = quizzesGroupId;
    }

    /**
     * 获取：随堂考试卷组ID
     */
    public String getQuizzesGroupId() {
        return quizzesGroupId;
    }

    /**
     * 设置：乐语ID
     */
    public void setLooyuId(String looyuId) {
        this.looyuId = looyuId;
    }

    /**
     * 获取：乐语ID
     */
    public String getLooyuId() {
        return looyuId;
    }

    /**
     * 设置：小能ID
     */
    public void setXiaonengId(String xiaonengId) {
        this.xiaonengId = xiaonengId;
    }

    /**
     * 获取：小能ID
     */
    public String getXiaonengId() {
        return xiaonengId;
    }

    /**
     * 设置：做作业编号
     */
    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    /**
     * 获取：做作业编号
     */
    public String getHomeworkId() {
        return homeworkId;
    }

    /**
     * 设置：与hadiths课次表关联字段
     */
    public void setHadithsId(Integer hadithsId) {
        this.hadithsId = hadithsId;
    }

    /**
     * 获取：与hadiths课次表关联字段
     */
    public Integer getHadithsId() {
        return hadithsId;
    }

    /**
     * 设置：模块名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * 获取：模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置：备用直播间ID
     */
    public void setReserveLiveWebcastid(String reserveLiveWebcastid) {
        this.reserveLiveWebcastid = reserveLiveWebcastid;
    }

    /**
     * 获取：备用直播间ID
     */
    public String getReserveLiveWebcastid() {
        return reserveLiveWebcastid;
    }

    /**
     * 设置：是否启用备用直播间(1、启用，0、未启用)
     */
    public void setIsEnableReserveLive(Integer isEnableReserveLive) {
        this.isEnableReserveLive = isEnableReserveLive;
    }

    /**
     * 获取：是否启用备用直播间(1、启用，0、未启用)
     */
    public Integer getIsEnableReserveLive() {
        return isEnableReserveLive;
    }

    /**
     * 设置：
     */
    public void setRecordStartTime(Date recordStartTime) {
        this.recordStartTime = recordStartTime;
    }

    /**
     * 获取：
     */
    public Date getRecordStartTime() {
        return recordStartTime;
    }

    /**
     * 设置：是否免费，1、是，0、否
     */
    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    /**
     * 获取：是否免费，1、是，0、否
     */
    public Integer getIsFree() {
        return isFree;
    }

    /**
     * 设置：直播服务商：gensee、展示互动；talk-fun、麦拓通讯
     */
    public void setLiveProvider(String liveProvider) {
        this.liveProvider = liveProvider;
    }

    /**
     * 获取：直播服务商：gensee、展示互动；talk-fun、麦拓通讯
     */
    public String getLiveProvider() {
        return liveProvider;
    }

    /**
     * 设置：麦拓通讯直播间ID
     */
    public void setRyeLiveRoomId(String ryeLiveRoomId) {
        this.ryeLiveRoomId = ryeLiveRoomId;
    }

    /**
     * 获取：麦拓通讯直播间ID
     */
    public String getRyeLiveRoomId() {
        return ryeLiveRoomId;
    }

    /**
     * 设置：光慧直播ID
     */
    public void setUpudayLiveRoomId(String upudayLiveRoomId) {
        this.upudayLiveRoomId = upudayLiveRoomId;
    }

    /**
     * 获取：光慧直播ID
     */
    public String getUpudayLiveRoomId() {
        return upudayLiveRoomId;
    }

    /**
     * 设置：CC视频直播间ID
     */
    public void setBokeccLiveRoomId(String bokeccLiveRoomId) {
        this.bokeccLiveRoomId = bokeccLiveRoomId;
    }

    /**
     * 获取：CC视频直播间ID
     */
    public String getBokeccLiveRoomId() {
        return bokeccLiveRoomId;
    }

    /**
     * 设置：
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取：
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * 设置：副标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 获取：副标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 设置：课时
     */
    public void setHour(BigDecimal hour) {
        this.hour = hour;
    }

    /**
     * 获取：课时
     */
    public BigDecimal getHour() {
        return hour;
    }

    /**
     * 设置：排序号
     */
    public void setLessonSeq(Integer lessonSeq) {
        this.lessonSeq = lessonSeq;
    }

    /**
     * 获取：排序号
     */
    public Integer getLessonSeq() {
        return lessonSeq;
    }

    /**
     * 设置：所属模块
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取：所属模块
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * 设置：所属轮次
     */
    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    /**
     * 获取：所属轮次
     */
    public Integer getRoundId() {
        return roundId;
    }

    /**
     * 设置：所属课程单元
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取：所属课程单元
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * 设置：上课时间
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取：上课时间
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * 设置：下课时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：下课时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置：本次教学活动星期名称：周一MON、周二TUE、周三WED、周四THU、周五FRI、周六SAT、周日SUN
     */
    public void setWeekCode(String weekCode) {
        this.weekCode = weekCode;
    }

    /**
     * 获取：本次教学活动星期名称：周一MON、周二TUE、周三WED、周四THU、周五FRI、周六SAT、周日SUN
     */
    public String getWeekCode() {
        return weekCode;
    }

    /**
     * 设置：授课教师
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取：授课教师
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 设置：助教ID
     */
    public void setAssistantId(Integer assistantId) {
        this.assistantId = assistantId;
    }

    /**
     * 获取：助教ID
     */
    public Integer getAssistantId() {
        return assistantId;
    }

    /**
     * 设置：
     */
    public void setIshistory(Integer ishistory) {
        this.ishistory = ishistory;
    }

    /**
     * 获取：
     */
    public Integer getIshistory() {
        return ishistory;
    }

    /**
     * 设置：实时互动课堂标识
     */
    public void setIstraining(Integer istraining) {
        this.istraining = istraining;
    }

    /**
     * 获取：实时互动课堂标识
     */
    public Integer getIstraining() {
        return istraining;
    }

    /**
     * 设置：百家云直播ID
     */
    public void setBaijiaRoomId(String baijiaRoomId) {
        this.baijiaRoomId = baijiaRoomId;
    }

    /**
     * 获取：百家云直播ID
     */
    public String getBaijiaRoomId() {
        return baijiaRoomId;
    }

    /**
     * 设置：是否开启礼物赠送功能（1是，0否）
     */
    public void setIsGiftFunction(Integer isGiftFunction) {
        this.isGiftFunction = isGiftFunction;
    }

    /**
     * 获取：是否开启礼物赠送功能（1是，0否）
     */
    public Integer getIsGiftFunction() {
        return isGiftFunction;
    }

    /**
     * 设置：课程预习帖地址
     */
    public void setPreparePostUrl(String preparePostUrl) {
        this.preparePostUrl = preparePostUrl;
    }

    /**
     * 获取：课程预习帖地址
     */
    public String getPreparePostUrl() {
        return preparePostUrl;
    }

    /**
     * 设置：
     */
    public void setPlayWebcastidReserve(String playWebcastidReserve) {
        this.playWebcastidReserve = playWebcastidReserve;
    }

    /**
     * 获取：
     */
    public String getPlayWebcastidReserve() {
        return playWebcastidReserve;
    }

    /**
     * 设置：
     */
    public void setLiveProviderReplayReserve(String liveProviderReplayReserve) {
        this.liveProviderReplayReserve = liveProviderReplayReserve;
    }

    /**
     * 获取：
     */
    public String getLiveProviderReplayReserve() {
        return liveProviderReplayReserve;
    }

    /**
     * 设置：
     */
    public void setReplayState(Integer replayState) {
        this.replayState = replayState;
    }

    /**
     * 获取：
     */
    public Integer getReplayState() {
        return replayState;
    }
}

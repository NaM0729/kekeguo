package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FunctionData {
    private String id;

    private String admsAthleteId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Date measureTime;

    private String feiHuoLiang;

    private String sheXueFenShu;

    private String xinZhiShu;

    private String staticBpm;

    private String shouSuoYa;

    private String maxBpm;

    private String maxSheYangLiang;

    private String shuZhangYa;

    private String ruSuanWuYangFa;

    private String hongXiBaoYaJi;

    private String xueNiaoSu;

    private String xueRuSuan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdmsAthleteId() {
        return admsAthleteId;
    }

    public void setAdmsAthleteId(String admsAthleteId) {
        this.admsAthleteId = admsAthleteId == null ? null : admsAthleteId.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(Date measureTime) {
        this.measureTime = measureTime;
    }

    public String getFeiHuoLiang() {
        return feiHuoLiang;
    }

    public void setFeiHuoLiang(String feiHuoLiang) {
        this.feiHuoLiang = feiHuoLiang == null ? null : feiHuoLiang.trim();
    }

    public String getSheXueFenShu() {
        return sheXueFenShu;
    }

    public void setSheXueFenShu(String sheXueFenShu) {
        this.sheXueFenShu = sheXueFenShu == null ? null : sheXueFenShu.trim();
    }

    public String getXinZhiShu() {
        return xinZhiShu;
    }

    public void setXinZhiShu(String xinZhiShu) {
        this.xinZhiShu = xinZhiShu == null ? null : xinZhiShu.trim();
    }

    public String getStaticBpm() {
        return staticBpm;
    }

    public void setStaticBpm(String staticBpm) {
        this.staticBpm = staticBpm == null ? null : staticBpm.trim();
    }

    public String getShouSuoYa() {
        return shouSuoYa;
    }

    public void setShouSuoYa(String shouSuoYa) {
        this.shouSuoYa = shouSuoYa == null ? null : shouSuoYa.trim();
    }

    public String getMaxBpm() {
        return maxBpm;
    }

    public void setMaxBpm(String maxBpm) {
        this.maxBpm = maxBpm == null ? null : maxBpm.trim();
    }

    public String getMaxSheYangLiang() {
        return maxSheYangLiang;
    }

    public void setMaxSheYangLiang(String maxSheYangLiang) {
        this.maxSheYangLiang = maxSheYangLiang == null ? null : maxSheYangLiang.trim();
    }

    public String getShuZhangYa() {
        return shuZhangYa;
    }

    public void setShuZhangYa(String shuZhangYa) {
        this.shuZhangYa = shuZhangYa == null ? null : shuZhangYa.trim();
    }

    public String getRuSuanWuYangFa() {
        return ruSuanWuYangFa;
    }

    public void setRuSuanWuYangFa(String ruSuanWuYangFa) {
        this.ruSuanWuYangFa = ruSuanWuYangFa == null ? null : ruSuanWuYangFa.trim();
    }

    public String getHongXiBaoYaJi() {
        return hongXiBaoYaJi;
    }

    public void setHongXiBaoYaJi(String hongXiBaoYaJi) {
        this.hongXiBaoYaJi = hongXiBaoYaJi == null ? null : hongXiBaoYaJi.trim();
    }

    public String getXueNiaoSu() {
        return xueNiaoSu;
    }

    public void setXueNiaoSu(String xueNiaoSu) {
        this.xueNiaoSu = xueNiaoSu == null ? null : xueNiaoSu.trim();
    }

    public String getXueRuSuan() {
        return xueRuSuan;
    }

    public void setXueRuSuan(String xueRuSuan) {
        this.xueRuSuan = xueRuSuan == null ? null : xueRuSuan.trim();
    }
}
package com.sunlands.examplan.config;

import javax.validation.constraints.NotBlank;

/**
 * 系统配置信息
 *
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年07月31日20:06:22
 */
public class SysConfigEntity {

    private String id;
    @NotBlank(message = "参数名不能为空")
    private String paramKey;
    @NotBlank(message = "参数值不能为空")
    private String paramValue;

    //状态 0：隐藏 1：显示
    private int status;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

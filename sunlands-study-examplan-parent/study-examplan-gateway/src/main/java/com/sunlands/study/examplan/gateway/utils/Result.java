package com.sunlands.study.examplan.gateway.utils;

import java.io.Serializable;

/**
 * 网关返回结果
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月08日10:30:11
 */
public class Result implements Serializable {

    private String code;

    private String mag;

    public Result(String code, String mag) {
        this.code = code;
        this.mag = mag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }
}

package com.sunlands.examplan.utils;

import java.io.Serializable;

/**
 * 结果通知类
 * @Class Name Notify
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年08月02日10:02:13
 */
public class Notify implements Serializable {

	private static final long serialVersionUID = 113106048087052243L;

	private boolean success; //返回结果：true=>结果正确  false=>发生错误
	
	private String msg; //不为空：错误消息
	
	private Object data; //返回数据
	
	private String code; //返回状态码
	
	private Object bak1;		// 备用1


	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getBak1() {
		return bak1;
	}
	public void setBak1(Object bak1) {
		this.bak1 = bak1;
	}
	
}

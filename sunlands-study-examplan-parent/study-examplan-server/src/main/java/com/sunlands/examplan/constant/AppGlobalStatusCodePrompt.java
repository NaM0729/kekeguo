package com.sunlands.examplan.constant;

/**
 * 全局状态码
 *
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年08月02日10:02:13
 */
public interface AppGlobalStatusCodePrompt {
	
	/**
	 * 全局的请求成功
	 */
    public final static String Q_ALL_SUCCESS_CODE = "09999";
    public final static String Q_ALL_SUCCESS_MSG = "请求成功";
    
    /**
	 * 全局的请求失败
	 */
    public final static String Q_ALL_FAIL_CODE = "000001";
    public final static String Q_ALL_FAIL_MSG = "系统异常";


    public final static String Q_ALL_FAIL_PARAMETER_NOTNULL_CODE = "00002";
    public final static String Q_ALL_FAIL_PARAMETER_NOTNULL_MSG = "参数不可为空";

    public final static String Q_ALL_FAIL_PARAMETER_TYPE_ERROR_CODE = "00003";
    public final static String Q_ALL_FAIL_PARAMETER_TYPE_ERROR_MSG = "参数类型错误";
    
    public final static String Q_ALL_FAIL_PARAMETER_ERROR_CODE = "00004";
    public final static String Q_ALL_FAIL_PARAMETER_ERROR_MSG = "参数错误";

}

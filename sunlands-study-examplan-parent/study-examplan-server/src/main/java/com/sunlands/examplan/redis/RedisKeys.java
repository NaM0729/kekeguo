package com.sunlands.examplan.redis;

/**
 * Redis  Keys
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年08月02日10:02:13
 */
public abstract class RedisKeys {

    public static final String USER_SUBJECTIDS = "user_subjectids:";

    public static final String PROVINCE = "province";

    public static final String PROVINCE_CITY = "province_city";

    public static final String CITY = "city:";

    public static final String USER = "user:";

    public static final String USER_APP = "user_app:";
    
    public static final String BACKGROUND = "background:";

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}

package com.sunlands.study.examplan.gateway.utils;

import java.util.Date;

/**
 * 网关工具类
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月07日18:58:21
 */
public class GateWayUtils {


    /**
     * 获取时间戳相差秒数
     * @param now
     * @param timestamp
     * @return
     */
    public static int timeDiffSeconds(Date now,String timestamp){
        Long time = (now.getTime()-Long.valueOf(timestamp)) / 1000;
        return time.intValue();
    }

}

package com.sunlands.study.examplan.gateway.utils;

import java.util.Map;

/**
 * 参数签名类
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月07日15:16:49
 */
public class SignUtils {


    /**
     *
     * @param params 业务参数
     * @return string
     * @throws Exception
     */
    public static String generateSign(Map<String, String> params) throws Exception {
        params.remove("sign");
        Object[] array = params.keySet().toArray();
        java.util.Arrays.sort(array);
        String keyStr = "";
        for (int i = 0; i < array.length; i++) {
            String key = array[i].toString();
            keyStr += key + params.get(key);
        }
        return MD5Utils.md5(keyStr);
    }

}

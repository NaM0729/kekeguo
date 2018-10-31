package com.kekeguo.admin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zhangyuna
 * @date 2018年10月31日10:17:43
 */
public class DataUtil {

    private static final String[] week = new String[]{"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

    /**
     * 通过日期取星期
     * @param str
     * @return
     * @throws ParseException
     */
    public static String getWeek(String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse(str));
        return week[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }


    public static void main(String[] args) throws ParseException {
        DataUtil.getWeek("2018-10-27");
        DataUtil.getWeek("2018-10-28");
        DataUtil.getWeek("2018-10-29");
        DataUtil.getWeek("2018-10-30");
        DataUtil.getWeek("2018-10-31");
    }
}

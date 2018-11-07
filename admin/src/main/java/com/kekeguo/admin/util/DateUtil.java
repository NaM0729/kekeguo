package com.kekeguo.admin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zhangyuna
 * @date 2018年10月31日10:17:43
 */
public class DateUtil {

    private static final String[] week = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 通过日期取星期
     *
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

    public static String getDateNextYear(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(simpleDateFormat.parse(date));
        // 1--星期日 ，2--星期一，3--星期二，4--星期三，5--星期四，6--星期五，7--星期六
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        // 几号
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int weekround = 0;
        if ((days / 7 == 2 && days % 7 == 0) || (days / 7 == 1 && days % 7 != 0) || (days / 7 == 2 && days % 7 == 1)) {
            weekround = 2;
        }
        if ((days / 7 == 3 && days % 7 == 0) || (days / 7 == 2 && days % 7 > 1)) {
            weekround = 3;
        }
        String s = calculationDateNextYear(calendar.get(Calendar.YEAR) + 1, calendar.get(Calendar.MONTH), i, weekround);
        return s;
    }

    private static String calculationDateNextYear(int year, int month, int weeknum, int weekround) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        // 1--星期日 ，2--星期一，3--星期二，4--星期三，5--星期四，6--星期五，7--星期六
        if (1 == i) {
            weekround = weekround + 1;
        }
        calendar.set(Calendar.DAY_OF_WEEK, weeknum);
        int i1 = calendar.get(Calendar.MONTH);
        if (i1 < month) {
            calendar.set(Calendar.DAY_OF_MONTH, weekround * 7 + calendar.get(Calendar.DAY_OF_MONTH));
        } else if (i == 1) {
            calendar.set(Calendar.DAY_OF_MONTH, weekround * 7 + calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, (weekround - 1) * 7 + calendar.get(Calendar.DAY_OF_MONTH));
        }
        return simpleDateFormat.format(calendar.getTime());
    }


    public static void main(String[] args) throws ParseException {
        DateUtil.getWeek("2018-10-27");
        DateUtil.getWeek("2018-10-28");
        DateUtil.getWeek("2018-10-29");
        DateUtil.getWeek("2018-10-30");
        DateUtil.getWeek("2018-10-31");

        String date = "2017-10-14";
        String dateNextYear = DateUtil.getDateNextYear(date);
        System.out.println(dateNextYear);
    }
}

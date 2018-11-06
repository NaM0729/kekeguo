package com.kekeguo.admin.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangyuna
 * @date 2018年11月06日20:15:35
 */
public class test {

    public static void main(String[] args) throws ParseException {
        String date = "2018-04-21";
        String week = DateUtil.getWeek(date);
        int num = 0;
        if("星期六".equals(week)){
            num = 7;
        }
        if("星期日".equals(week)){
            num = 1;
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = s.parse(date);
        calendar.setTime(parse);
        int time = calendar.get(Calendar.DAY_OF_MONTH);
        Date date1 = test.getDate("2019-04-02", time, num);
        System.out.println(s.format(date1));
    }

    public static Date getDate( String date,int week,int num){
        int count =0;
        if(week/7 == 2){
            count = 2;
        }
        if(week/7 == 1){
            count = 1;
        }
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(s.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.set(Calendar.DAY_OF_WEEK, num);
        calendar.set(Calendar.DATE, count*7 + calendar.get(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
}

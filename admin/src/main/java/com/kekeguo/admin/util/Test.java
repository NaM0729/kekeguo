//package com.kekeguo.admin.util;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author zhangyuna
// * @date 2018年11月06日20:15:35
// */
//public class Test {
//
//    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//    public String getDateNextYear(String date) throws ParseException {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(simpleDateFormat.parse(date));
//        // 1--星期日 ，2--星期一，3--星期二，4--星期三，5--星期四，6--星期五，7--星期六
//        int i = calendar.get(Calendar.DAY_OF_WEEK);
//        // 几号
//        int days = calendar.get(Calendar.DAY_OF_MONTH);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        int weekround = 0;
//        if ((days / 7 == 2 && days % 7 == 0) || (days / 7 == 1 && days % 7 != 0) || (days / 7 == 2 && days % 7 == 1)) {
//            weekround = 2;
//        }
//        if ((days / 7 == 3 && days % 7 == 0) || (days / 7 == 2 && days % 7 > 1)) {
//            weekround = 3;
//        }
//        String s = calculationDateNextYear(calendar.get(Calendar.YEAR) + 1, calendar.get(Calendar.MONTH), i, weekround);
//        return s;
//    }
//
//    private String calculationDateNextYear(int year, int month, int weeknum, int weekround) throws ParseException {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, year);
//        calendar.set(Calendar.MONTH, month);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        int i = calendar.get(Calendar.DAY_OF_WEEK);
//        // 1--星期日 ，2--星期一，3--星期二，4--星期三，5--星期四，6--星期五，7--星期六
//        if (1 == i) {
//            weekround = weekround + 1;
//        }
//        calendar.set(Calendar.DAY_OF_WEEK, weeknum);
//        int i1 = calendar.get(Calendar.MONTH);
//        if (i1 < month) {
//            calendar.set(Calendar.DAY_OF_MONTH, weekround * 7 + calendar.get(Calendar.DAY_OF_MONTH));
//        } else if (i == 1) {
//            calendar.set(Calendar.DAY_OF_MONTH, weekround * 7 + calendar.get(Calendar.DAY_OF_MONTH));
//        } else {
//            calendar.set(Calendar.DAY_OF_MONTH, (weekround - 1) * 7 + calendar.get(Calendar.DAY_OF_MONTH));
//        }
//        return simpleDateFormat.format(calendar.getTime());
//    }
//
//
//    public static void main(String[] args) throws ParseException {
//        String date = "2017-10-14";
//        Test test = new Test();
//        String dateNextYear = test.getDateNextYear(date);
//        System.out.println(dateNextYear);
//    }
//
//}

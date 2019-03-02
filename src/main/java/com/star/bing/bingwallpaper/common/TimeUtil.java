package com.star.bing.bingwallpaper.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {

    public static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当前日期
     * @return
     */
    public static String getNow(){
        Calendar calendar = Calendar.getInstance();
        return simpleDateFormat2.format(calendar.getTime());
    }

    /**
     * 当前年
     * @return
     */
    public static String getNowYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) + "";
    }

    /**
     * 当前月
     * @return
     */
    public static String getNowMonth(){
        Calendar calendar = Calendar.getInstance();
        String month = calendar.get(Calendar.MONTH) + 1 + "";
        if (month.length() == 1){
            month = "0" + month;
        }
        return month;
    }
}

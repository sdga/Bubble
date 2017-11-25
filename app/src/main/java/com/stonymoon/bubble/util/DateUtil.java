package com.stonymoon.bubble.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
    public static String CalculateTime(long time) {
        long nowTime = System.currentTimeMillis();  //获取当前时间的毫秒数
        String msg = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定时间格式
        Date setTime = new Date(time);
        long reset = setTime.getTime();   //获取指定时间的毫秒数
        long dateDiff = nowTime - reset;

        if (dateDiff < 0) {
            msg = "输入的时间不对";
        } else {

            long dateTemp1 = dateDiff / 1000; //秒
            long dateTemp2 = dateTemp1 / 60; //分钟
            long dateTemp3 = dateTemp2 / 60; //小时
            long dateTemp4 = dateTemp3 / 24; //天数
            long dateTemp5 = dateTemp4 / 30; //月数
            long dateTemp6 = dateTemp5 / 12; //年数

            if (dateTemp6 > 0) {
                msg = dateTemp6 + "年前";

            } else if (dateTemp5 > 0) {
                msg = dateTemp5 + "个月前";

            } else if (dateTemp4 > 0) {
                msg = dateTemp4 + "天前";

            } else if (dateTemp3 > 0) {
                msg = dateTemp3 + "小时前";

            } else if (dateTemp2 > 0) {
                msg = dateTemp2 + "分钟前";

            } else if (dateTemp1 > 0) {
                msg = "刚刚";

            }
        }
        return msg;

    }


    public static String formatTime(String time) {
        Date date = null;
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance();
        df.applyPattern("yyyy-MM-dd HH:mm:ss");
        try {
            date = df.parse(time);
        } catch (Exception e) {
            LogUtil.e("DateUtil", "解析时间错误错误");

        }
        return CalculateTime(date.getTime());

    }



}

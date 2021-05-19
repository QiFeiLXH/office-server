package com.bsoft.office.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static Date toDate(String dateStr){
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        try{
            date = formater.parse(dateStr);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    public static java.sql.Date toSqlDate(String dateStr){
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        try{
            date = formater.parse(dateStr);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }

    public static Date localDateToDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate dateToLocalDate(Date date){
        return LocalDate.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }

    // 转换easyExcel日期
    public static String getPOIDate(boolean use1904windowing, double value) {
        int wholeDays = (int) Math.floor(value);
        int millisecondsInDay = (int) ((value - (double) wholeDays) * 8.64E7D + 0.5D);
        Calendar calendar = new GregorianCalendar();
        short startYear = 1900;
        byte dayAdjust = -1;
        if (use1904windowing) {
            startYear = 1904;
            dayAdjust = 1;
        } else if (wholeDays < 61) {
            dayAdjust = 0;
        }
        calendar.set(startYear, 0, wholeDays + dayAdjust, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, millisecondsInDay);
        if (calendar.get(Calendar.MILLISECOND) == 0) {
            calendar.clear(Calendar.MILLISECOND);
        }
        java.util.Date date = calendar.getTime();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
        return s.format(date);
    }
}

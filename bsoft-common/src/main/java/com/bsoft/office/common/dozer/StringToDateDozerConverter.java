package com.bsoft.office.common.dozer;

import org.dozer.DozerConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author  hy
 * @date  2020/2/14 16:39
 * @description
 */
public class StringToDateDozerConverter extends DozerConverter<String, Date> {

    public StringToDateDozerConverter() {
        super(String.class, Date.class);
    }

    @Override
    public Date convertTo(String s, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String convertFrom(Date date, String s) {
        return date.toString();
    }
}

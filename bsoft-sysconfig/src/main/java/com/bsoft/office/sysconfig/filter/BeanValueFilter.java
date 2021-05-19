package com.bsoft.office.sysconfig.filter;

import com.alibaba.fastjson.serializer.ValueFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 15:01
 * @Description:
 */
public class BeanValueFilter implements ValueFilter {
    @Override
    public Object process(Object obj, String name, Object value) {
        try {
            if (value instanceof Date){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                value = simpleDateFormat.format(value);
            }
        }catch (Exception e){
            return value;
        }
        return value;
    }
}

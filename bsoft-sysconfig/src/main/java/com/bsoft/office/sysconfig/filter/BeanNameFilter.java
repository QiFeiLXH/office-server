package com.bsoft.office.sysconfig.filter;

import com.alibaba.fastjson.serializer.NameFilter;
import com.bsoft.office.common.annotation.OperLogFieldName;
import java.lang.reflect.Field;

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 9:00
 * @Description: 操作记录返回结果，自定义json key 类似还有ValueFilter 修改值
 */
public class BeanNameFilter implements NameFilter {
    private Field field = null;
    @Override
    public String process(Object obj, String name, Object value) {
        try {
            field = obj.getClass().getDeclaredField(name);
            // 获取注解
            name = field.getAnnotation(OperLogFieldName.class).value();
        }catch (NoSuchFieldException e){
            return name;
        }catch (Exception e){
            return name;
        }
        return name;
    }
}

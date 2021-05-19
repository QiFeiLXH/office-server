package com.bsoft.office.common.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/1/20
 * @description
 */
@Component
public class BsoftConfigProperty {
    @Autowired
    private Environment environment;

    public static Integer cryptFlag;


    @PostConstruct
    public void readConfig() throws Exception {
        Field[] fields = BsoftConfigProperty.class.getFields();
        for(Field field : fields ){
            field.set(null, Integer.valueOf(getProperty(field.getName())));
        }
    }

    private String getProperty(String key) throws UnsupportedEncodingException {
        return new String(environment.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
    }
}

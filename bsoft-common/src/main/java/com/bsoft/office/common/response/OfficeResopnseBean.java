package com.bsoft.office.common.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class OfficeResopnseBean {
    private int code = 200;
    private String msg;
    private Object body;
    private Map<String,Object> properties;

    public static OfficeResopnseBean newSuccessBean(){
        return new OfficeResopnseBean(200,"success");
    }

    public static OfficeResopnseBean newSuccessBean(Object body){
        OfficeResopnseBean bean = new OfficeResopnseBean(200,"success");
        bean.setBody(body);
        return  bean;
    }

    public static OfficeResopnseBean newFailBean(Integer code, String msg){
        return new OfficeResopnseBean(code,msg);
    }

    public OfficeResopnseBean() {
    }

    public OfficeResopnseBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Object getProperty(String nm) {
        return this.properties != null && !this.properties.isEmpty() ? this.properties.get(nm) : null;
    }

    public void setProperty(String name, Object val) {
        if (this.properties == null) {
            this.properties = new HashMap();
        }

        this.properties.put(name, val);
    }
}

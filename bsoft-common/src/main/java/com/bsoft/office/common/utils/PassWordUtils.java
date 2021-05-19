package com.bsoft.office.common.utils;

public class PassWordUtils {
    public static String getPassWord(Integer size){
        String text = "";
        String reference="QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm!@#$%^&*()";
        StringBuffer buffer=new StringBuffer(reference);
        for (int i = 0; i < size; i++) {
            //随机产生0-72的数字
            int ran=(int)(Math.random()*72);
            //buffer.charAt()是索引该位置的字符
            text += buffer.charAt(ran);
        }
        return text;
    }
}

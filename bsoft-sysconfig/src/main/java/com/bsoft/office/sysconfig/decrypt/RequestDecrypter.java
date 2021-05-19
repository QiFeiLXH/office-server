package com.bsoft.office.sysconfig.decrypt;

import com.bsoft.office.common.utils.DESUtils;
import com.bsoft.office.common.utils.HttpServletUtils;
import com.bsoft.office.common.utils.RSAUtils;
import com.bsoft.office.sysconfig.constant.CryptoConstant;
import com.fasterxml.jackson.core.JsonParser;
import lombok.SneakyThrows;
import org.apache.catalina.connector.Request;
import org.apache.commons.codec.binary.Base64;
import org.apache.tomcat.util.buf.ByteChunk;
import org.apache.tomcat.util.buf.MessageBytes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.net.URLDecoder;

public class RequestDecrypter {
    public static void decryptGet(HttpServletRequest request) throws Exception {
        String desPasswd = getDesPasswd(request);
        MessageBytes queryMB = getQueryMB(request);
        decryptUrl(queryMB,desPasswd);
    }

    public static byte[] decryptPost(byte[] data) throws Exception {
        String desPasswd = getDesPasswd(HttpServletUtils.getRequest());
        String input = new String(data).trim(); //去除缓存中的空格
        byte[] decryptData = DESUtils.decrypt(new Base64().decode(input),DESUtils.initKey(desPasswd));
        return decryptData;
    }

    @SneakyThrows
    private static String getDesPasswd(HttpServletRequest request) {
        String enpasswd = request.getHeader("DES-Password");
        return RSAUtils.decryptByPrivateKey(enpasswd, CryptoConstant.PRIVATE_KEY);
    }

    private static MessageBytes getQueryMB(HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {
        org.apache.coyote.Request coyoteRequest = getCoyoteRequest(request);
        Field field = coyoteRequest.getClass().getDeclaredField("queryMB");
        field.setAccessible(true);
        return (MessageBytes) field.get(coyoteRequest);
    }

    private static org.apache.coyote.Request getCoyoteRequest(HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {
        Request connector = getRequest(request);
        Field field = connector.getClass().getDeclaredField("coyoteRequest");
        field.setAccessible(true);
        return (org.apache.coyote.Request) field.get(connector);
    }

    private static Request getRequest(HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = request.getClass();
        Field field = clazz.getDeclaredField("request");
        field.setAccessible(true);
        return (Request) field.get(request);
    }

    private static ByteChunk getByteChunk(MessageBytes queryMB) throws NoSuchFieldException {
        Field field = queryMB.getClass().getDeclaredField("strValue");
        field.setAccessible(true);
        return queryMB.getByteChunk();
    }

    private static void decryptUrl(MessageBytes queryMB,String desPasswd) throws Exception {
        ByteChunk byteChunk = getByteChunk(queryMB);
        if(byteChunk != null && byteChunk.getLength() > 0){
            byte[] url = byteChunk.getBytes();
            byte[] urlData = getUrlData(byteChunk,url);
            String decryptUrlData = getDecryptUrlData(urlData,desPasswd);
            int length = url.length - urlData.length + decryptUrlData.length();
            byte[] newUrlData =  new byte[length];
            System.arraycopy(url,0,newUrlData,0,byteChunk.getStart()); //复制第一部分
            System.arraycopy(decryptUrlData.getBytes(),0,newUrlData,byteChunk.getStart(),decryptUrlData.length()); //复制第二部分
            System.arraycopy(url,byteChunk.getEnd(),newUrlData,byteChunk.getStart()+decryptUrlData.length(),url.length-byteChunk.getEnd()); //复制第三部分
            byteChunk.setBytes(newUrlData,byteChunk.getStart(),decryptUrlData.length()); //设置url字节数组
            queryMB.setString(decryptUrlData);
        }
    }

    private static byte[] getUrlData(ByteChunk byteChunk,byte[] url) {
        byte[] b2 = new byte[byteChunk.getLength()];
        System.arraycopy(url,byteChunk.getStart(),b2,0,byteChunk.getLength());
        return b2;
    }

    private static String getDecryptUrlData(byte[] urlData,String desPasswd) throws Exception {
        String str = URLDecoder.decode(new String(urlData),"utf-8");
        str = str.substring(2);
        byte[] data = DESUtils.decrypt(new Base64().decode(str),DESUtils.initKey(desPasswd));
        return new String(data);
    }
}

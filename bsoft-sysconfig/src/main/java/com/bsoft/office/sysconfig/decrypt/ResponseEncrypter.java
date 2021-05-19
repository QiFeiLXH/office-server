package com.bsoft.office.sysconfig.decrypt;

import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.utils.DESUtils;
import com.bsoft.office.common.utils.HttpServletUtils;
import com.bsoft.office.common.utils.PassWordUtils;
import com.bsoft.office.common.utils.RSAUtils;
import com.bsoft.office.sysconfig.constant.CryptoConstant;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletResponse;

public class ResponseEncrypter {
    public static String encrypt(Object data) throws Exception {
        String password = getDesPassword(); //获取随机密码并设置到header中
        byte[] encryptData = encryptAndSetData(password, data); //加密
        return new String(encryptData);
    }

    private static String getDesPassword() throws Exception {
        HttpServletResponse response = HttpServletUtils.getResponse();
        String password = DESUtils.initKey(PassWordUtils.getPassWord(24));
        String encryptPassword = RSAUtils.encryptByPrivateKey(password, CryptoConstant.PRIVATE_KEY);
        response.setHeader("DES-Password", encryptPassword);
        return password;
    }

    private static byte[] encryptAndSetData(String aesPasswd, Object data) throws Exception {
        String jsonData = JSONUtils.toString(data);
        return new Base64().encode(DESUtils.encrypt(jsonData.getBytes("UTF-8"), aesPasswd));
    }

}

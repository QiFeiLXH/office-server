package com.bsoft.office.common.utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;

/**
 * RSA加密工具
 */
public class RSAUtils {
    // 加密数据和秘钥的编码方式
    public static final String UTF_8 = "UTF-8";

    // 填充方式
    public static final String AES_ALGORITHM = "AES/CFB/PKCS5Padding";
    public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final String RSA_ALGORITHM_NOPADDING = "RSA";

    /**
     * RSA公钥加密
     */
    @SneakyThrows
    public static String encryptByPublicKey(String data, String publicKey) {
        byte[] decoded = Base64.decodeBase64(publicKey);
        PublicKey pubKey = KeyFactory.getInstance(RSA_ALGORITHM_NOPADDING).generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM_NOPADDING);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes(UTF_8)));
    }

    /**
     * RSA私钥解密
     */
    @SneakyThrows
    public static String decryptByPrivateKey(String data, String privateKey) {
        byte[] inputByte = Base64.decodeBase64(data.getBytes(UTF_8));
        byte[] decoded = Base64.decodeBase64(privateKey);
        PrivateKey priKey = KeyFactory.getInstance(RSA_ALGORITHM_NOPADDING).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM_NOPADDING);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        return new String(cipher.doFinal(inputByte));
    }


    /**
     * RSA私钥加密
     */
    @SneakyThrows
    public static String encryptByPrivateKey(String data, String privateKey) {
        byte[] decoded = Base64.decodeBase64(privateKey);
        PrivateKey priKey = KeyFactory.getInstance(RSA_ALGORITHM_NOPADDING).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM_NOPADDING);
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes(UTF_8)));

    }

    /**
     * RSA公钥解密
     */
    @SneakyThrows
    public static String decryptByPublicKey(String data, String publicKey) {
        byte[] inputByte = Base64.decodeBase64(data.getBytes(UTF_8));
        byte[] decoded = Base64.decodeBase64(publicKey);
        PublicKey pubKey =  KeyFactory.getInstance(RSA_ALGORITHM_NOPADDING).generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM_NOPADDING);
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        return new String(cipher.doFinal(inputByte));
    }

    @SneakyThrows
    public static void main(String[] args) {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUigBWIBXlvlXWe5PUDD26GUMWyJm7BfPR+vfV0KncvU3BsOB+S9596ARogvJcphnS7WPsrJJeWjWu1XjFR3wFW3/ODFqb4FKexn4YBvKT3slmSDk3as2roCaBf+oDct0e9Gmu4jmp2/fUlYBRljZevxMaH3DG73Avd6szErIPwQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANSKAFYgFeW+VdZ7k9QMPboZQxbImbsF89H699XQqdy9TcGw4H5L3n3oBGiC8lymGdLtY+yskl5aNa7VeMVHfAVbf84MWpvgUp7GfhgG8pPeyWZIOTdqzaugJoF/6gNy3R70aa7iOanb99SVgFGWNl6/ExofcMbvcC93qzMSsg/BAgMBAAECgYBh163T+C1ceETX2kfxhDkeZObHpE1xFYprDhftrIOmBNe45Q5T1eV1HMx6uF2OXUDiIzqvB7rSCMFR3SAd4Yyrq+s83pdyRuxdhdFFq8tqwgCBwCilOOOUR/PGL0iyZC7vGe6muB1LL1Z8boXp/WyW9rCRnb/+iRrjQWVuUW+saQJBAOzaJnKD+G+4pBv01j7CJHMagHc9HDWvzCqHAtFIYzbCW3kzWzNQUNT5CtM2wFjC5y5AIOpe5jhTCmkPgDBdM28CQQDluKwDw/9ZVFhtNwoKtE7tU7v6eWv1AybBqtjSCpMB3hVJ6j4bdGj1D2vRkyn/RCZm5NuXULvuTor2ZwZWcZfPAkB2GzIg2H4B9+idqDFNijHy07xLuUVf4BHHAxv8kEQpAjHq9hj8NYiZKrajLCIuIMJ25bOEK15Rp9cBHKGnfFIxAkEAxSwD4NuKwWam218BbHykvgk/8FXlto/05Qe6QFY5JcIzrZSzqCb7q1OILILO6j3ZZDmMzUzLcVjS53k4NFwdewJAVK4KjIOlwJE2sB0GTIu110uBjs0pX+zp/BfDhZarMnJ/uebLZbgHBxVb7WIj0rDRnOqEYJ4c2grDA3yROu8YYg==";

        String data1 = DESUtils.initKey(PassWordUtils.getPassWord(24));
        System.out.println(data1);
        String encryptData1 = RSAUtils.encryptByPublicKey(data1, publicKey);
        System.out.println(encryptData1);
        String decryptData1 = RSAUtils.decryptByPrivateKey(encryptData1, privateKey);
        System.out.println(decryptData1);

        String data2 = DESUtils.initKey(PassWordUtils.getPassWord(24));
        System.out.println(data2);
        String encryptData2 = RSAUtils.encryptByPrivateKey(data2, privateKey);
        System.out.println(encryptData2);
        String decryptData2 = RSAUtils.decryptByPublicKey(encryptData2, publicKey);
        System.out.println(decryptData2);
    }
}

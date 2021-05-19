package com.bsoft.office.common.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * DES加密工具
 */
public class DESUtils {

    public static final String VI = "01234567";

    /**
     * 转换密钥
     */
    private static Key toKey(String key) throws Exception {
//        DESKeySpec dks = new DESKeySpec(key.getBytes());
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
//        SecretKey secretKey = keyFactory.generateSecret(dks);


        // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DESede");

        return secretKey;
    }

    /**
     * 解密
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        Key k = toKey(key);
        IvParameterSpec ips = new IvParameterSpec(VI.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, k, ips);

        return cipher.doFinal(data);
    }

    /**
     * 生成密钥
     */
    public static String initKey(String password) throws Exception {
        return initKeyWithPadding(password);
    }

    /**
     * 加密
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        Key k = toKey(key);
        IvParameterSpec ips = new IvParameterSpec(VI.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, k, ips);

        return cipher.doFinal(data);
    }

    /**
     * 不足24位时，通过填充的方式生产密钥
     */
    public static String initKeyWithPadding(String password) throws Exception {
        if (password.length() >= 24) {
            return password;
        } else {
            byte[] bytes =  password.getBytes();
            byte[] result = new byte[24];
            System.arraycopy(bytes,0,result,0,bytes.length);
            return new String(result);
        }
    }

    public static void main(String[] args) throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUigBWIBXlvlXWe5PUDD26GUMWyJm7BfPR+vfV0KncvU3BsOB+S9596ARogvJcphnS7WPsrJJeWjWu1XjFR3wFW3/ODFqb4FKexn4YBvKT3slmSDk3as2roCaBf+oDct0e9Gmu4jmp2/fUlYBRljZevxMaH3DG73Avd6szErIPwQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANSKAFYgFeW+VdZ7k9QMPboZQxbImbsF89H699XQqdy9TcGw4H5L3n3oBGiC8lymGdLtY+yskl5aNa7VeMVHfAVbf84MWpvgUp7GfhgG8pPeyWZIOTdqzaugJoF/6gNy3R70aa7iOanb99SVgFGWNl6/ExofcMbvcC93qzMSsg/BAgMBAAECgYBh163T+C1ceETX2kfxhDkeZObHpE1xFYprDhftrIOmBNe45Q5T1eV1HMx6uF2OXUDiIzqvB7rSCMFR3SAd4Yyrq+s83pdyRuxdhdFFq8tqwgCBwCilOOOUR/PGL0iyZC7vGe6muB1LL1Z8boXp/WyW9rCRnb/+iRrjQWVuUW+saQJBAOzaJnKD+G+4pBv01j7CJHMagHc9HDWvzCqHAtFIYzbCW3kzWzNQUNT5CtM2wFjC5y5AIOpe5jhTCmkPgDBdM28CQQDluKwDw/9ZVFhtNwoKtE7tU7v6eWv1AybBqtjSCpMB3hVJ6j4bdGj1D2vRkyn/RCZm5NuXULvuTor2ZwZWcZfPAkB2GzIg2H4B9+idqDFNijHy07xLuUVf4BHHAxv8kEQpAjHq9hj8NYiZKrajLCIuIMJ25bOEK15Rp9cBHKGnfFIxAkEAxSwD4NuKwWam218BbHykvgk/8FXlto/05Qe6QFY5JcIzrZSzqCb7q1OILILO6j3ZZDmMzUzLcVjS53k4NFwdewJAVK4KjIOlwJE2sB0GTIu110uBjs0pX+zp/BfDhZarMnJ/uebLZbgHBxVb7WIj0rDRnOqEYJ4c2grDA3yROu8YYg==";

        String password = "ZQgI2UY+UjYCtgEX5toV1FJGYf4i08qx+YUa4M6zrJrg4FuxejV3MLlWH1959rTtatv/oyEfE12ZqqS6+1aKo+GdCZZ7EGaEI5K7pyEhXOwu164mblUVZGCFYibdgQU3PvSycyYu4UpUnKenROUrV3ocpqf3f7wXoJ4KRvekm4k=";
        String data = "hdX+Amn2sPWAUA+qs0pz21PMsKsztdyFz/dyF+cOWbaCzMLFIEqqm56fuy4a80Z2uo6mQBuo0LEN2w8w4yhTPdWrnt011z5A";
        String decryptPassword = RSAUtils.decryptByPrivateKey(password, privateKey);
        System.out.println(decryptPassword);
        String decryptData = new String(DESUtils.decrypt(new Base64().decode(data), DESUtils.initKey(decryptPassword)));
        System.out.println(decryptData);
        String encryptData = new String(new Base64().encode(DESUtils.encrypt(decryptData.getBytes("UTF-8"), decryptPassword)));
        System.out.println(encryptData);

    }
}
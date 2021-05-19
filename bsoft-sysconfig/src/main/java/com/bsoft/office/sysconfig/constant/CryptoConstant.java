package com.bsoft.office.sysconfig.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/1/28
 * @description 过滤器加解密跳过路径
 */
public class CryptoConstant {
    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANSKAFYgFeW+VdZ7k9QMPboZQxbImbsF89H699XQqdy9TcGw4H5L3n3oBGiC8lymGdLtY+yskl5aNa7VeMVHfAVbf84MWpvgUp7GfhgG8pPeyWZIOTdqzaugJoF/6gNy3R70aa7iOanb99SVgFGWNl6/ExofcMbvcC93qzMSsg/BAgMBAAECgYBh163T+C1ceETX2kfxhDkeZObHpE1xFYprDhftrIOmBNe45Q5T1eV1HMx6uF2OXUDiIzqvB7rSCMFR3SAd4Yyrq+s83pdyRuxdhdFFq8tqwgCBwCilOOOUR/PGL0iyZC7vGe6muB1LL1Z8boXp/WyW9rCRnb/+iRrjQWVuUW+saQJBAOzaJnKD+G+4pBv01j7CJHMagHc9HDWvzCqHAtFIYzbCW3kzWzNQUNT5CtM2wFjC5y5AIOpe5jhTCmkPgDBdM28CQQDluKwDw/9ZVFhtNwoKtE7tU7v6eWv1AybBqtjSCpMB3hVJ6j4bdGj1D2vRkyn/RCZm5NuXULvuTor2ZwZWcZfPAkB2GzIg2H4B9+idqDFNijHy07xLuUVf4BHHAxv8kEQpAjHq9hj8NYiZKrajLCIuIMJ25bOEK15Rp9cBHKGnfFIxAkEAxSwD4NuKwWam218BbHykvgk/8FXlto/05Qe6QFY5JcIzrZSzqCb7q1OILILO6j3ZZDmMzUzLcVjS53k4NFwdewJAVK4KjIOlwJE2sB0GTIu110uBjs0pX+zp/BfDhZarMnJ/uebLZbgHBxVb7WIj0rDRnOqEYJ4c2grDA3yROu8YYg==";
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUigBWIBXlvlXWe5PUDD26GUMWyJm7BfPR+vfV0KncvU3BsOB+S9596ARogvJcphnS7WPsrJJeWjWu1XjFR3wFW3/ODFqb4FKexn4YBvKT3slmSDk3as2roCaBf+oDct0e9Gmu4jmp2/fUlYBRljZevxMaH3DG73Avd6szErIPwQIDAQAB";

    public static final List<String> PATH = new ArrayList<>() {
        private static final long serialVersionUID = 1L;
        {
            add("showimage");
            add("/auth/login");
            add("/auth/logout");
            add("/auth/checklogon");
            add("/auth/checkenable");
            add("/oauth/callback");
            add("/oauth/autologin");
            add("/code/refresh");
            add("/help/showhelp");
            add("/progressrespot/file/example");
            //add("/employe/sendsms");
            //add("/employe/checksms");
            //add("/employe/checkrecruitmentstatus");
        }
    };

}

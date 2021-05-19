package com.bsoft.office.system.vo;

/**
 * @Author: xucl
 * @DateTime: 2021/1/13 9:14
 * @Description:
 */
public class LoginParamsVO {
    private String username;
    private String password;
    private String inputCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }
}

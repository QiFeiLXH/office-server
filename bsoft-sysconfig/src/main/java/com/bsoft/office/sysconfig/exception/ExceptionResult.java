package com.bsoft.office.sysconfig.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExceptionResult implements Serializable {

    private static final long serialVersionUID = 9022331429770693075L;

    private Integer code;
    private String msg;

    public ExceptionResult(){

    }

    public ExceptionResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}

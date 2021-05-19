package com.bsoft.office.system.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePersonVO implements Serializable {
    private String personId;
    private String personName;
    private String deptId;
    private String deptIdText;
}

package com.bsoft.office.organ.vo;

import lombok.Data;

import java.util.List;

@Data
public class AdministrativeDivisionVO {
    private Integer code;
    private Integer parentCode;
    private String name;
    private Integer flag;
    private Integer level;
    private String zipCode;
    private List<AdministrativeDivisionVO> children;
}

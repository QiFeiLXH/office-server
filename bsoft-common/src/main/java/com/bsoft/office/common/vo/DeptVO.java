package com.bsoft.office.common.vo;

import lombok.Data;

import java.util.List;

@Data
public class DeptVO {
    private String value;
    private String title;
    private String parentId;
    private Integer logout;
    private String simpleCode;
    private List<DeptVO> children;
    private Integer sortBy;
}

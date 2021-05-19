package com.bsoft.office.system.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuVO implements Serializable {
    private Integer id;
    private String title;
    private Integer parentId;
    private Integer sort;
    private String icon;
    private String path;
    private String component;
    private String name;
}

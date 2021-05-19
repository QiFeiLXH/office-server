package com.bsoft.office.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class OfficeMenuVO implements Serializable {
    private Integer id;
    // title
    private String routetitle;
    private Integer parentId;
    private Integer sort;
    private String icon;
    private String path;
    private String component;
    private String name;
    private Integer active;
    private Integer pubFlag;
    private Integer system;
    private List<OfficeMenuVO> children = new ArrayList<>();
    private List<Map> actionEntitySet = new ArrayList<>();
    private List<Integer> actionData = new ArrayList<>();
}

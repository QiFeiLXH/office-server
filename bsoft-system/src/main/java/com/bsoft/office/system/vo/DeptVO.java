package com.bsoft.office.system.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DeptVO{
    private String value;
    private String title;
    private String parentId;
    private Integer logout;
    private String simpleCode;
    private List<DeptVO> children;
    /** 前台树形样式属性 */
    private Map<String,String> scopedSlots = new HashMap<>();

    {
        scopedSlots.put("title","custom");
    }
}

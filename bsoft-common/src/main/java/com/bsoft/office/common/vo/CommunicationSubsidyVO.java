package com.bsoft.office.common.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:24
 * @Description:
 */
public class CommunicationSubsidyVO {
    @OperLogFieldName(value = "通讯补贴ID")
    private Integer id;
    @OperLogFieldName(value = "通讯补贴名称")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

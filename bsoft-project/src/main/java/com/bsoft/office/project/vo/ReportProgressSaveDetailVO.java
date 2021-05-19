package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/4/21 10:04
 * @Description:
 */
public class ReportProgressSaveDetailVO {
    @OperLogFieldName(value = "产品清单id_产品id_节点id")
    private String id;
    @OperLogFieldName(value = "数量")
    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

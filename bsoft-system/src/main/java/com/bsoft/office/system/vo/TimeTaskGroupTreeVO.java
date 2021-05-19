package com.bsoft.office.system.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.bsoft.system.dto.TimeTaskGroupTreeDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 10:14
 * @Version 1.0
 * @Description
 */
public class TimeTaskGroupTreeVO implements Serializable {
    @OperLogFieldName(value = "定时任务树key")
    private Integer key;
    @OperLogFieldName(value = "定时任务树value")
    private String value;
    @OperLogFieldName(value = "定时任务名称")
    private String title;
    @OperLogFieldName(value = "上级ID")
    private Integer parentId;
    @OperLogFieldName(value = "子节点")
    private List<TimeTaskGroupTreeVO> children = new ArrayList<>();

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<TimeTaskGroupTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<TimeTaskGroupTreeVO> children) {
        this.children = children;
    }
}

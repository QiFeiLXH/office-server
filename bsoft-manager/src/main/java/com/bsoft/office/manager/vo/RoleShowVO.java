package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/20 21:18
 * @Description:
 */
public class RoleShowVO {
    @OperLogFieldName(value = "分类")
    private Integer type;
    private Integer id;
    @OperLogFieldName(value = "名称")
    private String name;
    @OperLogFieldName(value = "拼音码")
    private String pinyin;
    private List<RoleVO> children;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public List<RoleVO> getChildren() {
        return children;
    }

    public void setChildren(List<RoleVO> children) {
        this.children = children;
    }
}

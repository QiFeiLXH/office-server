package com.bsoft.office.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HumanDicVO implements Serializable {
    private Integer type;
    private Integer id;
    private String name;
    private String pinyin;
}

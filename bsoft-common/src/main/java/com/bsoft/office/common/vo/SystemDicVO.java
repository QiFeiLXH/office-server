package com.bsoft.office.common.vo;

import lombok.Data;

@Data
public class SystemDicVO {
    private Integer type;
    private Integer id;
    private String name;
    private String pinyin;
    private String saleStage;//dmlb=924 销售阶段
}

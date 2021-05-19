package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

@Data
public class PublicDicVO{
    @OperLogFieldName(value = "字典类别")
    private Integer type;
    @OperLogFieldName(value = "字典值")
    private Integer id;
    @OperLogFieldName(value = "字典名称")
    private String name;
}

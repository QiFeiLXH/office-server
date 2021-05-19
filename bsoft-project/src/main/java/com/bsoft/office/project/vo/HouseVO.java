package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/*
 * @author  hy
 * @date  2020/4/9 15:37
 * @description
 */
@Data
public class HouseVO {
    private Integer id;
    @OperLogFieldName(value = "名称")
    private String name;
    @OperLogFieldName(value = "地址")
    private String address;
    @OperLogFieldName(value = "宿舍长")
    private String houseMaster;
    @OperLogFieldName(value = "宿舍长名称")
    private String houseMasterText;
    @OperLogFieldName(value = "是否常用")
    private Integer isCommon;
}

package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-12-08 17:36
 * @Version 1.0
 * 离职申请单视图
 */
@Data
public class LaborContractQuitViewVO {
    @OperLogFieldName(value = "ID")
    private Integer id;//主键
    @OperLogFieldName(value = "工号")
    private String personId;//工号
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "部门")
    private String dept;
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "离职日期")
    private Date quitDate;


}

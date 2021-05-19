package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 10:59
 * @Description
 */
@Data
public class AccountCaliberVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称*/
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 一级部门id */
    @OperLogFieldName(value = "一级部门id")
    private String parentDeptId;
    /** 一级部门名称 */
    @OperLogFieldName(value = "一级部门名称")
    private String parentDeptName;
    /** 部门类别 */
    @OperLogFieldName(value = "部门类别")
    private Integer deptType;
    @OperLogFieldName(value = "部门类别")
    private String deptTypeText;
    /** 年份 */
    @OperLogFieldName(value = "年份")
    private Integer year;
    /** 核算口径归属 */
    @OperLogFieldName(value = "核算口径归属")
    private String accountCalibers;
    @OperLogFieldName(value = "核算口径归属")
    private String accountCaliberNames;
    /** 登记日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "登记日期")
    private Date registrationDate;
    @OperLogFieldName(value = "费用类别")
    private String costTypes;
    @OperLogFieldName(value = "费用类别名称")
    private String costTypeNames;
    @OperLogFieldName(value = "默认费用类别")
    private Integer  costType;
    @OperLogFieldName(value = "默认费用类别名称")
    private String  costTypeName;

}

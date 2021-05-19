package com.bsoft.office.work.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 15:24
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class BusinessCardViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 工号 */
    @OperLogFieldName(value = "工号")
    private String userId;
    @ColumnWidth(25)
    @ExcelProperty(value = "申请人", index = 1)
    @OperLogFieldName(value = "申请人")
    private String userName;
    /** 简拼 */
    @OperLogFieldName(value = "简拼")
    private String simpleCode;
    /** 部门 */
    @OperLogFieldName(value = "部门")
    private String dept;
    @ColumnWidth(30)
    @ExcelProperty(value = "部门", index = 3)
    @OperLogFieldName(value = "部门")
    private String deptName;
    /** 申请日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(25)
    @ExcelProperty(value = "申请日期", index = 2)
    @OperLogFieldName(value = "申请日期")
    private Date applyDate;
    /** 岗位 */
    @ColumnWidth(30)
    @ExcelProperty(value = "岗位名称", index = 4)
    @OperLogFieldName(value = "岗位")
    private String postName;
    /** 邮箱 */
    @OperLogFieldName(value = "邮箱")
    private String email;
    /** 传真 */
    @OperLogFieldName(value = "传真")
    private String fax;
    /** 电话 */
    @OperLogFieldName(value = "电话")
    private String telephone;
    /** 移动电话 */
    @OperLogFieldName(value = "移动电话")
    private String mobilePhone;
    /** 地址 */
    @OperLogFieldName(value = "地址")
    private String address;
    /** 状态 */
    @OperLogFieldName(value = "状态")
    private Integer status;
    @ColumnWidth(25)
    @ExcelProperty(value = "状态", index = 6)
    @OperLogFieldName(value = "状态")
    private String statusText;
    /** 申请支付日期 */
    @ColumnWidth(25)
    @ExcelProperty(value = "申请支付日期", index = 7)
    @DateTimeFormat("yyyy-MM-dd")
    @OperLogFieldName(value = "申请支付日期")
    private Date applyPayDate;
    /** 项目id */
    @OperLogFieldName(value = "项目id")
    private String projectId;
    @OperLogFieldName(value = "项目id")
    private String projectName;
    /** 费用类别 */
    @OperLogFieldName(value = "费用类别")
    private Integer costType;
    @OperLogFieldName(value = "费用类别")
    private String costTypeText;
    /** 核算口径 */
    @OperLogFieldName(value = "核算口径")
    private Integer accountCaliber;
    @OperLogFieldName(value = "核算口径")
    private String accountCaliberText;
    /** 金额 */
    @ColumnWidth(15)
    @ExcelProperty(value = "金额", index = 5)
    @OperLogFieldName(value = "金额")
    private Double amount;
    /** 流水号 */
    @ColumnWidth(25)
    @ExcelProperty(value = "流水号", index = 0)
    @OperLogFieldName(value = "流水号")
    private String lshid;

}

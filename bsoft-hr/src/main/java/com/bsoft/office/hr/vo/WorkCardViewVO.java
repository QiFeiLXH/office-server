package com.bsoft.office.hr.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:26
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class WorkCardViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 工号 */
    @ExcelProperty(value = "员工编号", index = 0)
    @OperLogFieldName(value = "工号")
    private String personId;
    @ExcelProperty(value = "姓名", index = 1)
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 部门id */
    @ExcelProperty(value = "部门编码", index = 3)
    @OperLogFieldName(value = "部门id")
    private String deptId;
    @ExcelProperty(value = "部门名称", index = 4)
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 拼音 */
    @OperLogFieldName(value = "拼音")
    private String simpleCode;
    /** 报道日期 */
    @OperLogFieldName(value = "报道日期")
    private String startDate;
    /** 到职日期 */
    @OperLogFieldName(value = "到职日期")
    private String dutyDate;
    /** 员工类别 */
    @OperLogFieldName(value = "员工类别")
    private Integer personType;
    /** 卡种类 */
    @OperLogFieldName(value = "卡种类")
    private Integer cardType;
    @ExcelProperty(value = "卡种类", index = 8)
    @OperLogFieldName(value = "卡种类")
    private String cardTypeText;
    /** 是否充值到工牌 */
    @OperLogFieldName(value = "是否充值到工牌")
    private Integer recharge;
    /** 充值金额 */
    @ExcelProperty(value = "当月午餐充值", index = 11)
    @OperLogFieldName(value = "充值金额")
    private Double amount;
    /** 门禁权限 */
    @ExcelProperty(value = "梯控楼层", index = 9)
    @OperLogFieldName(value = "门禁权限")
    private String accessControl;
    /** 状态 */
    @OperLogFieldName(value = "状态")
    private Integer status;
    /** 核实人 */
    @OperLogFieldName(value = "核实人")
    private String verifier;
    /** 核实日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "核实日期")
    private Date verifyDate;
    /** 制作人 */
    @OperLogFieldName(value = "制作人")
    private String maker;
    /** 制作日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "制作日期")
    private Date makeDate;
    /** 门禁开通人 */
    @OperLogFieldName(value = "门禁开通人")
    private String opener;
    /** 门禁开通日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "门禁开通日期")
    private Date openDate;
    /** 领取标志 */
    @OperLogFieldName(value = "领取标志")
    private Integer received;
    /** 是否需要办理工牌 */
    @OperLogFieldName(value = "是否需要办理工牌")
    private Integer workcardFlag;
    /** 人员归属群 */
    @OperLogFieldName(value = "人员归属群")
    private Integer personnelGroup;
    @OperLogFieldName(value = "人员归属群")
    private String personnelGroupText;
    /** 一寸照*/
    @OperLogFieldName(value = "一寸照")
    private Integer oneInchPhoto;
    /** 省*/
    @OperLogFieldName(value = "省")
    private String divisionProvince;
    @OperLogFieldName(value = "省")
    private String divisionProvinceText;
    /** 市*/
    @OperLogFieldName(value = "市")
    private String divisionCity;
    @OperLogFieldName(value = "市")
    private String divisionCityText;
    /** 县*/
    @OperLogFieldName(value = "县")
    private String divisionCounty;
    @OperLogFieldName(value = "县")
    private String divisionCountyText;
    /** 岗位*/
    @OperLogFieldName(value = "岗位")
    private Integer restype;
    @OperLogFieldName(value = "岗位")
    private String restypeText;
    @OperLogFieldName(value = "本地化")
    private Integer localFlag;
    /** 工牌编号*/
    @OperLogFieldName(value = "工牌编号")
    private String workCardNo;
    /** 招聘id*/
    @OperLogFieldName(value = "招聘id")
    private Integer recruitmentId;
    /** 性别*/
    @OperLogFieldName(value = "性别")
    private Integer gender;
    @ExcelProperty(value = "性别", index = 2)
    @OperLogFieldName(value = "性别")
    private String genderText;
    @ExcelProperty(value = "备注", index = 12)
    @OperLogFieldName(value = "备注")
    private String remark;
    @ExcelProperty(value = "门禁楼层", index = 10)
    @OperLogFieldName(value = "门禁楼层")
    private String accessControlStr;
}

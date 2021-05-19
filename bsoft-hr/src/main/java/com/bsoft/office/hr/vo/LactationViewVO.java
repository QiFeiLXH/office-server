package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:04
 * @Description
 */
@Data
public class LactationViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 工号 */
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 姓名 */
    @OperLogFieldName(value = "姓名")
    private String personName;
    /** 拼音简码 */
    @OperLogFieldName(value = "拼音简码")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 哺乳假时长 */
    @OperLogFieldName(value = "哺乳假时长")
    private Double duration;
    /** 开始日期 */
    @OperLogFieldName(value = "开始日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;
    /** 结束日期 */
    @OperLogFieldName(value = "结束日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;
    /** 登记人 */
    @OperLogFieldName(value = "登记人")
    private String submitter;
    /** 登记日期 */
    @OperLogFieldName(value = "登记日期")
    private Date submitDate;
    /** 状态  1未生效  2有效  3失效 */
    @OperLogFieldName(value = "状态")
    private Integer status;

}

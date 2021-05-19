package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

@Data
public class KnowledgeNumViewVO {
    @OperLogFieldName(value = "人员工号")
    private String personId;
    /** 员工姓名 */
    @OperLogFieldName(value = "员工姓名")
    private String personName;
    /** 拼音码 */
    @OperLogFieldName(value = "拼音码")
    private String simpleCode;
    /** 部门id */
    @OperLogFieldName(value = "部门id")
    private String deptId;
    /** 部门名称 */
    @OperLogFieldName(value = "部门名称")
    private String deptName;
    /** 知识数量 */
    @OperLogFieldName(value = "知识数量")
    private Integer knowledgeNumber;

}

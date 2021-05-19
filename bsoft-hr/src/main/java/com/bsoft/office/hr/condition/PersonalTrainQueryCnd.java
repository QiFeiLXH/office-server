package com.bsoft.office.hr.condition;

import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/10 15:59
 * @Description
 */
@Data
public class PersonalTrainQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 输入内容（姓名、拼音简码） */
    private String inputContent;
    /** 排序方式 1授课课时排序   2参训课时排序 */
    private Integer sortFlag;
    /** 年份 */
    private Integer year;
    /** 工号 */
    private String personId;
    /** 部门id */
    private String deptId;
    /** 全部权限 */
    private Boolean allPermission;
}

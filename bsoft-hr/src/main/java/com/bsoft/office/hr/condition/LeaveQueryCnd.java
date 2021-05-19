package com.bsoft.office.hr.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 11:52
 * @Description
 */
@Data
public class LeaveQueryCnd {
    /** 年份 */
    private String year;
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 部门id */
    private String deptId;
    /** 输入内容 */
    private String inputContent;
    /** 全部权限 */
    private Integer allPermission;
    /** 工号 */
    private String personId;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date endDate;
}

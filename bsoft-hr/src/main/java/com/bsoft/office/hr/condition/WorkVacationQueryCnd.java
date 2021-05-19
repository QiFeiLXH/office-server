package com.bsoft.office.hr.condition;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假查询条件
 */
@Data
public class WorkVacationQueryCnd {
    // 年份
    private String year;
    // 部门ID
    private String deptId;
    // 工号
    private String personId;
    // 姓名或拼音简码（小写）
    private String personName;
    // 自动生成标志
    private Integer autoFlag;
    // 时间区间 开始
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss" )
    private Date startDate;
    // 时间区间 结束
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date endDate;
    // 页码
    private Integer pageNo;
    // 每页条数
    private Integer pageSize;
    //假期类型
    private Integer type;
}

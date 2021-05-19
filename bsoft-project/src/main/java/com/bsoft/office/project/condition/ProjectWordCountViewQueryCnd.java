package com.bsoft.office.project.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2021/4/26
 * @description 仅用于项目文档上传情况统计页面模糊查询
 */
@Data
public class ProjectWordCountViewQueryCnd {
    /** 签订日期开始*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date signDateStart;
    /** 签订日期结束*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date signDateEnd;
    /** 部门*/
    private String dept;
    /** 文本搜索*/
    private String inputContent;
    /** 合同号列表（根据进度经理筛选得来）*/
    private String progressManager;
    /** 页码*/
    private Integer pageNo;
    /** 条目*/
    private Integer pageSize;
    /** 文件筛选*/
    private List<String> requireList;
}

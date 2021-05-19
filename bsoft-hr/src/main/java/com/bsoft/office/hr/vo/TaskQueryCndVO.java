package com.bsoft.office.hr.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TaskQueryCndVO {
    /* 代办人工号 */
    private String personId;
    /* 开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    /* 结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    /* 流程定义KEY */
    private String processDefinitionKey;
    /* 流程定义名称 */
    private String processDefinitionName;
    /* 流程实例ID */
    private String processInstanceId;
    /* 页码 */
    private Integer pageNo;
    /* 条目 */
    private Integer pageSize;
    /* 搜索框内容 */
    private String inputContent;
    /* 申请人ID */
    private String applyUserId;
    /* 申请流水ID */
    private String applyId;
    /* 是否完结 */
    private Boolean finished;
    /*发起部门 跟单部门*/
    private String dept;
    /*销售计划  计划日期*/
    private Date planDate;

}

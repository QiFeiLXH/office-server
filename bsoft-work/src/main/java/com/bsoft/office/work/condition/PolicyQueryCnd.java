package com.bsoft.office.work.condition;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Huang GH
 * @date 2021/5/10 17:43
 */
@Data
public class PolicyQueryCnd {
    /**
     * 所属委员会id
     */
    private Integer councilId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private String startTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private String endTime;
    /**
     * 关键字
     */
    private String inputContent;
    /**
     * 标题
     */
    private String title;
    /**
     * 阅读状态
     */
    private Integer readStatus;
    /**
     * 工号
     */
    private String personId;
    /**
     * 员工查询输入框
     */
    private String searchPerson;
    /**
     * 当前页
     */
    private Integer current;
    /**
     * 每页数据量
     */
    private Integer pageSize;
    /**
     * 当前日期
     */
    private String now;


}

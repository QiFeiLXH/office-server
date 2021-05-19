package com.bsoft.office.hr.condition;

import lombok.Data;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/16 9:51
 * @Description
 */
@Data
public class WorkCardQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 是否充值 */
    private List<Integer> recharge;
    /** 单选选择 */
    private Integer flag;
    /** 日期 */
    private String dateStr;

}

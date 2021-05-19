package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 13:05
 * @Description
 */
@Data
public class CompanySocialMeeterViewVO {
    /** 社保缴纳地id */
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 社保缴纳地编码 */
    @OperLogFieldName(value = "社保缴纳地编码")
    private String code;
    /** 社保缴纳地名称 */
    @OperLogFieldName(value = "社保缴纳地名称")
    private String placeName;
    /** 社保缴纳地简称 */
    @OperLogFieldName(value = "社保缴纳地简称")
    private String abbreviation;
    /** 社保缴纳地简拼 */
    @OperLogFieldName(value = "社保缴纳地简拼")
    private String simpleCode;
    /** 子公司*/
    @OperLogFieldName(value = "子公司")
    private Integer subsidiary;
    /** 是否社保缴纳地公司*/
    @OperLogFieldName(value = "是否社保缴纳地公司")
    private Integer socialCompanyFlag;
    /** 社保对接人工号 */
    @OperLogFieldName(value = "社保对接人工号")
    private String meeter;
    /** 社保对接人姓名 */
    @OperLogFieldName(value = "社保对接人姓名")
    private String meeterName;
    /** 注销标志 */
    @OperLogFieldName(value = "注销标志")
    private Integer signOff;

}

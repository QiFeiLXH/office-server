package com.bsoft.office.common.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/9/11
 * @description 公用代码字典
 */
@Data
public class PublicDicVO implements Serializable {
    /* 代码类别 */
    @OperLogFieldName(value = "代码类别")
    private Integer type;
    /* 识别ID */
    @OperLogFieldName(value = "识别ID")
    private Integer id;
    /* 代码名称 */
    @OperLogFieldName(value = "代码名称")
    private String name;
    /* 拼音码 */
    @OperLogFieldName(value = "拼音码")
    private String pinyin;
    /* 状态 */
    @OperLogFieldName(value = "状态")
    private Integer personflag;
    /* 登记日期 */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "登记日期")
    private Date registerDate;
    /* 登记人 */
    @OperLogFieldName(value = "登记人")
    private Integer Registrant;
}

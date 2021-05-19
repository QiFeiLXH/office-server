package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class KnowledgeVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "工号")
    private String personId;
    /** 知识贡献 */
    @OperLogFieldName(value = "知识贡献")
    private String catalog;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @OperLogFieldName(value = "完成时间")
    /** 完成时间 */
    private Date finishDate;
    /** 概要 */
    @OperLogFieldName(value = "概要")
    private String outline;
    /** 第几作者 */
    @OperLogFieldName(value = "第几作者")
    private String author;
    /** 是否代表作 */
    @OperLogFieldName(value = "是否代表作")
    private Integer master;
    /** 附件id */
    @OperLogFieldName(value = "附件id")
    private Integer enclosure;
    /** 附件名 */
    @OperLogFieldName(value = "附件名")
    private String enclosureName;

}

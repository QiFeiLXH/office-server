package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class WorkCertificateVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "工号")
    private String personId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    /** 证书获取时间 */
    @OperLogFieldName(value = "证书获取时间")
    private Date getDate;
    /** 证书名称 */
    @OperLogFieldName(value = "证书名称")
    private String cerName;
    /** 证书编号 */
    @OperLogFieldName(value = "证书编号")
    private String cerNum;
    /** 颁证机构 */
    @OperLogFieldName(value = "颁证机构")
    private String organ;
    /** 附件id */
    @OperLogFieldName(value = "附件id")
    private Integer enclosure;
}

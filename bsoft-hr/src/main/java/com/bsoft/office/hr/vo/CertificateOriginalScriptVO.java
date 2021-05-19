package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @author: zy
 * @date: 2020/9/10
 */
@Data
public class CertificateOriginalScriptVO {
    /* id */
    @OperLogFieldName(value = "ID")
    private String id;
    /* 证书名称 */
    @OperLogFieldName(value = "证书名称")
    private String name;
    /* 证书类别 */
    @OperLogFieldName(value = "证书类别")
    private Integer type;
    /* 类别名称 */
    @OperLogFieldName(value = "类别名称")
    private String typeName;
    /* 注销标志 */
    @OperLogFieldName(value = "注销标志")
    private Integer logoff;
    /* 保管员id */
    @OperLogFieldName(value = "保管员id")
    private String archivist;
    /* 保管员姓名 */
    @OperLogFieldName(value = "保管员姓名")
    private String archivistName;
}

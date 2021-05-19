package com.bsoft.office.hr.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/9/10
 */
@Data
public class CertificateOriginalScriptQueryCnd {
    /* 证书名称 */
    private String name;
    /* 证书类别 */
    private Integer type;
    /* 注销标志 */
    private Integer logoff;
    /* 保管员 */
    private Integer archivist;
    /* 页码 */
    private Integer pageNo;
    /* 条目 */
    private Integer pageSize;
}

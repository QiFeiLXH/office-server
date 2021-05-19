package com.bsoft.office.system.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExportLogVO {
    /** 主键 */
    private Integer id;
    /** 系统 */
    private Integer system;
    /** 菜单id */
    private String menuId;
    /** 备注 */
    private String context;
    /** 用户id */
    private String personId;
    /** 导出日期 */
    private Date exportDate;
}
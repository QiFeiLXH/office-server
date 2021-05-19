package com.bsoft.office.common.condition;

import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/4 17:34
 * @Description 用于系统导出日志所需的参数接收对象
 */
@Data
public class ExportLogParams {
    /** 导出的系统 */
    private Integer system;
    /** 菜单id */
    private String menuId;
    /** 用户id */
    private String personId;
    /** 备注 */
    private String context;
}

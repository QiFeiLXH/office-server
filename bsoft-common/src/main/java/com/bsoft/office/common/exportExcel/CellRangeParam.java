package com.bsoft.office.common.exportExcel;

import lombok.Data;

/**
 * @author: zy
 * @date: 2021/2/22
 * @description 设置表格下拉框的参数
 */
@Data
public class CellRangeParam {
    /** 起始行*/
    private Integer firstRow;
    /** 结束行*/
    private Integer lastRow;
    /** 起始列*/
    private Integer firstCol;
    /** 结束列*/
    private Integer lastCol;
    /** 字典*/
    private String[] dicList;

    public CellRangeParam() {}

    public CellRangeParam(Integer firstRow, Integer lastRow, Integer firstCol, Integer lastCol, String[] dicList) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.firstCol = firstCol;
        this.lastCol = lastCol;
        this.dicList = dicList;
    }
}

package com.bsoft.office.common.exportExcel;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/25
 * @description 销售计划导入模板
 */
public class SalesPlanCellWriteHandler implements CellWriteHandler {
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean isHead) {
        // 设置单元格格式为文本，防止日期等被自定义格式化
        if (!isHead) {
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            CellStyle cellStyle = workbook.createCellStyle();
            DataFormat format = workbook.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("@"));
            cell.setCellStyle(cellStyle);//设置单元格格式为"文本"
//            cell.setCellType(HSSFCell.CELL_TYPE_STRING); // 方法过时
            cell.setCellType(CellType.STRING);
        }
    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> list, Cell cell, Head head, Integer integer, Boolean isHead) {
        if (!isHead && cell.getColumnIndex() == 0 && cell.getRowIndex() == 6) {
            cell.setCellValue("填表说明：\n" +
                    "1、黄色底色内容必填\n" +
                    "2、日期格式请与示例保持一致\n" +
                    "3、导入前请将本行及示例数据删除");
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            // 设置行高方便显示
            writeSheetHolder.getSheet().getRow(5).setHeight((short)300);
            writeSheetHolder.getSheet().getRow(6).setHeight((short)1200);
            // 合并单元格
            writeSheetHolder.getSheet().addMergedRegion(new CellRangeAddress(6,6,0,5));
            CellStyle cellStyle = workbook.createCellStyle();
            // 设置文本换行
            cellStyle.setWrapText(true);
            // 水平居左
            cellStyle.setAlignment(HorizontalAlignment.GENERAL);
            cell.setCellStyle(cellStyle);
        }
    }
}

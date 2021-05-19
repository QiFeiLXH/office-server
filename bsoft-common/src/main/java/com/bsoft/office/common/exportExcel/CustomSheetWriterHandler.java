package com.bsoft.office.common.exportExcel;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.util.List;

/**
 * @author: zy
 * @date: 2021/2/22
 * @description
 */
public class CustomSheetWriterHandler implements SheetWriteHandler {
    private List<CellRangeParam> cellRangeParams;

    public CustomSheetWriterHandler() {}

    public CustomSheetWriterHandler(List<CellRangeParam> cellRangeParams) {
        this.cellRangeParams = cellRangeParams;
    }

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        this.cellRangeParams.forEach(item -> {
            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(item.getFirstRow(), item.getLastRow(), item.getFirstCol(), item.getLastCol());
            DataValidationHelper helper = writeSheetHolder.getSheet().getDataValidationHelper();
            DataValidationConstraint constraint = helper.createExplicitListConstraint(item.getDicList());
            DataValidation dataValidation = helper.createValidation(constraint, cellRangeAddressList);
            writeSheetHolder.getSheet().addValidationData(dataValidation);
        });

       /* // 区间设置 第一列第一行和第二行的数据。由于第一行是头，所以第一、二行的数据实际上是第二三行
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(1, 999, 0, 0);
        DataValidationHelper helper = writeSheetHolder.getSheet().getDataValidationHelper();
        DataValidationConstraint constraint = helper.createExplicitListConstraint(new String[] {"测试1", "测试2"});
        DataValidation dataValidation = helper.createValidation(constraint, cellRangeAddressList);
        writeSheetHolder.getSheet().addValidationData(dataValidation);

        CellRangeAddressList cellRangeAddressList1 = new CellRangeAddressList(1, 999, 2, 2);
        DataValidationHelper helper1 = writeSheetHolder.getSheet().getDataValidationHelper();
        DataValidationConstraint constraint1 = helper1.createExplicitListConstraint(new String[] {"测试1", "测试2"});
        DataValidation dataValidation1 = helper1.createValidation(constraint1, cellRangeAddressList1);
        writeSheetHolder.getSheet().addValidationData(dataValidation1);
*/
    }
}

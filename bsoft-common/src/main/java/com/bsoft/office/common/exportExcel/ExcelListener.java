package com.bsoft.office.common.exportExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.metadata.Cell;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/20 12:46
 * @Description Excel监听器
 */
public class ExcelListener<T> extends AnalysisEventListener<T> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExcelListener.class);
    List<T> datas = new ArrayList<>();
    List<Map<Integer, Cell>> wrongDatas = new ArrayList<>();

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param t one row value.
     * @param analysisContext
     */
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        // 防止空的脏数据
        if (!JSONObject.toJSONString(t).equals("{}")) {
            datas.add(t);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    /**
     * 在转换异常 获取其他异常下会调用本接口。抛出异常则停止读取。如果这里不抛出异常则 继续读取下一行。
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        LOGGER.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        Map<Integer, Cell> cellMap = context.readRowHolder().getCellMap();
        wrongDatas.add(cellMap);
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;

            LOGGER.error("第{}行，第{}列解析异常", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex());
        }
    }

    public List<Map<Integer, Cell>> getWrongDatas() {
        return wrongDatas;
    }

    public void setWrongDatas(List<Map<Integer, Cell>> wrongDatas) {
        this.wrongDatas = wrongDatas;
    }
}

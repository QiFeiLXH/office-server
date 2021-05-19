package com.bsoft.office.common.exportExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Cell;
import com.bsoft.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/20 12:31
 * @Description
 */
public class ExcelUtils {
    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel    文件
     * @param clazz 实体类映射
     * @return Excel 数据 list
     */
    public static <T> List<T> readExcel(MultipartFile excel, Class clazz, ExcelListener<T> excelListener) throws IOException {
        ExcelReader reader = getReader(excel, clazz, excelListener);
        if (reader == null) {
            return null;
        }
        reader.readAll();
        return excelListener.getDatas();
    }
    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel    文件
     * @param clazz 实体类映射
     * @return Excel 数据 list
     */
    public static <T> List<Map<Integer, Cell>> readFailedExcel(MultipartFile excel, Class clazz, ExcelListener<T> excelListener) throws IOException {
        ExcelReader reader = getReader(excel, clazz, excelListener);
        if (reader == null) {
            return null;
        }
        reader.readAll();
        return excelListener.getWrongDatas();
    }


    /**
     * 返回 ExcelReader
     * @param excel 需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     * @throws IOException
     */
    private static <T> ExcelReader getReader(MultipartFile excel, Class clazz, ExcelListener<T> excelListener) throws IOException {
        String filename = excel.getOriginalFilename();
        if(filename != null && (filename.toLowerCase().endsWith(".xls") || filename.toLowerCase().endsWith(".xlsx"))){
            InputStream is = new BufferedInputStream(excel.getInputStream());
            return EasyExcel.read(is, clazz, excelListener).build();

        }else{
            throw new ServiceException("导入的文件格式不正确！");
        }
    }
}

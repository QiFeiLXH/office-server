package com.bsoft.office.common.exportExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.bsoft.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

public class ExportExcel {
    private static final Logger logger = LoggerFactory.getLogger(ExportExcel.class);
    private static ExcelWriter writer = null;
    private static OutputStream out = null;

    @Deprecated
    public static void export(List s, Class clz, String fileName, HttpServletResponse response){
        try {
            out = response.getOutputStream();
            writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            Sheet sheet = new Sheet(1, 0, clz);
            sheet.setSheetName(fileName);
            writer.write(s, sheet);
            out.flush();
        } catch (Exception e) {
            throw new ServiceException("导出Excel出错！" + e.getMessage());
        } finally {
            if (writer != null){
                writer.finish();
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new ServiceException("导出Excel出错！" + e.getMessage());
                }
            }
        }
    }


    public static void doExport(List s, Class clz, String fileName, HttpServletResponse response){
        try {
            out = response.getOutputStream();

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            EasyExcel.write(out,clz).sheet(fileName).doWrite(s);
            out.flush();
        } catch (Exception e) {
            throw new ServiceException("导出Excel出错！" + e.getMessage());
        } finally {
            if (writer != null){
                writer.finish();
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new ServiceException("导出Excel出错！" + e.getMessage());
                }
            }
        }
    }

    public static void exportWithCustomStyle(List s, Class clz, String fileName, CellWriteHandler cellWriteHandler,HttpServletResponse response){
        if (cellWriteHandler == null) {
            throw new ServiceException("CellWriteHandler 不能为空！");
        }
        try {
            out = response.getOutputStream();

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            EasyExcel.write(out,clz).registerWriteHandler(cellWriteHandler).sheet(fileName).doWrite(s);
            out.flush();
        } catch (Exception e) {
            throw new ServiceException("导出Excel出错！" + e.getMessage());
        } finally {
            if (writer != null){
                writer.finish();
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new ServiceException("导出Excel出错！" + e.getMessage());
                }
            }
        }
    }


    /**
     * 导出EXCEL
     * @param list 数据
     * @param clz 数据的类型
     * @param fileName excel的文件名
     * @param sheetWriteHandler 设置单元格下拉框选项（可单独为空）
     * @param cellWriteHandler 设置底端说明（可单独为空）
     * @param response
     */
    public static void doExportWithCustomStyle(List list, Class clz, String fileName, SheetWriteHandler sheetWriteHandler, CellWriteHandler cellWriteHandler, HttpServletResponse response){
        if (sheetWriteHandler == null && cellWriteHandler == null) {
            throw new ServiceException("SheetWriteHandler 和 CellWriteHandler 不能同时为空！");
        }

        try {
            out = response.getOutputStream();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(out,clz);
            if (sheetWriteHandler != null) {
                excelWriterBuilder.registerWriteHandler(sheetWriteHandler);
            }
            if (cellWriteHandler != null){
                excelWriterBuilder.registerWriteHandler(cellWriteHandler);
            }
            excelWriterBuilder.sheet(fileName).doWrite(list);
            out.flush();
        } catch (Exception e) {
            throw new ServiceException("导出Excel出错！" + e.getMessage());
        } finally {
            if (writer != null){
                writer.finish();
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new ServiceException("导出Excel出错！" + e.getMessage());
                }
            }
        }
    }

    /**
     * 非对象bean的Excel导出
     * @param map 包含“head”表头（LinkedHashMap<String, String>），“data”（List<Map<String, Object>>），head的key与data数据的key对应
     * @param fileName 文件名称
     * @param response
     */
    public static void mapExport(Map map, String fileName, HttpServletResponse response){
        try {
            out = response.getOutputStream();
            writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            LinkedHashMap<String, String> head = (LinkedHashMap) map.get("head");
            List<Map<String, Object>> data = (List<Map<String, Object>>) map.get("data");
            List<List<String>> headColumns = new ArrayList<>();
            List<String> headColumnsKey = new ArrayList<>();
            head.forEach((k,v) -> {
                headColumnsKey.add(k);
                headColumns.add(Collections.singletonList(v));
            });

            List<List<Object>> records = new ArrayList<>();
            List<Object> record = null;

            for (Map<String, Object> item : data) {
                record = new ArrayList<>();
                for (String column : headColumnsKey) {
                    if (item.containsKey(column) && item.get(column) != null) {
                        record.add(item.get(column).toString());
                    } else {
                        record.add("");
                    }
                }
                records.add(record);
            }

            Sheet sheet = new Sheet(1, 0);
            sheet.setHead(headColumns);
            sheet.setSheetName(fileName);
            writer.write1(records, sheet);
            out.flush();
        } catch (Exception e) {
            throw new ServiceException("导出Excel出错！" + e.getMessage());
        } finally {
            if (writer != null){
                writer.finish();
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new ServiceException("导出Excel出错！" + e.getMessage());
                }
            }
        }
    }

    public static byte[] transformListToBytes(List s, Class clz, String fileName){
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            EasyExcel.write(out,clz).sheet(fileName).doWrite(s);
            return out.toByteArray();

    }

}

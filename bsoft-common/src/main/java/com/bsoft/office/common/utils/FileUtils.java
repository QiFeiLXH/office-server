package com.bsoft.office.common.utils;

import com.bsoft.common.dto.FileServerDefinitionDTO;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/21 11:15
 * @Description 文件工具类
 */
public class FileUtils {
    private static final int BUFFER_SIZE = 2 * 1024;

    /**
     * 单文件压缩
     *
     * @param file             待压缩的文件
     * @param out              压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZipWithSingleFile(FileServerDefinitionDTO file, OutputStream out)
            throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            compressToZip(file, zos, file.getFileName());
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from FileUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件列表压缩
     *
     * @param files 需要压缩的文件列表
     * @param out      压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZipWithMultiFiles(List<FileServerDefinitionDTO> files, OutputStream out) throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            for (FileServerDefinitionDTO file : files) {
                compressToZip(file, zos, file.getFileName());
            }
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from FileUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 压缩方法
     *
     * @param file       源文件
     * @param zos        zip输出流
     * @param name       压缩后的名称
     * @throws Exception
     */
    private static void compressToZip(FileServerDefinitionDTO file, ZipOutputStream zos, String name) throws Exception {
        byte[] buf = new byte[BUFFER_SIZE];

        ByteArrayInputStream bais = new ByteArrayInputStream(file.getData());
        // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
        zos.putNextEntry(new ZipEntry(name));
        // copy文件到zip输出流中
        int len;
        while ((len = bais.read(buf)) != -1) {
            zos.write(buf, 0, len);
        }
        // Complete the entry
        zos.closeEntry();
        bais.close();
    }

    /**
     * 获取文件后缀 eg：xls, ppt etc
     * @param fileName 文件名称
     */
    public static String getFileSuffix (String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}

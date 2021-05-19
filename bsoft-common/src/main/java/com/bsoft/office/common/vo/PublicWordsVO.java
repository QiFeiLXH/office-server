package com.bsoft.office.common.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Xuhui Lin
 * @Description:
 */
@Data
public class PublicWordsVO{
    private Integer id;
    /** 主表ID */
    private Integer mainId;
    /** 菜单id */
    private Integer menuId;
    /** 类别 */
    private Integer type;
    /** 文件名称 */
    private String fileName;
    /** 文件大小 */
    private Double fileSize;
    /** 上传人 */
    private String uploader;
    /** 上传日期 */
    private Date uploadDate;
    /** 文件服务器上的文件id */
    private Integer fileId;
    /** 文件内容 */
    private byte[] fileBytes;
    /** 区别不同菜单下的同一份文档查看下载功能 */
    private Integer wordType;
}

package com.bsoft.office.sales.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Xuhui Lin
 * @Description:
 */
@Data
public class PublicWordsVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 主表ID */
    @OperLogFieldName(value = "主表ID")
    private Integer mainId;
    /** 菜单id */
    @OperLogFieldName(value = "菜单id")
    private Integer menuId;
    /** 类别 */
    @OperLogFieldName(value = "类别")
    private Integer type;
    /** 文件名称 */
    @OperLogFieldName(value = "文件名称")
    private String fileName;
    /** 文件大小 */
    @OperLogFieldName(value = "文件大小")
    private Double fileSize;
    /** 上传人 */
    @OperLogFieldName(value = "上传人")
    private String uploader;
    /** 上传日期 */
    @OperLogFieldName(value = "上传日期")
    private Date uploadDate;
    /** 文件服务器上的文件id */
    @OperLogFieldName(value = "文件服务器上的文件id")
    private Integer fileId;
    /** 文件内容 */
    @OperLogFieldName(value = "文件内容")
    private byte[] fileBytes;
    @OperLogFieldName(value = "标志")
    private Integer wordType;
}

package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 * create by zy
 */
@Data
public class FileRecordVO implements Serializable {

    @OperLogFieldName(value = "ID")
    private Integer id;

    @OperLogFieldName(value = "文件名")
    private String fileName;

    @OperLogFieldName(value = "上传时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uploadDate;

    @OperLogFieldName(value = "年份")
    private Integer fileYear;

    @OperLogFieldName(value = "月份")
    private Integer fileMonth;

    @OperLogFieldName(value = "文件类型")
    private String fileType;

    @OperLogFieldName(value = "文件大小")
    private Double size;

    @OperLogFieldName(value = "菜单ID")
    private Integer menuId;

    @OperLogFieldName(value = "文件")
    private byte[] data;

    @OperLogFieldName(value = "操作")
    private Boolean showOption;

    private Integer pageNo;

    private Integer pageSize;

}
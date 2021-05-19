package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/27 15:13
 * @description
 */
@Data
public class ProjectWordRecordViewVO {
    private Integer id;//主键
    @OperLogFieldName(value = "文档信息id")
    private Integer fileKey;//文档信息id
    @OperLogFieldName(value = "文件名")
    private String fileName;//文件名
    @OperLogFieldName(value = "上传时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date submitDate;//上传时间
    @OperLogFieldName(value = "上传人员")
    private String submitter;//上传人员
    @OperLogFieldName(value = "上传人员姓名")
    private String submitterText;//上传人员
    @OperLogFieldName(value = "文件大小")
    private Double fileSize;//文件大小
    @OperLogFieldName(value = "文档数据库记录id")
    private Integer detailId;//文档数据库记录id
    @OperLogFieldName(value = "部门审核标志")
    private Integer deptFlag;//部门审核标志
    @OperLogFieldName(value = "区域审核标志")
    private Integer regionFlag;//区域审核标志
    @OperLogFieldName(value = "营运审核标志")
    private Integer leaderFlag;//营运审核标志
    @OperLogFieldName(value = "里程碑ID")
    private Integer milepostId;
}

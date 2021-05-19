package com.bsoft.office.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: zy
 * @date: 2021/4/27
 * @description 合同标准文档视图
 */
@Data
public class ContractWordViewVO {
    /** 文档id*/
    private Integer fileId;
    /** 编号*/
    private String fileNo;
    /** 分工*/
    private Integer submitRole;
    /** 分工*/
    private String submitRoleText;
    /** 文档类别*/
    private Integer fileType;
    /** 文档类别*/
    private String fileTypeText;
    /** 文档名称*/
    private String fileName;
    /** 项目规模大*/
    private Integer scaleLarge;
    /** 项目规模中*/
    private Integer scaleMiddle;
    /** 项目规模小*/
    private Integer scaleSmall;
    /** 项目规模微*/
    private Integer scaleTiny;
    /** 是否必须*/
    private Integer isRequired;
    /** 签章要求、客户确认方式*/
    private Integer signature;
    /** 签章要求、客户确认方式*/
    private String signatureText;
    /** 上传数量*/
    private Integer uploadQuantity;
    /** 最新上传日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date uploadDate;
    /** 合同编号*/
    private String contractId;
    /** 示例文档ID*/
    private Integer exampleFileId;
}

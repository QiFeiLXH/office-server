package com.bsoft.office.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/4/27
 * @description 合同文档明细视图
 */
@Data
public class ContractWordDetailViewVO {
    /** 文档明细ID*/
    private Integer detailId;
    /** 文档信息ID*/
    private Integer infoId;
    /** 文档数据库明细ID*/
    private Integer detailDBId;
    /** 标准文档ID*/
    private Integer standardWordId;
    /** 合同编号*/
    private String contractId;
    /** 项目ID*/
    private String projectId;
    /** 项目名称*/
    private String projectName;
    /** 文档名称*/
    private String fileName;
    /** 上传者*/
    private String uploadPersonId;
    /** 上传者姓名*/
    private String uploadPersonName;
    /** 上传时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date uploadDate;
    /** 文档大小*/
    private Double fileSize;
}

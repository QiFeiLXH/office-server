package com.bsoft.office.project.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: zy
 * @date: 2021/4/27
 * @description 项目文档统计
 */
@Data
public class ProjectWordCountViewVO {
    /** 合同号*/
    private String contractNo;
    /** 合同名称*/
    private String contractName;
    /** 部门*/
    private String dept;
    /** 部门名称*/
    private String deptName;
    /** 一级部门*/
    private String parentDept;
    /** 一级部门名称*/
    private String parentDeptName;
    /** 合同签订日期*/
    private Date signDate;

    private Integer wd1;
    private Integer wd2;
    private Integer wd3;
    private Integer wd4;
    private Integer wd5;
    private Integer wd6;
    private Integer wd7;
    private Integer wd8;
    private Integer wd9;
    private Integer wd10;
    private Integer wd11;
    private Integer wd12;
    private Integer wd13;
    private Integer wd14;
    private Integer wd15;}

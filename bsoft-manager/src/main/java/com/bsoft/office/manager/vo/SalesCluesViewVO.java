package com.bsoft.office.manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SalesCluesViewVO {
    /**
     * 是否需更新
     */
    private Integer updateFlag;

    /**
     * 线索编号
     */
    private Integer id;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 产品内容
     */
    private String productContent;

    /**
     * 新老客户
     */
    private String newFlag;

    /**
     * 类别
     */
    private String type;

    /**
     * 预计软件额
     */
    private Double softwareAmount;

    /**
     * 预计硬件额
     */
    private Double hardwareAmount;

    /**
     * 预计签单时间
     */
    private String submitDate;

    /**
     * 预计签单月份
     */
    private String signMonth;

    /**
     * 签单概率
     */
    private Integer signProbability;

    /**
     * 登记日期
     */
    private String registerDate;

    /**
     * 立项日期
     */
    private String approvalDate;

    /**
     * 跟踪日期
     */
    private String trackDate;

    /**
     * 提交标志
     */
    private Integer submitFlag;

    /**
     * 销售区域
     */
    private String salesArea;

    /**
     * 客户状态
     */
    private String customerStatus;

    /**
     * 省份
     */
    private String province;

    /**
     * 客户等级
     */
    private String customerLevel;

    /**
     * 医院等级
     */
    private String hospitalLevel;

    /**
     * 基本信息
     */
    private String baseInfo;

    /**
     * 大客户 标志 0:否 1:是
     */
    private String bigCustomer;

    /**
     * 线索性质  字典"portal.main.dic.cluesNature"
     */
    private String cluesNature;

    /**
     * 切入阶段 字典 "portal.main.dic.salesStage"
     */
    private String entryStage;

    /**
     * 跟单人
     */
    private String trackPerson;

    /**
     * 跟单部门
     */
    private String trackDept;

    /**
     * 线索来源  字典"portal.main.dic.cluesSource"
     */
    private String cluesSource;

    /**
     * 销售总监工号
     */
    private String salesDirector;

    /**
     * 区域负责工号
     */
    private String regionalHead;

    /**
     * 支持领导
     */
    private String supportLeader;

    /**
     * 竞争对手
     */
    private String competitor;

    /**
     * 预计首款
     */
    private Double firstAmount;

    /**
     * 预计系统软件额
     */
    private Double systemSoftwareAmount;

    /**
     * 预计签约时间
     */
    private String signTime;

    /**
     * 目前阶段id
     */
    private String currentStageId;

    /**
     * 目前阶段
     */
    private String currentStage;

    /**
     * 销售阶段
     */
    private String salesStage;

    /**
     * 招投标
     */
    private Integer biddingFlag;

    /**
     * 投标日期
     */
    private String biddingDate;

    /**
     * 最新跟踪情况
     */
    private String trackInfo;

    /**
     * 立项标志
     */
    private Integer approvalFlag;

    /**
     * 销售总监姓名
     */
    private String salesDirectorName;

    /**
     * 区域负责姓名
     */
    private String regionalHeadName;

    /**
     * 支持领导姓名
     */
    private String supportLeaderName;

    /**
     * 备注信息
     */
    private String remarkInfo;

    /**
     * 客户id
     */
    private String customerId;

    /**
     * 大客户 标志 0 1
     */
    private Integer bigCustomerFlag;
    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 预计签约时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date signDate;

    /**
     * 预计净销售额软件  预计净软件额
     */
    private Double estimateNetSales;

    /**
     * 业务归属
     */
    private String businessBelong;

    /**
     * 跟单部门代码
     */
    private String trackDeptNo;

    /**
     * 跟单人员工号
     */
    private String trackPersonId;

    /**
     * 跟单人员 人员表id
     */
    private String trackUserId;

    /**
     * 销售区域编码
     */
    private String salesAreaNo;

}

package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/20 11:03
 * @description
 */
@Data
public class ProjectWordViewVO {
    private Integer fileKey;//文档表主键
    @OperLogFieldName(value = "编号")
    private String fileNumber;//编号
    @OperLogFieldName(value = "所属里程碑")
    private Integer milestone;//所属里程碑
    @OperLogFieldName(value = "所属里程碑名称")
    private String milestoneText;
    @OperLogFieldName(value = "管理分类")
    private Integer wordManageType;//管理分类
    @OperLogFieldName(value = "管理分类名称")
    private String wordManageTypeText;
    @OperLogFieldName(value = "文档类别")
    private Integer fileType;//文档类别
    @OperLogFieldName(value = "文档类别名称")
    private String fileTypeText;
    @OperLogFieldName(value = "文档名称")
    private String fileName;//文档名称
    @OperLogFieldName(value = "分工")
    private Integer submitRole;//分工
    @OperLogFieldName(value = "分工名称")
    private String submitRoleText;
    @OperLogFieldName(value = "项目规模大")
    private Integer scaleLarge;//项目规模大
    @OperLogFieldName(value = "项目规模中")
    private Integer scaleMiddle;//项目规模中
    @OperLogFieldName(value = "项目规模小")
    private Integer scaleSmall;//项目规模小
    @OperLogFieldName(value = "项目规模微")
    private Integer scaleTiny;//项目规模微
    @OperLogFieldName(value = "是否必须")
    private Integer isRequired;//是否必须
    @OperLogFieldName(value = "客户确认方式")
    private Integer signature;//客户确认方式
    @OperLogFieldName(value = "客户确认方式名称")
    private String signatureText;
    @OperLogFieldName(value = "上传数量")
    private Integer uploadQuantity;//上传数量
    //private Integer auditQuantity;//审核数量
    @OperLogFieldName(value = "最新上传日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date uploadDate;//最新上传日期
    @OperLogFieldName(value = "参考模板")
    private String referenceTemplate;//参考模板
    @OperLogFieldName(value = "合同编号")
    private String htbh;//合同编号
    @OperLogFieldName(value = "项目id")
    private String projectId;//项目id
    @OperLogFieldName(value = "文档id")
    private Integer fileId;//文档id
    @OperLogFieldName(value = "工程阶段")
    private Integer stage;//工程阶段
    @OperLogFieldName(value = "工程阶段名称")
    private String stageText;

}

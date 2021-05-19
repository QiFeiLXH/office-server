package com.bsoft.office.manager.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

@Data
public class ProcessDeployVO{
    @OperLogFieldName(value = "ID")
    private Integer id;//主键
    @OperLogFieldName(value = "流程KEY")
    private String key;//流程的key
    @OperLogFieldName(value = "流程名称")
    private String name;//流程名称
    @OperLogFieldName(value = "版本号")
    private Integer version;//版本号
    @OperLogFieldName(value = "资源文件名称")
    private String resourceName;//bpmn资源文件名称
    @OperLogFieldName(value = "流程部署ID")
    private String deploymentId;//流程部署ID
    @OperLogFieldName(value = "流程定义ID")
    private String definitionId;//流程定义ID
    @OperLogFieldName(value = "流程部署状态")
    private Integer status;//流程部署状态
    @OperLogFieldName(value = "流程制作时间")
    private Date createDate;//流程制作时间
    @OperLogFieldName(value = "流程最新部署时间")
    private Date deployDate;//流程最新部署时间
    @OperLogFieldName(value = "文件ID")
    private Integer fileId;//文件ID
    @OperLogFieldName(value = "流程类别")
    private Integer type;//流程类别

}

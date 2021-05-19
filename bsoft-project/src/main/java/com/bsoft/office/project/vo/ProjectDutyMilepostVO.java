package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 8:45
 * @Description 项目责任书-里程碑设置
 */
@Data
public class ProjectDutyMilepostVO{
    @OperLogFieldName(value = "ID")
    private Integer id;
    /** 责任书id */
    @OperLogFieldName(value = "责任书ID")
    private Integer dutyId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 里程碑名字 */
    @OperLogFieldName(value = "里程碑名称")
    private String name;
    /** 权重 */
    @OperLogFieldName(value = "权重")
    private Double weight;
    /** 需上传文档 */
    @OperLogFieldName(value = "需上传文档")
    private String words;


}

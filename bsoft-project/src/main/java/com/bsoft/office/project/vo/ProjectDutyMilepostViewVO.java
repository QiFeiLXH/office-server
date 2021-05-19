package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 8:45
 * @Description 项目责任书-里程碑设置
 */
@Data
public class ProjectDutyMilepostViewVO {
    @OperLogFieldName(value = "id")
    private Integer id;
    /** 责任书id */
    @OperLogFieldName(value = "责任书id")
    private Integer dutyId;
    /** 合同编号 */
    @OperLogFieldName(value = "合同编号")
    private String contractNo;
    /** 里程碑id */
    @OperLogFieldName(value = "里程碑id")
    private String name;
    /** 权重 */
    @OperLogFieldName(value = "权重")
    private Double weight;
    /** 需上传文档 */
    @OperLogFieldName(value = "需上传文档")
    private String words;
    /** 需上传文档数量 */
    @OperLogFieldName(value = "需上传文档数量")
    private Integer wordsNum;
    /** 项目计划中是否已选择该里程碑 1已选择 0 未选择 */
    @OperLogFieldName(value = "是否已选择")
    private Integer selectedFlag;
    /** 需上传文档id列表 */
    @OperLogFieldName(value = "需上传文档id列表")
    private List<Integer> wordsList;


}

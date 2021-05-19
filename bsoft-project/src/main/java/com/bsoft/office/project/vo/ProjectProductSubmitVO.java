package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: lkh
 * @DateTime: 2021/4/21 14:50
 * @Description:
 */
@Data
public class ProjectProductSubmitVO {


    @OperLogFieldName(value = "项目ID")
    private String projectId;
    @OperLogFieldName(value = "项目产品数据集合")
    private List<ProjectProductVO> projectProductVOS;




}

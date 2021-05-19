package com.bsoft.office.organ.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-05-25 18:07
 * @Version 1.0
 * @Description
 */
@Data
@ExcelIgnoreUnannotated
public class FinanceCostViewVO implements Serializable {
    @ExcelProperty(value = "项目ID", index = 1)
    @OperLogFieldName(value = "项目ID")
    private String projectId; //项目id
    @ExcelProperty(value = "项目名称", index = 2)
    @OperLogFieldName(value = "项目名称")
    private String projectName; //项目名称
    @ExcelProperty(value = "合同号", index = 0)
    @OperLogFieldName(value = "合同号")
    private String contractNo; //合同号
    @OperLogFieldName(value = "业务大类ID")
    private Integer businessCategory; //业务大类
    @ExcelProperty(value = "业务大类", index = 3)
    @OperLogFieldName(value = "业务大类")
    private String businessCategoryText; //业务大类
    @OperLogFieldName(value = "项目类别ID")
    private Integer flag; //项目类别
    @ExcelProperty(value = "项目类别", index = 4)
    @OperLogFieldName(value = "项目类别")
    private String flagText; //项目类别
    @OperLogFieldName(value = "工程区域id")
    private String area; //工程区域id
    @ExcelProperty(value = "工程区域", index = 5)
    @OperLogFieldName(value = "工程区域")
    private String areaText; //工程区域
    @ExcelProperty(value = "人力成本", index = 6)
    @OperLogFieldName(value = "人力成本")
    private Double manpowerCost; //人力成本（1.25）
    @ExcelProperty(value = "招待费", index = 8)
    @OperLogFieldName(value = "招待费")
    private Double hospitality; //招待费
    @ExcelProperty(value = "差旅费", index = 7)
    @OperLogFieldName(value = "差旅费")
    private Double travelCost; //差旅费
    @ExcelProperty(value = "软件采购", index = 9)
    @OperLogFieldName(value = "软件采购")
    private Double softwareCost; //软件采购
    @ExcelProperty(value = "其他", index = 10)
    @OperLogFieldName(value = "其他")
    private Double other; //其他
    @OperLogFieldName(value = "签定日期")
    private Date signDate; //签定日期

}

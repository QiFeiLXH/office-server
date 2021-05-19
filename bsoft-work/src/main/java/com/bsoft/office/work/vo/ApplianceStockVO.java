package com.bsoft.office.work.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 办公用品库存
 */
@Data
@ExcelIgnoreUnannotated

public class ApplianceStockVO implements Serializable {
    /**主键*/
    @OperLogFieldName(value = "ID")
    private Integer id;

    /**物品类别*/
    @OperLogFieldName(value = "物品类别")
    private Integer type;

    /**物品名称*/
    @OperLogFieldName(value = "物品名称")
    private Integer name;

    /**规格*/
    @OperLogFieldName(value = "规格")
    @ExcelProperty(value = "规格", index = 2)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String standards;

    /**数量*/
    @OperLogFieldName(value = "数量")
    @ExcelProperty(value = "数量", index = 3)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private Integer quantity;

    /**单价*/
    @OperLogFieldName(value = "单价")
    @ExcelProperty(value = "单价", index = 4)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private Double unitPrice;

    /**金额*/
    @OperLogFieldName(value = "金额")
    @ExcelProperty(value = "金额", index = 5)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private Double money;

    /**供应商*/
    @OperLogFieldName(value = "供应商")
    private Integer supplier;

    /**入库日期*/
    @OperLogFieldName(value = "入库日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inDate;

    /**剩余数量*/
    @OperLogFieldName(value = "剩余数量")
    private Integer surplusQuantity;

    /**支付状态*/
    @OperLogFieldName(value = "支付状态")
    private Integer status;

    /**备注*/
    @OperLogFieldName(value = "备注")
    private String remark;

    /**登记人*/
    @OperLogFieldName(value = "登记人")
    private String register;

    /**流水号*/
    @OperLogFieldName(value = "流水号")
    private String lshId;

    /**类型名称*/
    @OperLogFieldName(value = "类型名称")
    @ExcelProperty(value = "物品类别", index = 0)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String typeName;

    /**物品名称*/
    @OperLogFieldName(value = "物品名称")
    @ExcelProperty(value = "物品名称", index = 1)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String nameName;

    /**供应商名称*/
    @OperLogFieldName(value = "供应商名称")
    @ExcelProperty(value = "供应商", index = 6)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    private String supplierName;

    /**登记人姓名*/
    @OperLogFieldName(value = "登记人姓名")
    private String registerName;

    /**申请支付的申请时间（用于导出Excel）*/
    @OperLogFieldName(value = "申请时间")
    @ExcelProperty(value = "申请时间", index = 7)
    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 5)
    @DateTimeFormat("yyyy-MM-dd")
    private Date applyDate;

    /**提交标志*/
    @OperLogFieldName(value = "提交标志")
    private Integer submitFlag;

}

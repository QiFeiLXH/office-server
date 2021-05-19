package com.bsoft.office.common.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/17 14:13
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DynamicTableHeaderVO {
    @OperLogFieldName(value = "标题")
    private String title;
    @OperLogFieldName(value = "列名")
    private String column;
    @OperLogFieldName(value = "跨列")
    private Integer colSpan;
    @OperLogFieldName(value = "跨行")
    private List<Integer> rowSpan;
    @OperLogFieldName(value = "宽度")
    private Integer width;
    @OperLogFieldName(value = "固定")
    private String fixed;
    @OperLogFieldName(value = "对齐方式")
    private String align;
    @OperLogFieldName(value = "省略")
    private Boolean ellipsis;
    @OperLogFieldName(value = "自定义")
    private Map<String, String> scopedSlots;
}

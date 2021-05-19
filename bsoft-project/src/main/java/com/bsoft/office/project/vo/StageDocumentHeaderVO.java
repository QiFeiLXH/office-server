package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/5/14
 * @Description: 上传文档表头
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageDocumentHeaderVO {
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
    private String fixed;
}

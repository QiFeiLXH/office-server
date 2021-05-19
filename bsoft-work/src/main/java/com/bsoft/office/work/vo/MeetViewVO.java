package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-12-22 9:08
 * @Version 1.0
 */
@Data
public class MeetViewVO {
    @OperLogFieldName(value = "会议ID")
    private Integer id;
    @OperLogFieldName(value = "会议名称")
    private String name;
    @OperLogFieldName(value = "会议地址")
    private String address;
    @OperLogFieldName(value = "会议开始时间")
    private Date startDate;
    @OperLogFieldName(value = "会议结束时间")
    private Date endDate;
    @OperLogFieldName(value = "参会证发放标志")
    private Integer flag;
    @OperLogFieldName(value = "会期")
    private String meetDate;
    @OperLogFieldName(value = "备注")
    private String remark;
    @OperLogFieldName(value = "会议人数")
    private Integer personCount;
    @OperLogFieldName(value = "会议子名称")
    private String subName;

}

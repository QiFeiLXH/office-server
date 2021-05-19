package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.util.Date;

@Data
public class MeetVO  {
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
    @OperLogFieldName(value = "是否发放参会证")
    private Integer flag;
    @OperLogFieldName(value = "会议日期")
    private String meetDate;
    @OperLogFieldName(value = "备注")
    private String remark;
    @OperLogFieldName(value = "子会议名称")
    private String subName;
}

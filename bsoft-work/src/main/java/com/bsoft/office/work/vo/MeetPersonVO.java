package com.bsoft.office.work.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

@Data
public class MeetPersonVO {
    @OperLogFieldName(value = "ID")
    private Integer id;
    @OperLogFieldName(value = "会议ID")
    private Integer meetId;
    @OperLogFieldName(value = "手机号")
    private String mobileNo;
    @OperLogFieldName(value = "姓名")
    private String personName;
}

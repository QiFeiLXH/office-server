package com.bsoft.office.work.condition;

import lombok.Data;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:51
 * @Version 1.0
 */
@Data
public class MeetPersonQueryCnd {
    private Integer meetId;
    private String input;
    private Integer pageSize;
    private Integer pageNo;
}

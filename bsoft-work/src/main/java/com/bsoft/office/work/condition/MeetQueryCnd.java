package com.bsoft.office.work.condition;

import lombok.Data;

/**
 * @Author zhanglf
 * @Date 2020-12-21 13:44
 * @Version 1.0
 */
@Data
public class MeetQueryCnd  {
    private String month;//例 2020-12
    private Integer pageSize;
    private Integer pageNo;
}

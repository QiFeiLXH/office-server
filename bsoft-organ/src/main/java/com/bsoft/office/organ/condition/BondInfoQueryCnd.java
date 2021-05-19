package com.bsoft.office.organ.condition;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/21 16:56
 * @Description
 */
@Data
public class BondInfoQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    private String userId;
    private Integer overdueFlag;
    private Integer chargeFlag;
    private Boolean allPermission;
    private String inputContent;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;
}

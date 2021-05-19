package com.bsoft.office.organ.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/5/21
 * @Description:
 */
@Data
public class StartDateTreeVO {

    private String title;

    private String key;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date checkTime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;

    private Boolean parent;

    private List<StartDateTreeVO> children;

}

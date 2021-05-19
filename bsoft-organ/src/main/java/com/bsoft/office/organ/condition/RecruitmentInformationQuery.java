package com.bsoft.office.organ.condition;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/5/20
 * @Description:
 */
@Data
public class RecruitmentInformationQuery implements Serializable {

    private Integer pageNumber;
    private Integer pageSize;
    private String userId;
    private List<Integer> status;
    private Boolean checkAll;
    private String content;
    private Boolean queryAll;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkTime;

}

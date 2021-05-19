package com.bsoft.office.system.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonVO implements Serializable {
    @OperLogFieldName(value = "工号")
    private String personId;
    @OperLogFieldName(value = "姓名")
    private String personName;
    @OperLogFieldName(value = "部门代码")
    private String deptId;
    @OperLogFieldName(value = "部门名称")
    private String deptIdText;
    @OperLogFieldName(value = "岗位")
    private String restype;
    @OperLogFieldName(value = "手机号")
    private String mobile;
    @OperLogFieldName(value = "邮箱")
    private String email;
    @OperLogFieldName(value = "岗位名称")
    private String restypeText;
    @OperLogFieldName(value = "专业职级")
    private Integer sequence;
    @OperLogFieldName(value = "专业职级等级")
    private Integer specialRank;
    @OperLogFieldName(value = "专业职级日期")
    private Date specialDate;
    @OperLogFieldName(value = "管理职级")
    private Integer managerRank;
    @OperLogFieldName(value = "管理职级日期")
    private Date managerDate;
    @OperLogFieldName(value = "管理职级等级")
    private String specialRankText;
    @OperLogFieldName(value = "专业职级等级名称")
    private String sequenceText;
    @OperLogFieldName(value = "管理职级等级名称")
    private String managerRankText;
    @OperLogFieldName(value = "电子名片")
    private String cardPath;

}

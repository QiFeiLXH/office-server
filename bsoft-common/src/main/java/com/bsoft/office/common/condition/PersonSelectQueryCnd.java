package com.bsoft.office.common.condition;

import lombok.Data;

/**
 * @author: zy
 * @date: 2020/12/1
 * @description 人员信息查询参数
 */
@Data
public class PersonSelectQueryCnd {
    /** 工号*/
    private String personId;
    /** 姓名*/
    private String personName;
    /** 离职状态 0在职1离职*/
    private String isValid;
    /** 拼音码*/
    private String simpleCode;
    /** 输入内容*/
    private String inputContent;
}

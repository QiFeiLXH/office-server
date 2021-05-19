package com.bsoft.office.organ.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: hy
 * @Date: 2020/5/22
 * @Description:
 */
@Data
public class AreaDicVO {
    private Integer id;
    private String name;
    private String pinyin;
    private Integer parentId;
}

package com.bsoft.office.organ.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/6/2
 * @Description: 新的省市县
 */
@Data
public class AdministrativeAreaVO {

    private Integer id;

    private String name;

    private Integer parentId;

    private Integer level;

    private String pinyin;

    private Integer deleted;

    private Integer divisionId;

    private List<AdministrativeAreaVO> children;

}

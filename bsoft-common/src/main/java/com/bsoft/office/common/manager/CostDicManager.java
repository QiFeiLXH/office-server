package com.bsoft.office.common.manager;

import com.bsoft.common.dto.CostDicDTO;
import com.bsoft.office.common.vo.CostDicVO;

import java.util.List;
import java.util.Map;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
public interface CostDicManager {
    /**
     * 根据类别，注销标志获取字典
     * @param type 类别
     * @param logout 注销标志
     * @return
     */
    List<CostDicVO> getCostDicList(Integer type, Integer logout);

    /**
     * 根据类别，注销标志，名字或拼音码模糊查询字典
     * @param type 类别
     * @param logout 注销标志
     * @param inputContent 输入内容
     * @return
     */
    List<CostDicVO> getCostDicList(Integer type, Integer subType, Integer logout, String inputContent);

}

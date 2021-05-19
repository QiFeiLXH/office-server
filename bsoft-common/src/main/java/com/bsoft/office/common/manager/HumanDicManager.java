package com.bsoft.office.common.manager;

import com.bsoft.office.common.condition.HumanDicSelectQueryCnd;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.person.dto.HumanDicDTO;

import java.util.List;

public interface HumanDicManager {
    List<HumanDicDTO> getHumanDic(Integer type);
    /**
     * 获取字典选择器列表
     * @param queryCnd 查询参数
     */
    List<HumanDicVO> getHumanDicSelectList(HumanDicSelectQueryCnd queryCnd);

}

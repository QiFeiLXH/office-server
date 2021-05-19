package com.bsoft.office.common.manager;

import com.bsoft.office.common.condition.PublicDicSelectQueryCnd;
import com.bsoft.office.common.vo.PublicDicVO;

import java.util.List;

public interface PublicDicManager {
    List<PublicDicVO> getPublicDics(Integer type);
    List<PublicDicVO> getPublicDicsWithFlag(Integer type, Integer flag);
    /**
     * 获取字典选择器列表
     * @param queryCnd 查询参数
     */
    List<PublicDicVO> getPublicDicSelectList(PublicDicSelectQueryCnd queryCnd);
}

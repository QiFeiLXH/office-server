package com.bsoft.office.common.manager;

import com.bsoft.office.common.condition.SystemDicSelectQueryCnd;
import com.bsoft.office.common.vo.SystemDicVO;

import java.util.List;

/**
 * @author: zy
 * @date: 2021/2/5
 */
public interface SystemDicManager {
    /**
     * 获取字典选择器列表
     * @param queryCnd 查询参数
     */
    List<SystemDicVO> getSystemDicSelectList(SystemDicSelectQueryCnd queryCnd);
}

package com.bsoft.office.system.manager;

import com.bsoft.office.system.vo.TimeTaskGroupTreeVO;
import com.bsoft.system.dto.TimeTaskGroupTreeDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 13:38
 * @Version 1.0
 * @Description
 */
public interface TimeTaskGroupManager {
    /**
     * 保存修改
     * @param timeTaskGroup
     * @return
     */
    TimeTaskGroupTreeVO save(TimeTaskGroupTreeVO timeTaskGroup);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 获取分组树
     * @return
     */
    List<TimeTaskGroupTreeVO> getGroupTree();
}

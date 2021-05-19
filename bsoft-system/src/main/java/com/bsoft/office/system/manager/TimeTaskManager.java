package com.bsoft.office.system.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.system.vo.TimeTaskQueryCndVO;
import com.bsoft.office.system.vo.TimeTaskVO;
import com.bsoft.system.dto.TimeTaskDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-06-29 16:54
 * @Version 1.0
 * @Description
 */
public interface TimeTaskManager {
    /**
     * 获取定时任务列表
     * @param cnd 查询条件cnd
     * @return Result<TaskDTO>
     */
    Result<TimeTaskDTO> getTaskList(TimeTaskQueryCndVO cnd);

    /**
     * 保存修改 定时任务
     * @param task
     */
    void saveTask(TimeTaskVO task);

    /**
     * 删除定时任务
     * @param task
     */
    void remove(TimeTaskVO task);

    /**
     * 批量删除定时任务
     * @param taskDTOList
     */
    void removeBatch(List<TimeTaskVO> taskDTOList);

    /**
     * 启用/禁用 定时任务
     * @param jobId 任务ID
     * @param jobStatus 任务状态
     */
    void changeStatus(Integer jobId, String jobStatus);

    /**
     * 根据id获取定时任务信息
     * @param id
     * @return
     */
    TimeTaskVO getById(Integer id);
}

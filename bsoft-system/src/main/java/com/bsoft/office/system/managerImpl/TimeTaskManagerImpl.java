package com.bsoft.office.system.managerImpl;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.system.manager.TimeTaskManager;
import com.bsoft.office.system.vo.TimeTaskQueryCndVO;
import com.bsoft.office.system.vo.TimeTaskVO;
import com.bsoft.system.dto.TimeTaskDTO;
import com.bsoft.system.dto.TimeTaskQueryCndDTO;
import com.bsoft.system.service.TimeTaskService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-06-29 17:00
 * @Version 1.0
 * @Description
 */
@Component
public class TimeTaskManagerImpl implements TimeTaskManager {
    @Reference(cluster = "forking")
    private TimeTaskService taskService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<TimeTaskDTO> getTaskList(TimeTaskQueryCndVO cnd) {
        TimeTaskQueryCndDTO cndDTO = generatorUtil.convert(cnd,TimeTaskQueryCndDTO.class);
        return taskService.getTaskList(cndDTO);
    }

    @Override
    public void saveTask(TimeTaskVO task){
        TimeTaskDTO taskDTO = generatorUtil.convert(task,TimeTaskDTO.class);
        taskService.saveTask(taskDTO);
    }

    @Override
    public void remove(TimeTaskVO task) {
        TimeTaskDTO taskDTO = generatorUtil.convert(task,TimeTaskDTO.class);
        taskService.remove(taskDTO);
    }

    @Override
    public void removeBatch(List<TimeTaskVO> taskDTOList) {
        List<TimeTaskDTO> taskDTOS = generatorUtil.convert(taskDTOList,TimeTaskDTO.class);
        taskService.removeBatch(taskDTOS);
    }

    @Override
    public void changeStatus(Integer jobId, String jobStatus){
        taskService.changeStatus(jobId,jobStatus);
    }

    @Override
    public TimeTaskVO getById(Integer id) {
        TimeTaskDTO taskDTO = taskService.getById(id);
        return generatorUtil.convert(taskDTO, TimeTaskVO.class);
    }
}

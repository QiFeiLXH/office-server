package com.bsoft.office.system.managerImpl;

import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.system.manager.TimeTaskGroupManager;
import com.bsoft.office.system.vo.TimeTaskGroupTreeVO;
import com.bsoft.system.dto.TimeTaskGroupTreeDTO;
import com.bsoft.system.service.TimeTaskGroupService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 13:39
 * @Version 1.0
 * @Description
 */
@Component
public class TimeTaskGroupManagerImpl implements TimeTaskGroupManager {
    @Reference
    private TimeTaskGroupService timeTaskGroupService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public TimeTaskGroupTreeVO save(TimeTaskGroupTreeVO timeTaskGroup) {
        TimeTaskGroupTreeDTO timeTaskGroupTreeDTO = generatorUtil.convert(timeTaskGroup,TimeTaskGroupTreeDTO.class);
        TimeTaskGroupTreeDTO returnDTO = timeTaskGroupService.save(timeTaskGroupTreeDTO);
        return generatorUtil.convert(returnDTO,TimeTaskGroupTreeVO.class);
    }

    @Override
    public void delete(Integer id) {
        timeTaskGroupService.delete(id);
    }

    @Override
    public List<TimeTaskGroupTreeVO> getGroupTree() {
        List<TimeTaskGroupTreeDTO> returnDTO = timeTaskGroupService.getGroupTree();
        return generatorUtil.convert(returnDTO,TimeTaskGroupTreeVO.class);
    }
}

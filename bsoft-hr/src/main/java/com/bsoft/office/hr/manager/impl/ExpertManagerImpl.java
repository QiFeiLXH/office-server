package com.bsoft.office.hr.manager.impl;

import com.bsoft.office.hr.manager.ExpertManager;
import com.bsoft.person.dto.ExpertDTO;
import com.bsoft.person.service.ExpertService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpertManagerImpl implements ExpertManager {
    @Reference
    private ExpertService expertService;
    @Override
    public ExpertDTO saveExpert(ExpertDTO expertDTO) {
        return expertService.saveExpert(expertDTO);
    }

    @Override
    public List<ExpertDTO> getExperts(String context) {
        return expertService.getExperts(context);
    }

    @Override
    public void removeExpert(Integer id) {
        expertService.removeExpert(id);
    }
}

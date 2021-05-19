package com.bsoft.office.hr.manager;

import com.bsoft.person.dto.ExpertDTO;

import java.util.List;

public interface ExpertManager {
    ExpertDTO saveExpert(ExpertDTO expertDTO);

    List<ExpertDTO> getExperts(String context);

    void removeExpert(Integer id);
}

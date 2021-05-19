package com.bsoft.office.project.manager;


import com.bosft.progress.dto.ProjectProductDTO;
import com.bosft.progress.dto.ProjectProductQueryCndDTO;
import com.bosft.progress.dto.ProjectProductSubmitDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.project.vo.ProjectProductVO;

import java.util.List;

public interface ProjectProductManager {
    Result<ProjectProductVO> getProjectProducts(ProjectProductQueryCndDTO cnd);

    void saveProjectProducts(List<ProjectProductVO> projectProductDOS);

    void submitProjectProducts(List<ProjectProductVO> projectProductVO,ProjectProductSubmitDTO projectProductSubmitDTO);

}

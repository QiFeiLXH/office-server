package com.bsoft.office.project.manager;

import com.bosft.progress.dto.ProjectProductViewQueryCndDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.project.vo.ProjectProductViewVO;


public interface ProjectProductViewManager {
    Result<ProjectProductViewVO> getProjectProductViews(ProjectProductViewQueryCndDTO cnd);

}

package com.bsoft.office.project.controller;

import com.bosft.progress.dto.ProjectProductViewQueryCndDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.manager.ProjectProductViewManager;
import com.bsoft.office.project.vo.ProProgressNodeVO;
import com.bsoft.office.project.vo.ProjectProductViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/projectproductview")
public class ProjectProductViewController {
    @Autowired
    private ProjectProductViewManager projectProductViewManager;
    @GetMapping(value = "/getprojectproductviews")
    public OfficeResopnseBean getProjectProductViews(HttpServletRequest request,ProjectProductViewQueryCndDTO cnd){
        String userId = ContextUtils.getUserId(request);
        cnd.setProgressManager(Integer.valueOf(userId));
        Result<ProjectProductViewVO> projectProductViews = projectProductViewManager.getProjectProductViews(cnd);
        return OfficeResopnseBean.newSuccessBean(projectProductViews);
    }


}

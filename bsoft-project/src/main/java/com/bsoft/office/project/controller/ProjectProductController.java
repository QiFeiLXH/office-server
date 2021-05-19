package com.bsoft.office.project.controller;

import com.bosft.progress.dto.ProjectProductDTO;
import com.bosft.progress.dto.ProjectProductQueryCndDTO;
import com.bosft.progress.dto.ProjectProductSubmitDTO;
import com.bosft.progress.dto.ProjectProductViewQueryCndDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.project.manager.ProjectProductManager;
import com.bsoft.office.project.manager.ProjectProductViewManager;
import com.bsoft.office.project.vo.ProjectProductSubmitVO;
import com.bsoft.office.project.vo.ProjectProductVO;
import com.bsoft.office.project.vo.ProjectProductViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/projectproduct")
public class ProjectProductController {
    @Autowired
    private ProjectProductManager projectProductManager;
    @GetMapping(value = "/getprojectproducts")
    public OfficeResopnseBean getProjectProducts(ProjectProductQueryCndDTO cnd){
        Result<ProjectProductVO> projectProductViews = projectProductManager.getProjectProducts(cnd);
        return OfficeResopnseBean.newSuccessBean(projectProductViews);
    }

    @PostMapping(value = "/saveprojectproducts")
    public OfficeResopnseBean saveProjectProducts(@RequestBody List<ProjectProductVO> list){
        projectProductManager.saveProjectProducts(list);
        return OfficeResopnseBean.newSuccessBean(200);
    }

    @PostMapping(value = "/submitprojectproducts")
    public OfficeResopnseBean submitprojectproducts(HttpServletRequest request, @RequestBody ProjectProductSubmitVO productData){
        ProjectProductSubmitDTO projectProductSubmitDTO = new ProjectProductSubmitDTO();
        projectProductSubmitDTO.setProjectId(productData.getProjectId());
        String personId = ContextUtils.getUserId(request);
        projectProductSubmitDTO.setSumbiter(personId);
        projectProductManager.submitProjectProducts(productData.getProjectProductVOS(),projectProductSubmitDTO);
        return OfficeResopnseBean.newSuccessBean(200);
    }


}

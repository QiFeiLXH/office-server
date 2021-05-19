package com.bsoft.office.project.controller;

import com.bosft.progress.dto.ProReportTypeDTO;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.project.manager.ProReportTypeManager;
import com.bsoft.office.project.vo.ProReportTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/proreporttype")
public class ProReportTypeController {
    @Autowired
    private ProReportTypeManager proReportTypeManager;
    @GetMapping(value = "/getproreporttypelist")
    public OfficeResopnseBean getproreporttypelist(){
        List<ProReportTypeVO> proReportTypes = proReportTypeManager.getProReportTypes();
        return OfficeResopnseBean.newSuccessBean(proReportTypes);

    }
    @PostMapping(value = "/saveproreporttypelist")
    public OfficeResopnseBean saveProreportTypeList(@RequestBody  ProReportTypeVO proReportTypeVO){
        proReportTypeManager.saveProReportTypes(proReportTypeVO);
        return OfficeResopnseBean.newSuccessBean(200);
    }

    @GetMapping(value = "/logoutproreporttype")
    public OfficeResopnseBean logoutProreportType(Integer id){
        proReportTypeManager.logoutProReportType(id);
        return OfficeResopnseBean.newSuccessBean(200);
    }


}

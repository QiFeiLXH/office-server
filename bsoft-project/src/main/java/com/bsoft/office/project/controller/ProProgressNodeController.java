package com.bsoft.office.project.controller;

import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.project.manager.ProProgressNodeManager;
import com.bsoft.office.project.vo.ProProgressNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/proprogressnode")
public class ProProgressNodeController {
    @Autowired
    private ProProgressNodeManager proProgressNodeManager;
    @GetMapping(value = "/getproprogressnodelist")
    public OfficeResopnseBean getProrePorttypeList(@RequestParam  Integer id){
        List<ProProgressNodeVO> proProgressNodes = proProgressNodeManager.getProProgressNodes(id);
        return OfficeResopnseBean.newSuccessBean(proProgressNodes);
    }
    @PostMapping(value = "/saveproprogressnodelist")
    public OfficeResopnseBean saveProreportTypeList(@RequestBody List<ProProgressNodeVO> list){
        proProgressNodeManager.saveProProgressNodes(list);
        return  OfficeResopnseBean.newSuccessBean(200);
    }

    @GetMapping(value = "/logoutproprogressnode")
    public OfficeResopnseBean logoutProreportType(@RequestParam  Integer id){
        proProgressNodeManager.logoutProProgressNode(id);
        return  OfficeResopnseBean.newSuccessBean(200);
    }

}

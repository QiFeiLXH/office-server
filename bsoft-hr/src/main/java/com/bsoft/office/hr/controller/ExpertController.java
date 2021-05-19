package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.HumanDicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.hr.manager.ExpertManager;
import com.bsoft.office.hr.vo.ExpertVO;
import com.bsoft.person.dto.ExpertDTO;
import com.bsoft.person.dto.HumanDicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expert")
public class ExpertController {
    @Autowired
    private IGenerator generator;
    @Autowired
    private ExpertManager expertManager;
    @Autowired
    private HumanDicManager humanDicManager;

    @RequestMapping(value = "/saveexpert",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存专家信息")
    public OfficeResopnseBean saveExpert(@RequestBody ExpertVO expertVO){
        ExpertDTO expertDTO = generator.convert(expertVO,ExpertDTO.class);
        expertDTO = expertManager.saveExpert(expertDTO);
        expertVO = generator.convert(expertDTO,ExpertVO.class);
        return OfficeResopnseBean.newSuccessBean(expertVO);
    }

    @RequestMapping(value = "/getexperts",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询所有专家信息")
    public OfficeResopnseBean getAllExpert(@RequestParam("context") String context){
        List<ExpertDTO> experts = expertManager.getExperts(context);
        List<ExpertVO> list = generator.convert(experts,ExpertVO.class);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/gettypedic",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询专家类型字典")
    public OfficeResopnseBean getExpertTypeDic(){
        List<HumanDicDTO> result = humanDicManager.getHumanDic(36);
        List<HumanDicVO> list = generator.convert(result,HumanDicVO.class);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/removeexpert",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除专家信息")
    public OfficeResopnseBean removeExpert(@RequestParam("id") Integer id){
        expertManager.removeExpert(id);
        return OfficeResopnseBean.newSuccessBean();
    }

}

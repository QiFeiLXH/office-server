package com.bsoft.office.organ.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.organ.condition.SubsidyStandardQueryCnd;
import com.bsoft.office.organ.manager.SubsidyStandardManager;
import com.bsoft.office.organ.vo.SubsidyStandardViewVO;
import com.bsoft.office.common.manager.ProjectManager;
import com.bsoft.office.common.manager.ServerDateManager;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.ProjectLookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xucl
 * @DateTime: 2020/11/25 17:38
 * @Description:
 */
@RestController
@RequestMapping("/subsidy")
public class SubsidyStandardController {

    @Autowired
    private SubsidyStandardManager subsidyStandardManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private ProjectManager projectManager;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "特殊津贴列表")
    public OfficeResopnseBean findSubsidyStandard(@RequestBody SubsidyStandardQueryCnd cnd){
        Result<SubsidyStandardViewVO> result = subsidyStandardManager.findSubsidyStandard(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改特殊津贴标准")
    public OfficeResopnseBean saveSubsidyStandard(@RequestBody SubsidyStandardViewVO standardViewVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        if (standardViewVO.getState().equals(0)){
            if (standardViewVO.getRegistrant() == null){
                standardViewVO.setRegistrant(personId);
            }
            if (standardViewVO.getApplydate() == null){
                standardViewVO.setApplydate(serverDateManager.getServerDate());
            }
        }
        if (standardViewVO.getState().equals(1)){
            standardViewVO.setVoider(personId);
            standardViewVO.setVoiderDate(serverDateManager.getServerDate());
        }
        subsidyStandardManager.saveSubsidyStandard(standardViewVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/projectlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目特殊津贴维护查询项目列表")
    public OfficeResopnseBean getProjectList(@RequestParam Integer pageNo,
                                             @RequestParam Integer pageSize,
                                             @RequestParam(required = false) String inputContent){
        Result<ProjectLookVO> result = projectManager.getAllProjectList(pageNo,pageSize,inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }
}

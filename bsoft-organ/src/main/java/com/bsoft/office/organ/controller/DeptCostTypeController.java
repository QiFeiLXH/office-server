package com.bsoft.office.organ.controller;

import com.bsoft.cost.dto.DeptCostTypeViewDTO;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.organ.manager.DeptCostTypeManager;
import com.bsoft.office.organ.vo.CostTypeDeptViewVO;
import com.bsoft.office.organ.vo.DeptCostTypeViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 10:00
 * @Description: 部门费用类别
 */
@RestController
@RequestMapping(value = "/dcosttype")
public class DeptCostTypeController {

    @Autowired
    private DeptCostTypeManager deptCostTypeManager;

    @GetMapping(value = "/finddept")
    @OperLog(operType = OperLogType.QUERY,operDesc = "部门费用类别-部门树查询")
    public OfficeResopnseBean findDept(@RequestParam("year")Integer year,
                                       @RequestParam("flag")Integer flag,
                                       @RequestParam("type")Integer type,
                                       @RequestParam("logout")Integer logout,
                                       @RequestParam("deptId")String deptId){
        List<CostTypeDeptViewVO> list = deptCostTypeManager.findDeptList(year,flag,type,logout,deptId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @GetMapping(value = "/getcosttype")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询部门费用类别信息")
    public OfficeResopnseBean getCostType(@RequestParam("year")Integer year,
                                          @RequestParam("deptNo")String deptNo){
        DeptCostTypeViewVO deptCostTypeViewVO = deptCostTypeManager.getDeptCostType(year,deptNo);
        return OfficeResopnseBean.newSuccessBean(deptCostTypeViewVO);
    }

    @PostMapping(value = "/save")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存部门费用类别")
    public OfficeResopnseBean saveCostType(@RequestBody DeptCostTypeViewVO vo, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        vo.setRegistrant(userId);
        deptCostTypeManager.saveCostType(vo);
        return OfficeResopnseBean.newSuccessBean();
    }

    @GetMapping(value = "/check")
    @OperLog(operType = OperLogType.OTHER,operDesc = "验证是否可以年度生成")
    public OfficeResopnseBean check(@RequestParam("year")Integer year){
        boolean status = deptCostTypeManager.checkAnnualGener(year);
        return OfficeResopnseBean.newSuccessBean(status);
    }

    @GetMapping(value = "/gener")
    @OperLog(operType = OperLogType.OTHER,operDesc = "年度生成部门费用类别信息")
    public OfficeResopnseBean gener(@RequestParam("year")Integer year,HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        deptCostTypeManager.annualGener(year,userId);
        return OfficeResopnseBean.newSuccessBean();
    }
}

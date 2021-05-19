package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.DeptPublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.DeptVO;
import com.bsoft.office.common.vo.DynamicTableHeaderVO;
import com.bsoft.office.project.condition.ProgressManagerQueryCnd;
import com.bsoft.office.project.manager.ProjectProgressManager;
import com.bsoft.office.project.vo.DeptProgressViewVO;
import com.bsoft.office.project.vo.ProjectProgressManagerVO;
import com.bsoft.office.project.vo.RegionProgressViewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/7 10:14
 * @Description
 */
@RestController
@RequestMapping("/regionprogress")
public class ProjectRegionProgressManagerController {
    @Autowired
    private ProjectProgressManager projectProgressManager;
    @Autowired
    private DeptPublicManager deptPublicManager;

    /**
     *功能描述: 项目区域进度查询
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "区域进度查询")
    public OfficeResopnseBean getRegionProgressManagerList(ProgressManagerQueryCnd cnd){
        Result<RegionProgressViewVO> result = projectProgressManager.getRegionProgressManagerList(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     *功能描述: 项目区域进度保存
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "项目区域进度保存")
    public OfficeResopnseBean saveRegionList(@RequestBody List<ProjectProgressManagerVO> regions){
        projectProgressManager.saveRegionList(regions);
        return OfficeResopnseBean.newSuccessBean("保存成功!");
    }

    /**
     *功能描述: 区域注销
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.OTHER,operDesc = "区域注销")
    public OfficeResopnseBean logoutRegion(String deptId){
        projectProgressManager.logoutRegion(deptId);
        return OfficeResopnseBean.newSuccessBean("注销成功！");
    }

    /**
     *功能描述: 区域启用
     */
    @RequestMapping(value = "/enable",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.OTHER,operDesc = "区域启用")
    public OfficeResopnseBean enableRegion(String deptId){
        projectProgressManager.enableRegion(deptId);
        return OfficeResopnseBean.newSuccessBean("启用成功！");
    }

    @GetMapping("/header")
    @OperLog(operType = OperLogType.QUERY,operDesc = "部门进度管理表头")
    public OfficeResopnseBean getAllDeptProgressManagerHeader(@RequestParam(required = false) List<Integer> logout, @RequestParam(required = false) String inputContent) {
        if (logout == null) {
            logout = new ArrayList<>();
        }
        List<DynamicTableHeaderVO> headers = projectProgressManager.getAllDeptProgressManagerHeader(logout,inputContent);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(headers);
        return responseBean;
    }

    /**
     *功能描述: 部门进度管理查询
     */
    @RequestMapping(value = "/deptquery",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "部门进度查询")
    public OfficeResopnseBean getAllDeptProgressManagerList(ProgressManagerQueryCnd cnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        cnd.setPersonId(userId);
        List<DeptProgressViewVO> list = projectProgressManager.getAllDeptProgressManagerList(cnd);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     *功能描述: 获取有效的大区
     */
    @RequestMapping(value = "/regiondic",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "有效的大区选择")
    public OfficeResopnseBean getAllValidRegionList(){
        List<DeptVO> list = deptPublicManager.getAllValidRegionList();
        return OfficeResopnseBean.newSuccessBean(list);
    }


}

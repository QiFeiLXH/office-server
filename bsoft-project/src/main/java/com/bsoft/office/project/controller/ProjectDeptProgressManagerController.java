package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
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
@RequestMapping("/deptprogress")
public class ProjectDeptProgressManagerController {
    @Autowired
    private ProjectProgressManager projectProgressManager;

    /**
     *功能描述: 部门进度管理查询
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "部门进度查询")
    public OfficeResopnseBean getDeptProgressManagerList(ProgressManagerQueryCnd cnd, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        cnd.setPersonId(userId);
        List<DeptProgressViewVO> list = projectProgressManager.getDeptProgressManagerList(cnd);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     *功能描述: 项目区域进度查询
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "部门进度管理保存")
    public OfficeResopnseBean saveDeptProgressManager(@RequestBody ProjectProgressManagerVO managerVO){
        projectProgressManager.saveDeptProgressManager(managerVO);
        return OfficeResopnseBean.newSuccessBean("保存成功!");
    }

    @GetMapping("/header")
    @OperLog(operType = OperLogType.QUERY,operDesc = "部门进度管理表头")
    public OfficeResopnseBean getDeptProgressManagerHeader(HttpServletRequest request,@RequestParam(required = false) List<Integer> logout, @RequestParam(required = false) String inputContent) {
        String userId = ContextUtils.getUserId(request);
        if (logout == null) {
            logout = new ArrayList<>();
        }
        List<DynamicTableHeaderVO> headers = projectProgressManager.getDeptProgressManagerHeader(userId,logout,inputContent);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(headers);
        return responseBean;
    }

}

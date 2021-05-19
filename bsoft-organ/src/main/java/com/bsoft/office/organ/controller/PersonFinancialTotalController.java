package com.bsoft.office.organ.controller;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.HrFeeRulesRecordCndDTO;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.organ.condition.DeptMaintainInfoQueryCnd;
import com.bsoft.office.organ.manager.*;
import com.bsoft.office.organ.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author lkh
 * @Date 2021/1/18 16:20
 * @Description
 */
@RestController
@RequestMapping("/personfinancialtotal")
public class PersonFinancialTotalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonFinancialTotalController.class);

    //人员财务类别维护
    @Autowired
    private PersonTypeManager personTypeManager;
    //岗位与费用规则维护
    @Autowired
    private PostAndCostRuleManager postAndCostRuleManager;
    //部门财务维护
    @Autowired
    private DeptCostMaintainManager deptCostMaintainManager;
    //特殊部门人员财务类别维护
    @Autowired
    private PersonFinancialViewManager personFinancialViewManager;

    @Autowired
    private HrFeeRulesRecordManager hrFeeRulesRecordManager;

    @GetMapping("/gethrfeerulesrecordlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "特殊人员财务类别调整记录")
    public OfficeResopnseBean getPersonFinancialList(HrFeeRulesRecordCndDTO cndDTO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        Result<HrFeeRulesRecordVO> result = hrFeeRulesRecordManager.getList(userId,cndDTO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/query")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取人员财务类别单个信息")
    public OfficeResopnseBean getPersonTypeInfo(PublicDicVO publicDicVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("获取人员类别信息[{}][{}]", userId, JSONUtils.toString(publicDicVO));
        PublicDicVO result = personTypeManager.getPersonTypeInfo(userId, publicDicVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/queryList")
    @OperLog(operType = OperLogType.QUERY,operDesc = "人员财务类别集合获取")
    public OfficeResopnseBean getAnnualVacationInfo(Integer type, HttpServletRequest request,Integer pageNo,Integer pageSize,Integer personflag) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("获取人员类别信息[{}][{}]", userId, JSONUtils.toString(type));
        Result<PublicDicVO> result = personTypeManager.getPersonTypeInfoList(pageNo,pageSize, type,personflag);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @PostMapping("/add")
    @OperLog(operType = OperLogType.ADD,operDesc = "人员财务类别新增")
    public OfficeResopnseBean addPersonType(@RequestBody PublicDicVO publicDicVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("新增人员类别信息[{}][{}]", userId, JSONUtils.toString(publicDicVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("新增成功");
        try {
            personTypeManager.addPersonType(userId, publicDicVO);
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("新增失败");
        }
        return responseBean;
    }

    @PostMapping("/update")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "人员财务类别修改")
    public OfficeResopnseBean updatePersonType(@RequestBody PublicDicVO publicDicVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("修改人员类别信息[{}][{}]", userId, JSONUtils.toString(publicDicVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("修改成功");
        try {
            personTypeManager.updatePersonType(userId, publicDicVO);
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败");
        }
        return responseBean;
    }

    @GetMapping("/logout")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "人员财务类别注销")
    public OfficeResopnseBean logoutPersonTypeFinancial(@RequestParam("id") Integer id ) {
        boolean logoutPersonType = personTypeManager.logoutPersonType(id);
        return OfficeResopnseBean.newSuccessBean(logoutPersonType);
    }

    @GetMapping("/getpostandcostrulelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "岗位与费用规则查询")
    public OfficeResopnseBean getpostandcostrulelist() {
        List<PostAndCostRuleVO> result = postAndCostRuleManager.getPostAndCostRuleInfoList();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/getcostlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "费用类别集合查询")
    public OfficeResopnseBean getcostlist() {
        List<SystemDicDTO> result = postAndCostRuleManager.getCostList();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    @GetMapping("/getfinanceList")
    @OperLog(operType = OperLogType.QUERY,operDesc = "财务类别集合查询")
    public OfficeResopnseBean getFinanceList() {
        List<PublicDicDTO> result = postAndCostRuleManager.getFinanceList();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }


    @PostMapping("/updatepostandcostrule")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "岗位与费用规则修改")
    public OfficeResopnseBean updatePersonType(@RequestBody PostAndCostRuleVO publicDicVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("修改人员类别信息[{}][{}]", userId, JSONUtils.toString(publicDicVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("修改成功");
        try {
            postAndCostRuleManager.updatePostAndCostRule(publicDicVO);
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败");
        }
        return responseBean;
    }

    @GetMapping("/deletepostandcostrule")
    @OperLog(operType = OperLogType.DELETE,operDesc = "岗位与费用规则删除")
    public OfficeResopnseBean logoutPersonType(@RequestParam("id") Integer id ) {
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        try {
            if(postAndCostRuleManager.deletePostAndCostRule(id)){
                responseBean.setMsg("删除成功");
            }else{
                responseBean.setCode(500);
                responseBean.setMsg("删除失败");
            }
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("删除失败");
        }
        return responseBean;
    }

    @GetMapping("/selectWithDept")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "查询部门下所有的岗位财务类别信息(按岗位)")
    public OfficeResopnseBean selectWithDept(String dept) {
        List<DeptCostMaintainVO> result = deptCostMaintainManager.selectWithDept(dept);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;

    }

    @GetMapping("/getDeptFinancialType")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "查询部门下所有的岗位财务类别信息（按部门)")
    public OfficeResopnseBean getDeptFinancialType(String dept) {
        DeptCostMaintainVO result = deptCostMaintainManager.getDeptFinancialType(dept);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }


    @GetMapping("/listDeptForMaintainSelect")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "获取部门维护信息")
    public OfficeResopnseBean listDeptForMaintainSelect(DeptMaintainInfoQueryCnd cnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("[{}]获取部门维护信息[{}]", userId, JSONUtils.toString(cnd));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Result<DeptCostMaintainInfoVO> result = deptCostMaintainManager.listDeptInfo(userId, cnd);
        responseBean.setBody(result);
        return responseBean;
    }

    @PostMapping("/updateDeptCost")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "按部门更新财物类别信息(更新同时删除该部门下所有岗位的维护信息)")
    public OfficeResopnseBean updateDeptCost(@RequestBody DeptCostMaintainVO deptCostMaintainVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("修改部门财务类别信息[{}][{}]", userId, JSONUtils.toString(deptCostMaintainVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean(deptCostMaintainManager.updateDeptCost(userId,deptCostMaintainVO));
        return responseBean;
    }

    @PostMapping("/updatePostCost")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "按照岗位更新财物类别信息")
    public OfficeResopnseBean updatePostCost(@RequestBody List<DeptCostMaintainVO> deptCostMaintainVO, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("修改部门下岗位类别信息[{}][{}]", userId, JSONUtils.toString(deptCostMaintainVO));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        List<String> strings = deptCostMaintainManager.updatePostCost(userId, deptCostMaintainVO);
        String names = "";
        if(strings.size()!=0){
            for (String string : strings) {
                names  = names+string+",";
            }
        }
        responseBean.setBody(names);
        return responseBean;
    }



    @PostMapping("/updateDeptInfoWithPage")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "修改部门维护信息")
    public OfficeResopnseBean updateDeptInfoWithPage(@RequestBody List<DeptMaintainInfoQueryCnd> cnd, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        LOGGER.info("修改部门维护类别信息[{}][{}]", userId, JSONUtils.toString(cnd));
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("修改成功");
        try {
            deptCostMaintainManager.updateDeptInfoWithPage(userId,cnd);
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败");
        }
        return responseBean;
    }

    @GetMapping("/getpersonfinancialviewlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "特殊人员财务类别查询")
    public OfficeResopnseBean getPersonFinancialList(PersonFinancialViewVO personFinancialViewVO) {
        Result<PersonFinancialViewVO> result = personFinancialViewManager.getPersonFinancialList(personFinancialViewVO);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }


    @PostMapping("/updatepersonfinancialview")
    @OperLog(operType = OperLogType.QUERY,operDesc = "特殊人员财务类别修改")
    public OfficeResopnseBean updatepersonfinancialview(@RequestBody List<PersonFinancialViewVO> personFinancialViewVOList, HttpServletRequest request) {
        String userId = ContextUtils.getUserId(request);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setMsg("修改成功");
        try {
            personFinancialViewManager.updatePersonFinancial(userId,personFinancialViewVOList);
        } catch(Exception e) {
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("修改失败");
        }
        return responseBean;
    }

}

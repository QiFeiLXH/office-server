package com.bsoft.office.common.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.condition.*;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.manager.*;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.*;
import com.bsoft.person.dto.HumanDicDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/23 10:41
 * @Description 公用api 如人员选择、部门选择等
 */
@RestController
@RequestMapping("/publicapi")
public class PublicApiController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PublicApiController.class);

    @Autowired
    private PersonPublicManager personPublicManager;
    @Autowired
    private DeptPublicManager deptPublicManager;
    @Autowired
    private EmployPublicManager employPublicManager;
    @Autowired
    private CompanyDicManager companyDicManager;
    @Autowired
    private CustomerManager customerManager;
    @Autowired
    private FilePublicManager filePublicManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private SystemDicManager systemDicManager;
    @Autowired
    private HumanDicManager humanDicManager;
    @Autowired
    private CustomerContactManager customerContactManager;
    @Autowired
    private IGenerator iGenerator;

    /**
     * 获取部门选择器组件数据
     * @param logout 注销标志 0未注销，1注销
     */
    @RequestMapping(value = "/depttree",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询部门树结构")
    public OfficeResopnseBean getDeptTreeList(@RequestParam String logout){
        List<DeptVO> deptVOS = deptPublicManager.getDeptTree(logout);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(deptVOS);
        LOGGER.info("获取部门树结构", JSONUtils.toString(deptVOS));
        return bean;
    }

    /**
     * 获取部门选择器组件数据
     * @param logout 注销标志 ''全部，0未注销，1注销
     * @param deptType 部门类别 ''全部，1行政职能，2大区，3事业部，4其他
     */
    @GetMapping(value = "/deptselecttree")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询部门树结构")
    public OfficeResopnseBean getDeptSelectTreeList(@RequestParam String logout, @RequestParam(required = false) String deptType){
        List<DeptVO> deptVOS = deptPublicManager.listDeptForSelect(logout, deptType);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(deptVOS);
        LOGGER.info("获取部门选择器的部门列表[{}][{}]", logout, deptType);
        return bean;
    }

    @GetMapping(value = "/deptselectwithperson")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-根据权限查询部门列表")
    public OfficeResopnseBean getDeptSelectTreeWithPersonList(@RequestParam String logout, @RequestParam(required = false) String deptType,@RequestParam Integer all,HttpServletRequest request){
        String personId = "";
        if (all == 1){
            personId = "全部";
        }else{
            personId = ContextUtils.getUserId(request);
        }
        List<DeptVO> deptVOS = deptPublicManager.listDeptForSelectWithPerson(logout, deptType,personId);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(deptVOS);
        LOGGER.info("获取部门选择器的部门列表[{}][{}][{}]", logout, deptType,personId);
        return bean;
    }

    /**
     * 人员选择器——根据工号得到人员信息（没有工号则默认查登录人信息）
     * @param userId 员工工号
     */
    @GetMapping(value = "/getcurrentperson")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-根据工号查询人员信息")
    public OfficeResopnseBean getCurrentPerson(@RequestParam(required = false) String userId, HttpServletRequest request){
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        if(userId == null){
            userId = ContextUtils.getUserId(request);
        }
        PersonSelectViewVO currentPerson = personPublicManager.getCurrentPerson(userId);
        responseBean.setBody(currentPerson);
        LOGGER.info("人员选择器——根据工号得到人员信息[{}]",userId);
        return responseBean;
    }

    /**
     * 人员选择器——根据条件查找人员
     * @param queryCnd 查询参数
     * @return
     */
    @RequestMapping(value = "/personselect",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询人员信息列表")
    public OfficeResopnseBean getPersonSelectList(PersonSelectQueryCnd queryCnd){
        LOGGER.info("人员选择器——根据条件查找人员[{}]", JSONUtils.toString(queryCnd));
        List<PersonSelectViewVO> persons = personPublicManager.getPersonSelectList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(persons);
    }


    /**
     * 人员选择器——根据拼音简码查找人员
     * @param simpleCode 拼音简码
     * @return
     */
    @RequestMapping(value = "/personselectlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询人员信息列表（拼音码）")
    public OfficeResopnseBean findPersonSelectList(@RequestParam String simpleCode){
        List<PersonSelectViewVO> persons = personPublicManager.findPersonSelectList(simpleCode);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(persons);
        LOGGER.info("人员选择器——根据拼音码查找人员");
        return responseBean;
    }

    /**
     * 人员选择器——根据姓名（拼音），是否离职查询人员
     * @param inputContent 输入内容
     * @param isValid -1 全部 0在职 1离职
     * @return
     */
    @RequestMapping(value = "/personquery",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询人员信息列表（拼音码、是否离职）")
    public OfficeResopnseBean findSelectPersonList(@RequestParam(required = false) String inputContent, @RequestParam Integer isValid){
        List<PersonSelectViewVO> persons = personPublicManager.findSelectPersonList(inputContent, isValid);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(persons);
        LOGGER.info("姓名（拼音）:{}，是否离职:{}查询人员",inputContent,isValid);
        return responseBean;
    }

    /**
     * 获取省市县
     * @return
     */
    @GetMapping(value = "/getarea")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-获取省市县字典")
    public OfficeResopnseBean getArea(){
        List<AdministrativeAreaVO> area = employPublicManager.getAdministrativeAreaTree();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(area);
        return responseBean;
    }


    /**
     * 获取公司选择器组件数据
     * @param type 1 费用归属，2 社保缴纳地，3 人员归属公司
     */
    @GetMapping("/companylist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-根据用途类型获取分子公司列表")
    public OfficeResopnseBean getSocialCompanySelectList(Integer type){
        List<CompanyDicVO> companyList = companyDicManager.getCompanyDic(type);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(companyList);
        LOGGER.info("获取公司列表", JSONUtils.toString(companyList));
        return bean;
    }

    /**
     * 获取客户选择组件列表
     * @param queryCnd 查询参数
     */
    @GetMapping("/customerlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-获取客户列表")
    public OfficeResopnseBean getCustomerSelectList(CustomerQueryCnd queryCnd) {
        LOGGER.info("客户选择组件——获取客户列表");
        Result<CustomerVO> result = customerManager.getCustomerList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 获取客户往来单位列表
     */
    @GetMapping("/customercontact")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-获取客户往来单位")
    public OfficeResopnseBean getCustomerContactList(@RequestParam Integer pageNo,
                                                     @RequestParam Integer pageSize,
                                                     @RequestParam(required = false) String inputContent) {
        LOGGER.info("客户选择组件——获取客户列表");
        Result<CustomerContactVO> result = customerContactManager.getCustomerContact(pageNo, pageSize, inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    @GetMapping(value = "/showimage")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-显示图片")
    public void showImage(Integer fileId, HttpServletResponse response){
        OutputStream outputStream = null;
        try {
            byte[] data = filePublicManager.showImageByte(fileId);
            outputStream = response.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
        } catch (IOException e) {
            LOGGER.error("请求图片失败！");
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取公用代码字典
     * @param queryCnd 查询参数
     */
    @GetMapping(value = "/pubdiclist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询公用代码字典")
    public OfficeResopnseBean getPublicDicList(PublicDicSelectQueryCnd queryCnd) {
        List<PublicDicVO> list = publicDicManager.getPublicDicSelectList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 获取公用代码字典
     * @param queryCnd 查询参数
     */
    @GetMapping(value = "/getconstructiontypelist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取承建分工列表-查询公用代码字典")
    public OfficeResopnseBean getConstructionTypeList(PublicDicSelectQueryCnd queryCnd) {
        List<PublicDicVO> list = publicDicManager.getPublicDicSelectList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 获取系统代码字典
     * @param queryCnd 查询参数
     */
    @GetMapping(value = "/sysdiclist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询系统代码字典")
    public OfficeResopnseBean getSystemDicList(SystemDicSelectQueryCnd queryCnd) {
        List<SystemDicVO> list = systemDicManager.getSystemDicSelectList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 获取人事代码字典
     * @param queryCnd 查询参数
     */
    @GetMapping(value = "/hrdiclist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询人事代码字典")
    public OfficeResopnseBean getHumanDicList(HumanDicSelectQueryCnd queryCnd) {
        List<HumanDicVO> list = humanDicManager.getHumanDicSelectList(queryCnd);
        return OfficeResopnseBean.newSuccessBean(list);
    }
    @GetMapping(value = "/systemlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询信息系统列表")
    public OfficeResopnseBean getSystemList(){
        List<PublicDicVO> list = publicDicManager.getPublicDicsWithFlag(9908,1);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 获取根据工号列表查询对应的员工列表
     * @param
     */
    @GetMapping(value = "/personswithpersonids")
    @OperLog(operType = OperLogType.QUERY,operDesc = "公用组件-查询系统代码字典")
    public OfficeResopnseBean getPersonsWithPersonIds(@RequestParam(name="personIds",required = false)List<String> personIds) {
        if (personIds == null) {
            personIds = new ArrayList<>();
        }
        List<PersonSelectViewVO> list = personPublicManager.getPersonsWithPersonIds(personIds);
        return OfficeResopnseBean.newSuccessBean(list);
    }



}

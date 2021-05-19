package com.bsoft.office.organ.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.FilePublicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.vo.CommunicationSubsidyVO;
import com.bsoft.office.organ.condition.RecruitmentInformationQuery;
import com.bsoft.office.organ.manager.EmployManager;
import com.bsoft.office.common.manager.CompanyDicManager;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.CompanyDicVO;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.organ.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/5/20
 * @Description:
 */
@RestController
@RequestMapping("/recruitmentinfo")
public class RecruitmentInfoController {

    private static Logger LOGGER  = LoggerFactory.getLogger(RecruitmentInfoController.class);

    @Autowired
    private EmployManager employManager;

    @Autowired
    private CompanyDicManager companyDicManager;

    @Autowired
    private FilePublicManager filePublicManager;

    @GetMapping(value = "/getrecruitmentinfolist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询招聘信息列表")
    public OfficeResopnseBean getRecruitmentInfoList(RecruitmentInformationQuery query, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        query.setUserId(userId);
        Map<String,Object> map = employManager.getLastRecruitmentInformation(query);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(map);
        return responseBean;
    }

    @GetMapping(value = "/getrecruitmentauditinfo")
    @OperLog(operType = OperLogType.QUERY,operDesc = "审核时查询招聘信息详情")
    public OfficeResopnseBean getRecruitmentAuditInfo(@RequestParam Integer id){
        EmployAuditVO auditInfo = employManager.getRecruitmentAuditInfo(id);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(auditInfo);
        return responseBean;
    }

    @GetMapping(value = "/initrecruitmentbaseinfo")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询所属公司、通讯补贴字典")
    public OfficeResopnseBean initRecruitmentBaseInfo(HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> map = employManager.initRecruitmentBaseInfo(userId);
        responseBean.setBody(map);
        return responseBean;
    }

    @GetMapping(value = "/getrecruitmentinfo")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询人员招聘基本信息")
    public OfficeResopnseBean getRecruitmentInfo(@RequestParam Integer recruitmentId){
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        RecruitmentBaseInfoVO recruitmentInfo = employManager.getRecruitmentInfo(recruitmentId);
        responseBean.setBody(recruitmentInfo);
        return responseBean;
    }

    @GetMapping(value = "/initrecruitmentauditinfo")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询院校、专业、称谓字典")
    public OfficeResopnseBean initRecruitmentAuditInfo(HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        Map<String,Object> map = employManager.initRecruitmentAuditInfo(userId);
        responseBean.setBody(map);
        return responseBean;
    }

    @GetMapping(value = "/showimage")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获显示图片信息")
    public void showImage(Integer id, HttpServletResponse response){
        OutputStream outputStream = null;
        try {
            byte[] data = employManager.showImageByte(id);
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

    @GetMapping(value = "/getarea")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询新省市县字典")
    public OfficeResopnseBean getArea(){
        List<AdministrativeAreaVO> area = employManager.getAdministrativeAreaTree();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(area);
        return responseBean;
    }

    @GetMapping(value = "/getoldarea")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询旧省市县字典")
    public OfficeResopnseBean getOldArea(){
        List<AdministrativeDivisionVO> area = employManager.getAdministrativeDivisionTree();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(area);
        return responseBean;
    }

    @GetMapping(value = "/getoneoldarea")
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据code查询旧省市县信息")
    public OfficeResopnseBean getOneOldArea(@RequestParam Integer code){
        AdministrativeDivisionVO area = employManager.getOneOldArea(code);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(area);
        return responseBean;
    }

    @GetMapping(value = "/getpublicdic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询公用代码字典")
    public OfficeResopnseBean getPublicDic(@RequestParam Integer type){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        List<PublicDicVO> vo = employManager.getPublicDic(type);
        bean.setBody(vo);
        return bean;
    }

    @GetMapping(value = "/getcompanydic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询公司机构字典")
    public OfficeResopnseBean getCompanyDic(@RequestParam Integer type){
        List<CompanyDicVO> vo = companyDicManager.getCompanyDic(type);
        return OfficeResopnseBean.newSuccessBean(vo);
    }

    @GetMapping(value = "/gethumandic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询人事代码字典")
    public OfficeResopnseBean getHumanDic(@RequestParam Integer type){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        List<HumanDicVO> vo = employManager.getHumanDic(type);
        bean.setBody(vo);
        return bean;
    }

    @GetMapping(value = "/getsubsidy")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询通讯补贴字典")
    public OfficeResopnseBean getSubsidy(){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        List<CommunicationSubsidyVO> subsidy = employManager.getSubsidy();
        bean.setBody(subsidy);
        return bean;
    }

    @GetMapping(value = "getadministrativearea")
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据上级ID查询新省市县字典")
    public OfficeResopnseBean getAdministrativeArea(@RequestParam Integer parentId){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        List<AdministrativeAreaVO> area = employManager.getAdministrativeArea(parentId);
        bean.setBody(area);
        return bean;
    }

    @PostMapping(value = "/saverecruitmentbaseinfo")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存招聘人员基本信息")
    public OfficeResopnseBean saveRecruitmentBaseInfo(@RequestBody RecruitmentInformationViewVO info){
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        RecruitmentInformationViewVO baseInfo = employManager.saveRecruitmentBaseInfo(info);
        responseBean.setBody(baseInfo);
        return responseBean;
    }

    @PostMapping(value = "/saverecruitmentauditinfo")
    @OperLog(operType = OperLogType.SAVE,operDesc = "审核招聘人员信息")
    public OfficeResopnseBean saveRecruitmentAuditInfo(@RequestBody EmployAuditVO info,HttpServletRequest request){
        if (info.getRecruitmentInfoView().getStatus() == 8) {
            String personId = ContextUtils.getUserId(request);
            info.getRecruitmentInfoView().setAuditter(personId);
        }
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        EmployAuditVO baseInfo = employManager.saveRecruitmentAuditInfo(info);
        responseBean.setBody(baseInfo);
        return responseBean;
    }

    @GetMapping(value = "/familylist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询招聘人员的家庭情况信息")
    public OfficeResopnseBean familyInfoList(@RequestParam Integer recruitmentId){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        List<FamilyPersonVO> familyPersonVOS = employManager.getFamilyInfo(recruitmentId);
        bean.setBody(familyPersonVOS);
        return bean;
    }

    @PostMapping(value = "/savefamily")
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改家庭情况")
    public OfficeResopnseBean saveFamily(@RequestBody List<FamilyPersonVO> familyPersonInfoVOS){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        employManager.saveFamilyInfo(familyPersonInfoVOS);
        return bean;
    }

    @DeleteMapping(value = "/deletefamily")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除家庭情况信息")
    public OfficeResopnseBean deleteFamily(@RequestParam Integer id){
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        employManager.deleteFamily(id);
        return responseBean;
    }

    @GetMapping(value = "/worklist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询招聘人员的工作经历")
    public OfficeResopnseBean workInfoList(@RequestParam Integer recruitmentId){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        List<WorkInfoVO> workInfo = employManager.getWorkInfo(recruitmentId);
        bean.setBody(workInfo);
        return bean;
    }

    @PostMapping(value = "/savework")
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改工作经历")
    public OfficeResopnseBean saveWork(@RequestBody List<WorkInfoVO> workInfoVOS){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        employManager.saveWorkInfo(workInfoVOS);
        return bean;
    }

    @DeleteMapping(value = "/deletework")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除工作经历信息")
    public OfficeResopnseBean deleteWork(@RequestParam Integer id){
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        employManager.deleteWork(id);
        return responseBean;
    }

    @GetMapping(value = "/educationlist")
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询招聘人员的教育经历")
    public OfficeResopnseBean educationInfoList(@RequestParam Integer recruitmentId){
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        List<EducationVO> educationInfo = employManager.getEducationInfo(recruitmentId);
        bean.setBody(educationInfo);
        return bean;
    }

    @PostMapping(value = "/saveeducation")
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改教育经历")
    public OfficeResopnseBean saveEducationInfo(@RequestBody List<EducationVO> educationInfoVOS){
        employManager.saveEducaiInfo(educationInfoVOS);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        return bean;
    }

    @DeleteMapping(value = "/deleteeducation")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除教育经历信息")
    public OfficeResopnseBean deleteEducation(@RequestParam Integer id){
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        employManager.deleteEducation(id);
        return responseBean;
    }

    @DeleteMapping(value = "/deleterecruitmentinfo")
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除招聘信息")
    public OfficeResopnseBean deleteRecruitmentInfo(@RequestParam Integer id){
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        employManager.deleteRecruitmentInfo(id);
        return responseBean;
    }

    @PutMapping(value = "/sendrecruitmentemail")
    @OperLog(operType = OperLogType.OTHER,operDesc = "发送招聘邮件")
    public OfficeResopnseBean sendRecruitmentEmail(@RequestBody RecruitmentBaseInfoVO baseInfo){
        OfficeResopnseBean resopnseBean = OfficeResopnseBean.newSuccessBean();
        employManager.sendRecruitmentEmail(baseInfo);
        return resopnseBean;
    }

    @GetMapping(value="/getworkyears")
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取工龄")
    public OfficeResopnseBean getWorkYears(@RequestParam Integer employId){
        OfficeResopnseBean response = OfficeResopnseBean.newSuccessBean();
        Double workYears = employManager.getWorkYears(employId);
        response.setBody(workYears);
        return response;
    }

    @GetMapping(value = "/getPersonnelGroupDic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据部门、年份获取人员归属群字典")
    public OfficeResopnseBean getPersonnelGroupDic(@RequestParam(required = true) String deptId,@RequestParam(required = true) Integer year){
        List<PublicDicVO> list = employManager.getPersonnelGroupDic(deptId,year);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 退回到人员未提交状态
     */
    @RequestMapping(value = "/doback",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "退回到人员未提交状态")
    public OfficeResopnseBean doBack(@RequestParam Integer employId){
        employManager.doBack(employId);
        return OfficeResopnseBean.newSuccessBean();
    }

    /** 上传文件 */
    @PostMapping(value = "/imagereupload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传文件")
    public OfficeResopnseBean uploadImage(@RequestParam MultipartFile file, HttpServletRequest request) {
        Integer menuId = ContextUtils.getMenuId(request);
        try {
            Integer fileId = filePublicManager.uploadFile(file, menuId);
            return OfficeResopnseBean.newSuccessBean(fileId);
        } catch (IOException e) {
            e.printStackTrace();
            return OfficeResopnseBean.newFailBean(500,"上传失败");
        }
    }

    /** 重传 */
    @PostMapping(value = "/imagerewrite")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "重传文件")
    public OfficeResopnseBean uploadFile(@RequestParam MultipartFile file, @RequestParam Integer fileId) {
        try {
            filePublicManager.rewriteFile(file, fileId);
            return OfficeResopnseBean.newSuccessBean();
        } catch (IOException e) {
            e.printStackTrace();
            return OfficeResopnseBean.newFailBean(500,"重传失败");
        }
    }

    /** 批量总部审核 */
    @GetMapping(value = "/batchaudit")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "总部批量审核")
    public OfficeResopnseBean doBatchHeadquartersAudit(@RequestParam(name="recruitmentIds",required = false) List<Integer> recruitmentIds, HttpServletRequest request) {
       if (recruitmentIds.isEmpty()) {
           recruitmentIds = new ArrayList<>();
       }
        String personId = ContextUtils.getUserId(request);
        employManager.doBatchHeadquartersAudit(recruitmentIds, personId);
        return OfficeResopnseBean.newSuccessBean("批量总部审核成功");
    }
}

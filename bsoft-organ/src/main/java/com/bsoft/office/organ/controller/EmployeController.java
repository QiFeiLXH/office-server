package com.bsoft.office.organ.controller;

import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.organ.manager.EmployManager;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.organ.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * 入司资料填写相关
 */
@RestController
@RequestMapping(value = "/employe")
public class EmployeController {

    private static final Integer MENUID = 0;
    @Autowired
    private EmployManager employManager;

    private static final Logger logger = LoggerFactory.getLogger(EmployeController.class);

    @RequestMapping(value = "checkrecruitmentstatus",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.OTHER,operDesc = "招聘二维码验证招聘状态")
    public OfficeResopnseBean checkRecruitmentStatus(@RequestParam("id") String id,HttpServletRequest request){
        String zpid = new String(Base64.getDecoder().decode(id.getBytes()));
        ContextUtils.setAttribute(request,"zpid",zpid);
        Map<String,Object> map = employManager.checkRecruitmentStatus(zpid);
        if (Integer.valueOf(map.get("code").toString()) == 200){
            return OfficeResopnseBean.newSuccessBean();
        } else {
            return OfficeResopnseBean.newFailBean(Integer.valueOf(map.get("code").toString()),map.get("msg").toString());
        }
    }

    @RequestMapping(value = "sendsms",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.OTHER,operDesc = "招聘发送手机验证码")
    public OfficeResopnseBean sendMessage(@RequestParam("mobileno") String mobileno,HttpServletRequest request){
        String zpid = ContextUtils.getAttribute(request,"zpid");
        Map<String,Object> map = employManager.sendHYMessage(mobileno,zpid,request);
        if (Integer.valueOf(map.get("code").toString()) == 200){
            return OfficeResopnseBean.newSuccessBean();
        } else {
            return OfficeResopnseBean.newFailBean(Integer.valueOf(map.get("code").toString()),map.get("msg").toString());
        }
    }

    @RequestMapping(value = "checksms",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.OTHER,operDesc = "招聘验证短信验证码")
    public OfficeResopnseBean checkSms(@RequestParam("mobileno") String mobileno, @RequestParam("smsCode") String smsCode, HttpServletRequest request){
        String zpid = ContextUtils.getAttribute(request,"zpid");
        Map<String,Object> map = employManager.checkHYMessage(mobileno,smsCode,zpid,request);
        if (Integer.valueOf(map.get("code").toString()) == 200){
            return OfficeResopnseBean.newSuccessBean();
        } else {
            return OfficeResopnseBean.newFailBean(Integer.valueOf(map.get("code").toString()),map.get("msg").toString());
        }
    }

    @RequestMapping(value = "gethumandic",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "招聘获取人事代码字典")
    public OfficeResopnseBean humanDic(@RequestParam("type") Integer type){
        List<HumanDicVO> humanDicVOS = employManager.getHumanDic(type);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(humanDicVOS);
        return bean;
    }

    @RequestMapping(value = "/getemployinfo",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "招聘获取人员基本信息")
    public OfficeResopnseBean getEmployeInfo(HttpServletRequest request){
        Integer zpid = Integer.valueOf(ContextUtils.getAttribute(request,"zpid"));
        RecruitmentInformationViewVO recruitmentInformationViewVO = employManager.getEmployeInfoById(zpid);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(recruitmentInformationViewVO);
        return bean;
    }

    @RequestMapping(value = "/saveemployinfo",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "招聘保存人员基本信息")
    public OfficeResopnseBean saveEmployeInfo(@RequestBody RecruitmentInformationVO recruitmentInformationVO){
        RecruitmentInformationViewVO recruitmentInformationViewVO  = employManager.updateEmployeInfo(recruitmentInformationVO);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(recruitmentInformationViewVO);
        return bean;
    }

    @RequestMapping(value = "/uploadimage",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "招聘上传图片")
    public OfficeResopnseBean uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            throw new ServiceException("上传失败，请选择文件");
        }
        Map<String,Object> map = employManager.uploadImage(file,MENUID);
        if (map.get("code").equals(200)){
            OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
            bean.setBody(map);
            return bean;
        } else {
            return OfficeResopnseBean.newFailBean(500, (String) map.get("msg"));
        }
    }

    @RequestMapping(value = "/showimage",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "招聘显示图片")
    public OfficeResopnseBean showImage(@RequestParam("id") Integer id){
        String data = employManager.showImage(id);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(data);
        return bean;
    }

    @RequestMapping(value = "/getfamilylist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "招聘获取家庭成员信息")
    public OfficeResopnseBean familyInfoList(HttpServletRequest request){
        Integer zpid = Integer.valueOf(ContextUtils.getAttribute(request,"zpid"));
        List<FamilyPersonVO> familyPersonVOS = employManager.getFamilyInfo(zpid);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(familyPersonVOS);
        return bean;
    }

    @RequestMapping(value = "/savefamily",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "招聘保存家庭成员信息")
    public OfficeResopnseBean saveFamilyInfo(@RequestBody List<FamilyPersonVO> familyPersonInfoVOS){
        employManager.saveFamilyInfo(familyPersonInfoVOS);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/deletefamily",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "招聘删除家庭成员信息")
    public OfficeResopnseBean deleteFamilyInfo(@RequestParam("id") Integer id){
        employManager.deleteFamily(id);
        logger.info("删除人员家庭人员信息成功！");
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/geteducationlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "招聘获取教育情况信息")
    public OfficeResopnseBean educationInfoList(HttpServletRequest request){
        Integer zpid = Integer.valueOf(ContextUtils.getAttribute(request,"zpid"));
        List<EducationVO> educationVOS = employManager.getEducationInfo(zpid);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(educationVOS);
        return bean;
    }

    @RequestMapping(value = "/saveeducation",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "招聘保存教育情况信息")
    public OfficeResopnseBean saveEducationInfo(@RequestBody List<EducationVO> educationInfoVOS){
        employManager.saveEducaiInfo(educationInfoVOS);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/deleteeducation",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "招聘删除教育情况信息")
    public OfficeResopnseBean deleteEducationInfo(@RequestParam("id") Integer id){
        employManager.deleteEducation(id);
        logger.info("删除招聘人员的教育信息成功！");
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/deletecertificate",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "招聘删除教育其他证书信息")
    public OfficeResopnseBean deleteCertificate(@RequestParam("id") Integer id){
        employManager.deleteCertificate(id);
        logger.info("删除其他证书信息成功！");
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/getarea",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "招聘获取旧省市县字典")
    public OfficeResopnseBean getArea(){
        List<Map<String,Object>> list = employManager.getAreas();
        logger.info("获取旧省市县字典成功！");
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(list);
        return bean;
    }

    @RequestMapping(value = "/getworkinfo",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "招聘获取工作情况信息")
    public OfficeResopnseBean getWorkInfo(HttpServletRequest request){
        Integer zpid = Integer.valueOf(ContextUtils.getAttribute(request,"zpid"));
        List<WorkInfoVO> workInfoVOS = employManager.getWorkInfo(zpid);
        logger.info("获取招聘人员的工作信息成功，zpid=[{}]！",zpid);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(workInfoVOS);
        return bean;
    }

    @RequestMapping(value = "/saveworkinfo",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "招聘保存工作情况信息")
    public OfficeResopnseBean saveWorkInfo(@RequestBody List<WorkInfoVO> workInfoVOS){
        employManager.saveWorkInfo(workInfoVOS);
        logger.info("更新工作信息成功！");
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/deleteworkinfo",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "招聘删除工作情况信息")
    public OfficeResopnseBean deleteWorkInfo(@RequestParam("id") Integer id){
        employManager.deleteWork(id);
        logger.info("删除招聘人员的工作信息成功！");
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/getbankcard",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "招聘获取工资卡信息")
    public OfficeResopnseBean getBankCard(HttpServletRequest request){
        Integer zpid = Integer.valueOf(ContextUtils.getAttribute(request,"zpid"));
        BankCardInfoVO bankCardInfoVO = employManager.getBankCardInfo(zpid);
        logger.info("获取工资卡信息成功,zpid = [{}]",zpid);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(bankCardInfoVO);
        return bean;
    }

    @RequestMapping(value = "/savebankinfo")
    @OperLog(operType = OperLogType.SAVE,operDesc = "招聘更新工资卡信息")
    public OfficeResopnseBean saveBankCard(@RequestBody BankCardInfoVO bankCardInfoVO){
        employManager.saveBankCardInfo(bankCardInfoVO);
        logger.info("更新工资卡信息成功！");
        return OfficeResopnseBean.newSuccessBean();
    }
}

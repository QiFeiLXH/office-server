package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.cost.dto.AccountCaliberDTO;
import com.bsoft.cost.service.AccountCaliberService;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.vo.CommunicationSubsidyVO;
import com.bsoft.office.organ.condition.RecruitmentInformationQuery;
import com.bsoft.office.organ.manager.EmployManager;
import com.bsoft.office.common.TimeConsumer.TimeConsumer;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.CompanyDicManager;
import com.bsoft.office.common.sort.ListBeanSort;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.CompanyDicVO;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.organ.vo.*;
import com.bsoft.person.dto.*;
import com.bsoft.common.dto.CommunicationSubsidyDTO;
import com.bsoft.person.service.EmployService;
import com.bsoft.person.service.PersonService;
import org.apache.dubbo.config.annotation.Reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class EmployManagerImpl implements EmployManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployManagerImpl.class);

    @Reference(timeout = 60000)
    private EmployService employService;

    @Reference(timeout = 60000)
    private PersonService personService;

    @Reference(timeout = 60000)
    private PublicDicService publicDicService;

    @Reference(timeout = 60000)
    private AccountCaliberService accountCaliberService;
    @Autowired
    private CompanyDicManager companyDicManager;

    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Map<String,Object> getLastRecruitmentInformation(RecruitmentInformationQuery query) {
        EmployQueryDTO queryDTO = generatorUtil.convert(query,EmployQueryDTO.class);
        Result<EmployDTO> result = employService.getRecruitmentRecentInfo(queryDTO);
        Result<RecruitmentBaseInfoVO> information = generatorUtil.convert(result, RecruitmentBaseInfoVO.class);
        List<RecruitmentBaseInfoVO> list = information.getItems();
        Map<Date, List<RecruitmentBaseInfoVO>> groupByMap = list.stream().collect(Collectors.groupingBy(RecruitmentBaseInfoVO::getStartDate, LinkedHashMap::new,Collectors.toList()));
        List<StartDateTreeVO> tree = getStartDateTree(query);
        Map<String,Object> map = new HashMap<>();
        map.put("group",groupByMap);
        map.put("tree",tree);
        map.put("data",information);
        return map;
    }

    @Override
    public Map<String, Object> initRecruitmentAuditInfo(String userId) {
        Map<String,Object> map = initRecruitmentBaseInfo(userId);
        List<HumanDicDTO> school = personService.getHumanDic(11);//院校
        List<HumanDicVO> schoolDic = generatorUtil.convert(school,HumanDicVO.class);
        List<HumanDicDTO> major = personService.getHumanDic(9);//专业
        List<HumanDicVO> majorDic = generatorUtil.convert(major,HumanDicVO.class);
        List<HumanDicDTO> appellation = personService.getHumanDic(1);//称谓
        List<HumanDicVO> appellationDic = generatorUtil.convert(appellation,HumanDicVO.class);

        map.put("schoolDic",schoolDic);
        map.put("majorDic",majorDic);
        map.put("appellationDic",appellationDic);

        return map;
    }

    @Override
    public Map<String, Object> initRecruitmentBaseInfo(String userId) {
        Map<String,Object> map = new HashMap<>();
        List<CommunicationSubsidyDTO> communicationSubsidy = employService.getCommunicationSubsidy();
        List<CommunicationSubsidyVO> communicationSubsidyDic = generatorUtil.convert(communicationSubsidy,CommunicationSubsidyVO.class);

        List<CompanyDicVO> companyDic = companyDicManager.getCompanyDic(3);
        map.put("companyDic",companyDic);
        map.put("communicationSubsidyDic",communicationSubsidyDic);
        return map;
    }

    @Override
    public List<PublicDicVO> getPublicDic(Integer type){
        List<PublicDicDTO> publicDic = publicDicService.getPublicDic(type);
        return generatorUtil.convert(publicDic,PublicDicVO.class);
    }

    @Override
    public List<HumanDicVO> getHumanDic(Integer type){
        List<HumanDicDTO> humanDic = personService.getHumanDic(type);//文化程度
        if(type == 14){
            ListBeanSort.sort(humanDic,"id",false);
            List<HumanDicDTO> newAppliedPositionDic = new ArrayList<>();
            for (HumanDicDTO dto:humanDic){
                if (dto.getId() < 50 || dto.getId() > 99){
                    newAppliedPositionDic.add(dto);
                }
            }
            return generatorUtil.convert(newAppliedPositionDic,HumanDicVO.class);
        }
        return generatorUtil.convert(humanDic,HumanDicVO.class);
    }

    @Override
    public List<CommunicationSubsidyVO> getSubsidy(){
        List<CommunicationSubsidyDTO> communicationSubsidy = employService.getCommunicationSubsidy();
        return generatorUtil.convert(communicationSubsidy,CommunicationSubsidyVO.class);
    }

    @Override
    public List<AdministrativeAreaVO> getAdministrativeArea(Integer parentId) {
        List<AdministrativeAreaDTO> administrativeArea = employService.getAdministrativeArea(parentId);
        return generatorUtil.convert(administrativeArea,AdministrativeAreaVO.class);
    }

    @Override
    public RecruitmentInformationViewVO saveRecruitmentBaseInfo(RecruitmentInformationViewVO info) {
        EmployDTO infoDTO = generatorUtil.convert(info, EmployDTO.class);
        infoDTO = employService.saveRecruitmentBaseInfo(infoDTO);
        info.setId(infoDTO.getId());
        return info;
    }

    @Override
    public void deleteFamily(Integer id) {
        employService.deleteFamily(id);
    }

    @Override
    public void deleteWork(Integer id) {
        employService.deleteWork(id);
    }

    @Override
    public void deleteEducation(Integer id) {
        employService.deleteEducation(id);
    }

    @Override
    public EmployAuditVO getRecruitmentAuditInfo(Integer id) {
        EmployAuditDTO  auditInfoDTO = employService.getRecruitmentAuditInfo(id);
        EmployAuditVO auditInfoVO = generatorUtil.convert(auditInfoDTO,EmployAuditVO.class);
        return auditInfoVO;
    }

    @Override
    public EmployAuditVO saveRecruitmentAuditInfo(EmployAuditVO info) {
        List<FamilyPersonVO> familyList = info.getFamilyList();
        familyList.forEach(item -> {if(item.getId() < 0){
            item.setId(null);
        }});
        List<EducationVO> educationList = info.getEducationList();
        educationList.forEach(item -> {if(item.getId() < 0){
            item.setId(null);
        }});
        List<WorkInfoVO> workList = info.getWorkList();
        workList.forEach(item -> {if(item.getId() < 0){
            item.setId(null);
        }});
        EmployAuditDTO infoDTO = generatorUtil.convert(info, EmployAuditDTO.class);
        infoDTO = employService.saveRecruitmentAuditInfo(infoDTO);
        return info;
    }

    @Override
    public void deleteRecruitmentInfo(Integer id) {
        employService.deleteRecruitmentInfo(id);
    }

    @Override
    public void sendRecruitmentEmail(RecruitmentBaseInfoVO baseInfo) {
        EmployDTO infoViewDTO = generatorUtil.convert(baseInfo,EmployDTO.class);
        employService.sendRecruitmentEmail(infoViewDTO);
    }

    @Override
    public List<AdministrativeAreaVO> getAdministrativeAreaTree() {
        List<AdministrativeAreaDTO> areaTree = employService.getAdministrativeAreaTree();
        return generatorUtil.convert(areaTree,AdministrativeAreaVO.class);
    }

    @Override
    public List<AdministrativeDivisionVO> getAdministrativeDivisionTree() {
        List<AdministrativeDivisionDTO> areaTree = employService.getAdministrativeDivisionTree();
        return generatorUtil.convert(areaTree,AdministrativeDivisionVO.class);
    }

    @Override
    public RecruitmentBaseInfoVO getRecruitmentInfo(Integer recruitmentId) {
        EmployDTO recruitmentInfo = employService.getRecruitmentInfo(recruitmentId);
        return generatorUtil.convert(recruitmentInfo,RecruitmentBaseInfoVO.class);
    }

    @Override
    public AdministrativeDivisionVO getOneOldArea(Integer code) {
        AdministrativeDivisionDTO divisionDTO = employService.getDivisionCity(code);
        return generatorUtil.convert(divisionDTO,AdministrativeDivisionVO.class);
    }

    private List<StartDateTreeVO> getStartDateTree(RecruitmentInformationQuery query){
        query.setStartTime(null);
        query.setCheckTime(null);
        EmployQueryDTO queryDTO = generatorUtil.convert(query,EmployQueryDTO.class);
        List<EmployDTO> result = employService.getRecentEmployList(queryDTO);
        List<RecruitmentBaseInfoVO> list = generatorUtil.convert(result, RecruitmentBaseInfoVO.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        List<String> collect = list.stream().map(a -> sdf.format(a.getStartDate())).distinct().collect(Collectors.toList());
        Map<String,List<String>> startDateMap = collect.stream().collect(Collectors.groupingBy(a->a.substring(0,8),LinkedHashMap::new,Collectors.toList()));
        List<StartDateTreeVO> tree = new ArrayList<>();
        try {
            for(Map.Entry<String, List<String>> entry : startDateMap.entrySet()){
                StartDateTreeVO treeVO = new StartDateTreeVO();
                treeVO.setTitle(entry.getKey());
                treeVO.setKey(entry.getKey());
                treeVO.setStartTime(sdf.parse(entry.getKey()+"01日"));
                treeVO.setParent(true);
                List<StartDateTreeVO> children = new ArrayList<>();
                for (String s : entry.getValue()) {
                    StartDateTreeVO child = new StartDateTreeVO();
                    child.setTitle(s.substring(5,11));
                    child.setKey(s);
                    child.setCheckTime(sdf.parse(s));
                    child.setParent(false);
                    children.add(child);
                }
                treeVO.setChildren(children);
                tree.add(treeVO);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServiceException("报到日期树生成失败");
        }
        return tree;
    }

    @Override
    public Map<String, Object> checkRecruitmentStatus(String zpid) {
        Map<String,Object> map = employService.checkRecruitmentStatus(zpid);
        return map;
    }

    @Override
    public Map<String,Object> sendHYMessage(String mobileno, String zpid, HttpServletRequest request) {
        Map<String,Object> res = employService.checkSendMessage(mobileno,zpid);
        if (Integer.valueOf(res.get("code").toString()).intValue() == 200){
            employService.sendMessage(mobileno);
            ContextUtils.setAttribute(request,"zpid",zpid);
            ContextUtils.setAttribute(request,"mobileno",mobileno);
            Map<String,Object> map = new HashMap<>();
            map.put("code",200);
            return map;
        } else {
            return res;
        }
    }

    @Override
    public Map<String,Object> checkHYMessage(String mobile, String smsCode,String zpid,HttpServletRequest request) {
        Map<String,Object> res = employService.checkSendMessage(mobile,zpid);
        if (Integer.valueOf(res.get("code").toString()).intValue() == 200){
            employService.checkSmsCode(mobile,smsCode);
            ContextUtils.setAttribute(request,"zpid",zpid);
            ContextUtils.setAttribute(request,"mobileno",mobile);
            Map<String,Object> map = new HashMap<>();
            map.put("code",200);
            return map;
        } else {
            return res;
        }
    }

    @Override
    public RecruitmentInformationViewVO getEmployeInfo(String mobileno) {
        EmployDTO recruitmentInformationViewDTO = employService.getRecruitmentInfo(mobileno);
        RecruitmentInformationViewVO recruitmentInformationViewVO = generatorUtil.convert(recruitmentInformationViewDTO,RecruitmentInformationViewVO.class);
        LOGGER.info("获取手机号为[{}]的已发右键待入司人员信息[{}]。", mobileno,recruitmentInformationViewVO);
        return recruitmentInformationViewVO;
    }

    @Override
    public RecruitmentInformationViewVO getEmployeInfoById(Integer id) {
        EmployDTO recruitmentInfoViewDTO =  employService.getRecruitmentInfo(id);
        RecruitmentInformationViewVO recruitmentInformationViewVO = generatorUtil.convert(recruitmentInfoViewDTO,RecruitmentInformationViewVO.class);
        return recruitmentInformationViewVO;
    }

    @Override
    public RecruitmentInformationViewVO updateEmployeInfo(RecruitmentInformationVO recruitmentInformationVO) {
        EmployDTO recruitmentInformationDTO = generatorUtil.convert(recruitmentInformationVO,EmployDTO.class);
        employService.upDateEmploymentInfo(recruitmentInformationDTO);
        EmployDTO recruitmentInformationViewDTO = employService.getRecruitmentInfo(recruitmentInformationVO.getId());
        RecruitmentInformationViewVO recruitmentInformationViewVO = generatorUtil.convert(recruitmentInformationViewDTO,RecruitmentInformationViewVO.class);
        return recruitmentInformationViewVO;
    }

    @Override
    public Map<String, Object> uploadImage(MultipartFile file, Integer menuId) {
        Map<String,Object> map = new HashMap<>();
        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            Integer key = employService.uploadImage(bytes,fileName,menuId);
            if (key > 0){
                map.put("code",200);
                map.put("key",key);
            } else {
                map.put("code",500);
                map.put("msg","上传失败！");
            }
            return map;
        } catch (IOException e) {
            throw new ServiceException("上传图片失败！");
        }
    }

    @Override
    public String showImage(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        String data = employService.getImage(id);
        long times = timeConsumer.end();
        LOGGER.info("获取图片[{}]的base64String耗时[{}]",id,times);
        return data;
    }

    @Override
    public byte[] showImageByte(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        byte[] data = employService.getImageByte(id);
        long times = timeConsumer.end();
        LOGGER.info("获取图片[{}]的字节信息耗时[{}]",id,times);
        return data;
    }

    @Override
    public List<FamilyPersonVO> getFamilyInfo(Integer zpid) {
        List<FamilyPersonDTO> familyPersonInfoViewDTOS = employService.getFamilyList(zpid);
        List<FamilyPersonVO> familyPersonVOS = generatorUtil.convert(familyPersonInfoViewDTOS,FamilyPersonVO.class);
        LOGGER.info("获取家庭成员信息成功,zpid=[{}]！",zpid);
        return familyPersonVOS;
    }

    @Override
    public void saveFamilyInfo(List<FamilyPersonVO> list) {
        List<FamilyPersonDTO> familyPersonInfoDTOS = generatorUtil.convert(list,FamilyPersonDTO.class);
        employService.saveFamilyList(familyPersonInfoDTOS);
    }

    @Override
    public List<EducationVO> getEducationInfo(Integer zpid) {
        List<EducationDTO> educationInfoViewDTOS = employService.getEducationInfo(zpid);
        List<EducationVO> educationVOS = generatorUtil.convert(educationInfoViewDTOS,EducationVO.class);
        for (EducationVO e: educationVOS){
            List<CertificateDTO> certificateDTOS = employService.getCertificates(e.getId());
            List<CertificateVO> certificateVOS = generatorUtil.convert(certificateDTOS,CertificateVO.class);
            e.setOthers(certificateVOS);
        }
        return educationVOS;
    }

    @Override
    public void saveEducaiInfo(List<EducationVO> list) {
        List<EducationDTO> educationInfoDTOS = generatorUtil.convert(list,EducationDTO.class);
        employService.saveEducationInfo(educationInfoDTOS);
    }

    @Override
    public void deleteCertificate(Integer id) {
        employService.deleteCertificate(id);
    }

    @Override
    public List<Map<String,Object>> getAreas() {
        List<Map<String,Object>> list = new ArrayList<>();
        List<AdministrativeDivisionDTO> provice = employService.getAdministrativeDivision(1);
        List<AdministrativeDivisionDTO> city = employService.getAdministrativeDivision(2);
        List<AdministrativeDivisionDTO> county = employService.getAdministrativeDivision(3);
        for(AdministrativeDivisionDTO a:provice){
            Map<String,Object> map = new HashMap<>();
            map.put("text",a.getName());
            map.put("id",a.getCode());
            List<Map<String,Object>> cityList = new ArrayList<>();
            for (AdministrativeDivisionDTO b:city){
                if (b.getParentCode().equals(a.getCode())){
                    Map<String,Object> cityMap = new HashMap<>();
                    cityMap.put("text",b.getName());
                    cityMap.put("id",b.getCode());
                    cityList.add(cityMap);
                    List<Map<String,Object>> countyList = new ArrayList<>();
                    for (AdministrativeDivisionDTO c:county){
                        if (c.getParentCode().equals(b.getCode())){
                            Map<String,Object> countMap = new HashMap<>();
                            countMap.put("text",c.getName());
                            countMap.put("id",c.getCode());
                            countyList.add(countMap);
                        }
                    }
                    cityMap.put("children",countyList);
                }
            }
            map.put("children",cityList);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<WorkInfoVO> getWorkInfo(Integer zpid) {
        List<WorkDTO> workInfoDTOS = employService.getWorkInfo(zpid);
        List<WorkInfoVO> workInfoVOS = generatorUtil.convert(workInfoDTOS,WorkInfoVO.class);
        return workInfoVOS;
    }

    @Override
    public void saveWorkInfo(List<WorkInfoVO> list) {
        List<WorkDTO> workInfoDTOS = generatorUtil.convert(list,WorkDTO.class);
        employService.saveWorkInfo(workInfoDTOS);
    }

    @Override
    public BankCardInfoVO getBankCardInfo(Integer id) {
        BankCardInfoDTO bankCardInfoDTO = employService.getBankCardInfo(id);
        BankCardInfoVO bankCardInfoVO = generatorUtil.convert(bankCardInfoDTO,BankCardInfoVO.class);
        return bankCardInfoVO;
    }

    @Override
    public void saveBankCardInfo(BankCardInfoVO bankCardInfoVO) {
        BankCardInfoDTO bankCardInfoDTO = generatorUtil.convert(bankCardInfoVO,BankCardInfoDTO.class);
        employService.saveBankCardInfo(bankCardInfoDTO);
    }

    @Override
    public Double getWorkYears(Integer employId) {
        EmployDTO recruitmentInfo = employService.getRecruitmentInfo(employId);
        return recruitmentInfo.getWorkedYears();
    }

    @Override
    public List<PublicDicVO> getPersonnelGroupDic(String deptId, Integer year) {
        List<AccountCaliberDTO> accountCaliberDTOList = accountCaliberService.getAccountCaliberByDeptId(deptId,year);
        List<PublicDicVO> publicDicVOS = new ArrayList<>();
        for(AccountCaliberDTO accountCaliberDTO:accountCaliberDTOList){
            PublicDicVO publicDicVO = new PublicDicVO();
            publicDicVO.setId(Integer.valueOf(accountCaliberDTO.getAccountCalibers()));
            publicDicVO.setName(accountCaliberDTO.getAccountCaliberNames());
            publicDicVO.setType(3505);
            publicDicVOS.add(publicDicVO);
        }
        return publicDicVOS;
//        return generatorUtil.convert(accountCaliberDTOList,AccountCaliberVO.class);
    }

    @Override
    public void doBack(Integer employId) {
        employService.doBack(employId);
    }

    @Override
    public void doBatchHeadquartersAudit(List<Integer> recruitmentIds, String personId) {
        employService.doBatchHeadquartersAudit(recruitmentIds,personId);
    }
}

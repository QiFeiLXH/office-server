package com.bsoft.office.organ.manager;

import com.bsoft.office.common.vo.CommunicationSubsidyVO;
import com.bsoft.office.organ.condition.RecruitmentInformationQuery;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.organ.vo.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface EmployManager {

    Map<String, Object> getLastRecruitmentInformation(RecruitmentInformationQuery query);

    Map<String, Object> initRecruitmentBaseInfo(String userId);

    Map<String, Object> initRecruitmentAuditInfo(String userId);

    RecruitmentInformationViewVO saveRecruitmentBaseInfo(RecruitmentInformationViewVO info);

    void deleteFamily(Integer id);

    void deleteWork(Integer id);

    void deleteEducation(Integer id);

    EmployAuditVO getRecruitmentAuditInfo(Integer id);

    EmployAuditVO saveRecruitmentAuditInfo(EmployAuditVO info);

    void deleteRecruitmentInfo(Integer id);

    void sendRecruitmentEmail(RecruitmentBaseInfoVO baseInfo);

    List<AdministrativeAreaVO> getAdministrativeAreaTree();

    List<AdministrativeDivisionVO> getAdministrativeDivisionTree();

    RecruitmentBaseInfoVO getRecruitmentInfo(Integer recruitmentId);

    AdministrativeDivisionVO getOneOldArea(Integer code);

    List<PublicDicVO> getPublicDic(Integer type);

    List<HumanDicVO> getHumanDic(Integer type);

    List<AdministrativeAreaVO> getAdministrativeArea(Integer parentId);

    List<CommunicationSubsidyVO> getSubsidy();

    Map<String, Object> checkRecruitmentStatus(String zpid);

    Map<String, Object> sendHYMessage(String mobileno, String zpid, HttpServletRequest request);

    Map<String, Object> checkHYMessage(String mobile, String smsCode, String zpid, HttpServletRequest request);


    RecruitmentInformationViewVO getEmployeInfo(String mobileno);

    RecruitmentInformationViewVO getEmployeInfoById(Integer id);

    RecruitmentInformationViewVO updateEmployeInfo(RecruitmentInformationVO recruitmentInformationVO);

    Map<String, Object> uploadImage(MultipartFile file, Integer menuId);

    String showImage(Integer id);

    byte[] showImageByte(Integer id);

    List<FamilyPersonVO> getFamilyInfo(Integer zpid);

    void saveFamilyInfo(List<FamilyPersonVO> list);

    List<EducationVO> getEducationInfo(Integer zpid);

    void saveEducaiInfo(List<EducationVO> list);

    void deleteCertificate(Integer id);

    List<Map<String, Object>> getAreas();

    List<WorkInfoVO> getWorkInfo(Integer zpid);

    void saveWorkInfo(List<WorkInfoVO> list);

    BankCardInfoVO getBankCardInfo(Integer id);

    void saveBankCardInfo(BankCardInfoVO bankCardInfoVO);

    Double getWorkYears(Integer employId);

    List<PublicDicVO> getPersonnelGroupDic(String deptId,Integer year);

    void doBack(Integer employId);

    void doBatchHeadquartersAudit(List<Integer> recruitmentIds, String personId);
}

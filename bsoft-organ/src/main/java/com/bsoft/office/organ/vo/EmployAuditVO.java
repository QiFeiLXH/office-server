package com.bsoft.office.organ.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
@Data
public class EmployAuditVO implements Serializable {

    private RecruitmentInformationViewVO recruitmentInfoView;

    private List<FamilyPersonVO> familyList;

    private List<EducationVO> educationList;

    private List<WorkInfoVO> workList;

}

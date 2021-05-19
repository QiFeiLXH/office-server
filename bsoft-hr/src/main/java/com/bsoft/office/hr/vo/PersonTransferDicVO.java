package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.bsoft.office.common.vo.CommunicationSubsidyVO;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.common.vo.PublicDicVO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:14
 * @Description:
 */
public class PersonTransferDicVO {
    @OperLogFieldName(value = "岗位")
    private List<HumanDicVO> postDic;
    @OperLogFieldName(value = "职务")
    private List<HumanDicVO> jobCategoryDic;
    @OperLogFieldName(value = "人员归属群")
    private List<PublicDicVO> personnelGroupDic;
    @OperLogFieldName(value = "通讯补贴")
    private List<CommunicationSubsidyVO> CommunicationSubsidyDic;

    public List<HumanDicVO> getPostDic() {
        return postDic;
    }

    public void setPostDic(List<HumanDicVO> postDic) {
        this.postDic = postDic;
    }

    public List<HumanDicVO> getJobCategoryDic() {
        return jobCategoryDic;
    }

    public void setJobCategoryDic(List<HumanDicVO> jobCategoryDic) {
        this.jobCategoryDic = jobCategoryDic;
    }

    public List<PublicDicVO> getPersonnelGroupDic() {
        return personnelGroupDic;
    }

    public void setPersonnelGroupDic(List<PublicDicVO> personnelGroupDic) {
        this.personnelGroupDic = personnelGroupDic;
    }

    public List<CommunicationSubsidyVO> getCommunicationSubsidyDic() {
        return CommunicationSubsidyDic;
    }

    public void setCommunicationSubsidyDic(List<CommunicationSubsidyVO> communicationSubsidyDic) {
        CommunicationSubsidyDic = communicationSubsidyDic;
    }
}

package com.bsoft.office.project.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/14 14:25
 * @Description 项目责任书与项目范围
 */
public class ProjectDutyAndRegionVO {
    private ProjectDutyVO duty;
    private List<ProjectDutyRegionVO> saveRegions;
    private List<Integer> deleteRegions;
    private List<String> contractNo;// 删除的合同编号

    public ProjectDutyVO getDuty() {
        return duty;
    }

    public void setDuty(ProjectDutyVO duty) {
        this.duty = duty;
    }

    public List<ProjectDutyRegionVO> getSaveRegions() {
        return saveRegions;
    }

    public void setSaveRegions(List<ProjectDutyRegionVO> saveRegions) {
        this.saveRegions = saveRegions;
    }

    public List<Integer> getDeleteRegions() {
        return deleteRegions;
    }

    public void setDeleteRegions(List<Integer> deleteRegions) {
        this.deleteRegions = deleteRegions;
    }

    public List<String> getContractNo() {
        return contractNo;
    }

    public void setContractNo(List<String> contractNo) {
        this.contractNo = contractNo;
    }
}

package com.bsoft.office.project.condition;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/7 9:53
 * @Description
 */
public class ProgressManagerQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 工号 */
    private String personId;
    /** 进度经理 */
    private String progressManager;
    /** 注销标志 */
    private List<Integer> logout;
    /** 维护标志 */
    private List<Integer> maintainFlag;
    /** 全部权限 */
    private Boolean allPermission;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public List<Integer> getLogout() {
        return logout;
    }

    public void setLogout(List<Integer> logout) {
        this.logout = logout;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<Integer> getMaintainFlag() {
        return maintainFlag;
    }

    public void setMaintainFlag(List<Integer> maintainFlag) {
        this.maintainFlag = maintainFlag;
    }

    public Boolean getAllPermission() {
        return allPermission;
    }

    public void setAllPermission(Boolean allPermission) {
        this.allPermission = allPermission;
    }

    public String getProgressManager() {
        return progressManager;
    }

    public void setProgressManager(String progressManager) {
        this.progressManager = progressManager;
    }
}

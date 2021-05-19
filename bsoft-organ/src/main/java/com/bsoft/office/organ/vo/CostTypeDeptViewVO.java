package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 10:04
 * @Description:
 */
public class CostTypeDeptViewVO {
    @OperLogFieldName(value = "部门代码")
    private String bmdm;
    @OperLogFieldName(value = "部门名称")
    private String bmmc;
    @OperLogFieldName(value = "上级部门")
    private String parentBm;
    @OperLogFieldName(value = "上级部门名称")
    private String parentBmmc;
    @OperLogFieldName(value = "是否一级")
    private Integer isParent;
    @OperLogFieldName(value = "部门类别")
    private Integer bmlb;
    @OperLogFieldName(value = "注销")
    private Integer zxbz;
    @OperLogFieldName(value = "部门费用类别维护个数")
    private Double sl;
    @OperLogFieldName(value = "核算口径归属")
    private String accountCalibers;
    private List<CostTypeDeptViewVO> children;

    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getParentBm() {
        return parentBm;
    }

    public void setParentBm(String parentBm) {
        this.parentBm = parentBm;
    }

    public String getParentBmmc() {
        return parentBmmc;
    }

    public void setParentBmmc(String parentBmmc) {
        this.parentBmmc = parentBmmc;
    }

    public String getAccountCalibers() {
        return accountCalibers;
    }

    public void setAccountCalibers(String accountCalibers) {
        this.accountCalibers = accountCalibers;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public Integer getBmlb() {
        return bmlb;
    }

    public void setBmlb(Integer bmlb) {
        this.bmlb = bmlb;
    }

    public Integer getZxbz() {
        return zxbz;
    }

    public void setZxbz(Integer zxbz) {
        this.zxbz = zxbz;
    }

    public Double getSl() {
        return sl;
    }

    public void setSl(Double sl) {
        this.sl = sl;
    }

    public List<CostTypeDeptViewVO> getChildren() {
        return children;
    }

    public void setChildren(List<CostTypeDeptViewVO> children) {
        this.children = children;
    }
}

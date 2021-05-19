package com.bsoft.office.manager.condition;

/**
 * @Author: xucl
 * @DateTime: 2020/7/21 9:13
 * @Description: App已绑定查询
 */
public class UserBoundQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    private String inputContent;
    private Integer logoff;

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

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }
}

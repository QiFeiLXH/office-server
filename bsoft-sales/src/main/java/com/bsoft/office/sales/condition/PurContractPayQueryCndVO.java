package com.bsoft.office.sales.condition;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 15:09
 * @Description: 支付信息查询条件VO
 */
public class PurContractPayQueryCndVO {
    private Integer pageNo;
    private Integer pageSize;
    private Integer htid;

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

    public Integer getHtid() {
        return htid;
    }

    public void setHtid(Integer htid) {
        this.htid = htid;
    }
}

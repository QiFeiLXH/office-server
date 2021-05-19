package com.bsoft.office.system.vo;

import java.io.Serializable;
import java.util.List;

public class MenuSaveVO implements Serializable {
    OfficeMenuVO officeMenuVO;
    List<AuthorityVO> authorityVOList;

    public OfficeMenuVO getOfficeMenuVO() {
        return officeMenuVO;
    }

    public void setOfficeMenuVO(OfficeMenuVO officeMenuVO) {
        this.officeMenuVO = officeMenuVO;
    }

    public List<AuthorityVO> getAuthorityVOList() {
        return authorityVOList;
    }

    public void setAuthorityVOList(List<AuthorityVO> authorityVOList) {
        this.authorityVOList = authorityVOList;
    }
}

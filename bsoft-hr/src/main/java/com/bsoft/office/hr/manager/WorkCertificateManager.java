package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.vo.WorkCertificateNumViewVO;
import com.bsoft.office.hr.vo.WorkCertificateVO;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/4 14:55
 * @Description
 */
public interface WorkCertificateManager {
    Result<WorkCertificateNumViewVO> getCertificateNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize);

    Result<WorkCertificateVO> getPersonalCertificateList(String personId, Integer pageNo, Integer pageSize);
}

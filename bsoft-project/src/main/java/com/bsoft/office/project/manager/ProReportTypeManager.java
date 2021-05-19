package com.bsoft.office.project.manager;

import com.bsoft.office.project.vo.ProReportTypeVO;

import java.util.List;

/**
 * @Author kh Lin
 * @Date 2021/4/19 16:47
 * @Description
 */
public interface ProReportTypeManager {
    List<ProReportTypeVO> getProReportTypes ();

    void saveProReportTypes(ProReportTypeVO proReportTypeVO);

    void logoutProReportType(Integer id);
}

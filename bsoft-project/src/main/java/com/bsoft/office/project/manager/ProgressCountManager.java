package com.bsoft.office.project.manager;

import com.bosft.progress.dto.ProContractProjectProgressDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.project.condition.ProjectProgressCountQueryCnd;
import com.bsoft.office.project.vo.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/4/29 13:54
 * @Description:
 */
public interface ProgressCountManager {

    Result<ProjectProgressCountVO> findProgressCount(ProjectProgressCountQueryCnd cnd);

    List<ProContractProjectProgressVO> getContractProjectProList(String contractNo, Date progressMonth);

    List<ProjectReportTypeViewVO> findReportTypeList(String projectId);

    List<ProjectReportTypeAndHeaderVO> getTypeAndHeader(String projectId,Date progressMonth);

    List<ContractReportTypeVO> getConTypeAndHeader(String contractNo,Date month);

    List<List<ProReportProgressVO>> getMonthProgress(String projectId, Date month, List<Integer> reportTypes, String inputContent);

    List<List<ProReportProgressVO>> getConMonthProgress(String contractNo, Date month, List<Integer> reportTypes, String inputContent);
}

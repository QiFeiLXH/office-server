package com.bsoft.office.project.manager.impl;

import com.bosft.progress.dto.*;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.project.condition.ProjectProgressCountQueryCnd;
import com.bsoft.office.project.manager.ProgressCountManager;
import com.bsoft.office.project.manager.ProgressReportManager;
import com.bsoft.office.project.vo.*;
import com.bsoft.progress.service.ProProjectProgressCountService;
import com.bsoft.progress.service.ProgressReportService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/4/29 13:54
 * @Description:
 */
@Service
public class ProgressCountManagerImpl implements ProgressCountManager {

    @Reference(check = false)
    private ProProjectProgressCountService progressCountService;
    @Reference(check = false)
    private ProgressReportService reportService;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private ProgressReportManager reportManager;

    @Override
    public Result<ProjectProgressCountVO> findProgressCount(ProjectProgressCountQueryCnd cnd) {
        ProjectProgressCountQueryCndDTO cndDTO = generatorUtil.convert(cnd,ProjectProgressCountQueryCndDTO.class);
        Result<ProjectProgressCountDTO> countDTOResult = progressCountService.getProgressCountList(cndDTO);
        return generatorUtil.convert(countDTOResult,ProjectProgressCountVO.class);
    }

    @Override
    public List<ProContractProjectProgressVO> getContractProjectProList(String contractNo, Date progressMonth) {
        List<ProContractProjectProgressDTO> progressDTOS = progressCountService.getContractProjectProList(contractNo, progressMonth);
        return generatorUtil.convert(progressDTOS,ProContractProjectProgressVO.class);
    }

    @Override
    public List<ProjectReportTypeViewVO> findReportTypeList(String projectId) {
        List<ProjectReportTypeViewDTO> typeViewDTOS = reportService.findReportTypeList(projectId);
        return generatorUtil.convert(typeViewDTOS,ProjectReportTypeViewVO.class);
    }

    @Override
    public List<ProjectReportTypeAndHeaderVO> getTypeAndHeader(String projectId,Date progressMonth) {
        List<ProjectReportTypeViewDTO> typeViewDTOS = reportService.findReportTypeList(projectId);
        List<ProjectReportTypeAndHeaderVO> typeAndHeaderVOS = generatorUtil.convert(typeViewDTOS,ProjectReportTypeAndHeaderVO.class);
        for (ProjectReportTypeAndHeaderVO typeAndHeaderVO : typeAndHeaderVOS){
            List<ProProgressNodeVO> proProgressNodeVOS = reportManager.getColumnsHeader(projectId,typeAndHeaderVO.getReportType(),progressMonth);
            typeAndHeaderVO.setHeaders(proProgressNodeVOS);
        }
        return typeAndHeaderVOS;
    }

    @Override
    public List<ContractReportTypeVO> getConTypeAndHeader(String contractNo,Date month) {
        List<ContractReportTypeViewDTO> contractReportTypeViewDTOS = progressCountService.getContractReportType(contractNo);
        List<ContractReportTypeVO> contractReportTypeVOS = generatorUtil.convert(contractReportTypeViewDTOS,ContractReportTypeVO.class);
        for (ContractReportTypeVO contractReportTypeVO:contractReportTypeVOS){
            List<ProProgressNodeDTO> proProgressNodeDTOS = progressCountService.getConColumnHeader(contractNo,contractReportTypeVO.getReportType(),month);
            List<ProProgressNodeVO> proProgressNodeVOS = generatorUtil.convert(proProgressNodeDTOS,ProProgressNodeVO.class);
            contractReportTypeVO.setHeaders(proProgressNodeVOS);
        }
        return contractReportTypeVOS;
    }

    @Override
    public List<List<ProReportProgressVO>> getMonthProgress(String projectId, Date month, List<Integer> reportTypes,String inputContent) {
        List<List<ProReportProgressVO>> list = new ArrayList();
        for (Integer reportType : reportTypes){
            List<ProReportProgressDTO> proReportProgressDTOS = reportService.getMonthProgress(projectId, month, reportType,inputContent);
            List<ProReportProgressVO> progressVOS = generatorUtil.convert(proReportProgressDTOS,ProReportProgressVO.class);
            list.add(progressVOS);
        }
        return list;
    }

    @Override
    public List<List<ProReportProgressVO>> getConMonthProgress(String contractNo, Date month, List<Integer> reportTypes, String inputContent) {
        List<List<ProReportProgressVO>> list = new ArrayList();
        for (Integer reportType : reportTypes){
            List<ProReportProgressDTO> proReportProgressDTOS = progressCountService.getConMonthProgress(contractNo, month, reportType,inputContent);
            List<ProReportProgressVO> progressVOS = generatorUtil.convert(proReportProgressDTOS,ProReportProgressVO.class);
            list.add(progressVOS);
        }
        return list;
    }
}

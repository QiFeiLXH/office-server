package com.bsoft.office.project.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.project.condition.ProjectWordCountViewQueryCnd;
import com.bsoft.office.project.manager.ProjectWordManager;
import com.bsoft.office.project.vo.ProjectWordCountViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zy
 * @date: 2021/4/27
 * @description 项目文档统计
 */
@RestController
@RequestMapping("/progressfile")
public class ProgressWordCountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgressWordCountController.class);
    @Autowired
    private ProjectWordManager projectWordManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "项目文档统计")
    public OfficeResopnseBean getProjectWordCountViewList(ProjectWordCountViewQueryCnd cnd) {
        Result<ProjectWordCountViewVO> result = projectWordManager.getProjectWordCountViewList(cnd);
        return OfficeResopnseBean.newSuccessBean(result);
    }
}

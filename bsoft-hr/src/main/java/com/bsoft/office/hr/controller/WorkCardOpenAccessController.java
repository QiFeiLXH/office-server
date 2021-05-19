package com.bsoft.office.hr.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.hr.condition.WorkCardQueryCnd;
import com.bsoft.office.hr.manager.WorkCardManager;
import com.bsoft.office.hr.vo.WorkCardViewVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/16 9:46
 * @Description 工牌核实、领取
 */
@RestController
@RequestMapping("/workcardopenaccess")
public class WorkCardOpenAccessController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkCardOpenAccessController.class);

    @Autowired
    private WorkCardManager workCardManager;

    @GetMapping("/personquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌人员数据")
    public OfficeResopnseBean getWorkCardOpenAccessList(WorkCardQueryCnd cnd){
        Result<WorkCardViewVO> result = workCardManager.getWorkCardOpenAccessList(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(result);
        LOGGER.info("获取工牌人员数据", JSONUtils.toString(result));
        return bean;
    }

    @GetMapping("/openaccesscount")
    @OperLog(operType = OperLogType.QUERY,operDesc = "工牌门禁待开通数量")
    public OfficeResopnseBean getWorkCardOpenAccessCount(WorkCardQueryCnd cnd){
        Integer count = workCardManager.getWorkCardOpenAccessCount(cnd);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(count);
        LOGGER.info("获取工牌门禁待开通数量", JSONUtils.toString(count));
        return bean;
    }

    @PostMapping("/openaccess")
    @OperLog(operType = OperLogType.OTHER,operDesc = "开通工牌权限")
    public OfficeResopnseBean openAccessWorkCard(@RequestBody WorkCardViewVO workCardViewVO){
        workCardManager.openAccessWorkCard(workCardViewVO);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody("开通工牌权限成功");
        LOGGER.info("开通工牌权限");
        return bean;
    }
}

package com.bsoft.office.work.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.work.condition.BusinessCardQueryCnd;
import com.bsoft.office.work.manager.ManagerGroupManager;
import com.bsoft.office.work.vo.BusinessCardViewVO;
import com.bsoft.office.work.vo.ManagerGroupVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ding cj
 * @Date 2021/5/12 13:22
 * @Description
 */
@RestController
@RequestMapping("/managergroup")
public class ManagerGroupController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BusinessCardController.class);

    @Autowired
    private ManagerGroupManager managerGroupManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "委员会组列表")
    public OfficeResopnseBean getManagerGroupList(String councilName, Integer isCancel) {
        //LOGGER.info("进入控制器了");
        List<ManagerGroupVO> list = managerGroupManager.findList(councilName, isCancel);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @PutMapping("/cancel")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "注销委员会组")
    public OfficeResopnseBean cancelManagerGroup(Integer councilId, Integer isCancel) {
        if(councilId == null || isCancel == null){
            LOGGER.error("传入参数错误!");
        }
        managerGroupManager.cancelManagerGroup(councilId,isCancel);
        return OfficeResopnseBean.newSuccessBean();
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存委员会组")
    public OfficeResopnseBean cancelManagerGroup(@RequestBody List<ManagerGroupVO> managerGroupVOList) {
        managerGroupManager.saveManagerGroups(managerGroupVOList);
        return OfficeResopnseBean.newSuccessBean();
    }
}

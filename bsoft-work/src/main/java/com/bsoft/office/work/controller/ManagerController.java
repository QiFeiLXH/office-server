package com.bsoft.office.work.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.work.manager.ManagerManager;
import com.bsoft.office.work.vo.ManagerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author ding cj
 * @Date 2021/5/14 10:07
 * @Description
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BusinessCardController.class);

    @Autowired
    private ManagerManager managerManager;

    @GetMapping("/list")
    @OperLog(operType = OperLogType.QUERY,operDesc = "委员会成员列表")
    public OfficeResopnseBean getManagerGroupList(String personName, Integer councilId) {
        if(councilId == null){
            return OfficeResopnseBean.newSuccessBean();
        }
        List<ManagerVO> list = managerManager.findList(personName, councilId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @DeleteMapping("/delete")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "删除委员会成员")
    public OfficeResopnseBean cancelManagerGroup(Integer id) {
        if(id == null){
            LOGGER.error("传入参数错误!");
        }
        managerManager.deleteManager(id);
        return OfficeResopnseBean.newSuccessBean();
    }

    @PostMapping("/save")
    @OperLog(operType = OperLogType.MODIFY,operDesc = "保存委员会成员")
    public OfficeResopnseBean cancelManagerGroup(@RequestBody List<ManagerVO> managerVOList) {
        managerManager.saveManager(managerVOList);
        return OfficeResopnseBean.newSuccessBean();
    }
}

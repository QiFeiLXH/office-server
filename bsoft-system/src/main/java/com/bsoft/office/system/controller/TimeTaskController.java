package com.bsoft.office.system.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.system.manager.TimeTaskGroupManager;
import com.bsoft.office.system.manager.TimeTaskManager;
import com.bsoft.office.system.vo.TimeTaskGroupTreeVO;
import com.bsoft.office.system.vo.TimeTaskQueryCndVO;
import com.bsoft.office.system.vo.TimeTaskVO;
import com.bsoft.system.dto.TimeTaskDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-06-29 17:13
 * @Version 1.0
 * @Description
 *
 */
@RestController
@RequestMapping(value = "/timetask")
public class TimeTaskController {
    private static final Logger logger = LoggerFactory.getLogger(TimeTaskController.class);

    @Autowired
    private TimeTaskManager timeTaskManager;
    @Autowired
    private TimeTaskGroupManager timeTaskGroupManager;
    @Autowired
    private GeneratorUtil generatorUtil;

    /**
     * 获取定时任务列表
     * @return
     */
    @RequestMapping(value = "/tasklist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询定时任务列表")
    public OfficeResopnseBean getTaskList(@RequestBody TimeTaskQueryCndVO queryCndVO){
        logger.info("获取定时任务列表！");
        Result<TimeTaskDTO> taskList = timeTaskManager.getTaskList(queryCndVO);
        Result<TimeTaskVO> taskVOResult = generatorUtil.convert(taskList, TimeTaskVO.class);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(taskVOResult);
        return bean;
    }

    /**
     * 获取定时任务列表
     * @return
     */
    @RequestMapping(value = "/gettimetask",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询定时任务")
    public OfficeResopnseBean getTimeTaskInfoById(@RequestParam Integer id){
        logger.info("获取定时任务！");
        TimeTaskVO timeTaskVO = timeTaskManager.getById(id);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(timeTaskVO);
        return bean;
    }


    /**
     * 保存修改定时任务
     * @return
     */
    @RequestMapping(value = "/savetask",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存定时任务")
    public OfficeResopnseBean saveTask(@RequestBody TimeTaskVO taskData, HttpServletRequest request){
        logger.info("保存修改定时任务！");
        String userId = ContextUtils.getUserId(request);
        if(taskData.getId() == null){
            taskData.setCreater(userId);
        }
        taskData.setUpdater(userId);
        timeTaskManager.saveTask(taskData);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        return bean;
    }

    /**
     * 删除定时任务
     * @return
     */
    @RequestMapping(value = "/removetask",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除定时任务")
    public OfficeResopnseBean removeTask(@RequestBody TimeTaskVO taskData){
        logger.info("删除定时任务！");
        timeTaskManager.remove(taskData);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        return bean;
    }

    /**
     * 启用/禁用定时任务
     * @return
     */
    @RequestMapping(value = "/changestatus",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "启用/禁用定时任务")
    public OfficeResopnseBean changeStatus(@RequestParam Integer jobId,@RequestParam String status){
        logger.info("启用/禁用定时任务！");
        timeTaskManager.changeStatus(jobId,status);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        return bean;
    }

    /**
     * 删除定时任务分组
     * @return
     */
    @RequestMapping(value = "/removetaskgroup",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除定时任务分组")
    public OfficeResopnseBean removeTimeTaskGroup(@RequestParam Integer id){
        logger.info("删除定时任务分组！");
        timeTaskGroupManager.delete(id);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        return bean;
    }

    /**
     * 保存修改定时任务分组
     * @return
     */
    @RequestMapping(value = "/savetaskgroup",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存定时任务分组")
    public OfficeResopnseBean saveTaskGroup(@RequestBody TimeTaskGroupTreeVO taskGroup){
        logger.info("保存修改定时任务分组！");
        taskGroup = timeTaskGroupManager.save(taskGroup);
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(taskGroup);
        return bean;
    }


    /**
     * 获取任务分组树
     * @return
     */
    @RequestMapping(value = "/gettaskgrouptree",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询任务分组树")
    public OfficeResopnseBean getTaskGroupTree(){
        logger.info("获取任务分组树！");
        List<TimeTaskGroupTreeVO> list = timeTaskGroupManager.getGroupTree();
        OfficeResopnseBean bean = OfficeResopnseBean.newSuccessBean();
        bean.setBody(list);
        return bean;
    }

}

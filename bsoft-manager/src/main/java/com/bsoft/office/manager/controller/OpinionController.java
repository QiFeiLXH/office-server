package com.bsoft.office.manager.controller;

import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.exportExcel.CustomCellWriteHandler;
import com.bsoft.office.common.exportExcel.ExportExcel;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.manager.condition.OpinionQueryCnd;
import com.bsoft.office.manager.manager.OpinionManager;
import com.bsoft.office.manager.vo.OpinionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/8/5 15:23
 * @Description: App的意见Controller
 */
@RestController
@RequestMapping(value = "/opinion")
public class OpinionController {
    private static final Logger logger = LoggerFactory.getLogger(OpinionController.class);

    @Autowired
    private OpinionManager opinionManager;

    /**
     * 获取意见列表
     * @param cnd
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询意见列表")
    public OfficeResopnseBean getOpinions(@RequestBody OpinionQueryCnd cnd){
        return OfficeResopnseBean.newSuccessBean(opinionManager.getOpinions(cnd));
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查看意见详情")
    public OfficeResopnseBean getOpinionsById(@RequestParam("id") Integer id){
        return OfficeResopnseBean.newSuccessBean(opinionManager.getOpinionsById(id));
    }

    @RequestMapping(value = "/audit",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "受理意见")
    public OfficeResopnseBean auditOpinions(@RequestBody OpinionVO opinionVO, HttpServletRequest request){
        String userId = ContextUtils.getUserId(request);
        opinionVO.setFeedbacker(userId);
        opinionManager.auditOpinion(opinionVO);
        return OfficeResopnseBean.newSuccessBean();
    }

    /**
     *功能描述: 反馈意见导出
     */
    @PostMapping("/exportdownload")
    @RequiredExportLog
    @OperLog(operType = OperLogType.EXPORT,operDesc = "导出意见列表")
    public void exportOpinion(@RequestBody OpinionQueryCnd cnd,ExportLogParams params,
                                    HttpServletResponse response){
        List<OpinionVO> list = opinionManager.findAllOpinion(cnd);
        ExportExcel.export(list, OpinionVO.class,"意见反馈列表",response);
        logger.info("意见反馈-导出意见反馈成功！");
    }

}

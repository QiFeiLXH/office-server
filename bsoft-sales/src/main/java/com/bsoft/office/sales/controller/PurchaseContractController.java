package com.bsoft.office.sales.controller;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.manager.ProjectManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.utils.ContextUtils;
import com.bsoft.office.common.vo.ProjectLookVO;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.sales.condition.PurContractPayQueryCndVO;
import com.bsoft.office.sales.condition.PurchaseContractQueryCndVO;
import com.bsoft.office.sales.manager.PurchaseContractManager;
import com.bsoft.office.sales.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 12:04
 * @Description: 采购合同Controller
 */
@RestController
@RequestMapping(value = "/purchase")
public class PurchaseContractController {

    @Autowired
    private PurchaseContractManager purchaseContractManager;
    @Autowired
    private ProjectManager projectManager;

    /**
     * 获取采购合同列表
     * @param cndVO
     * @param request
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询采购合同列表")
    public OfficeResopnseBean getPurchaseContract(@RequestBody PurchaseContractQueryCndVO cndVO, HttpServletRequest request){
        String personId = ContextUtils.getUserId(request);
        cndVO.setSigner(personId);
        Result<PurchaseContractViewVO> result = purchaseContractManager.getPurchaseContract(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 获取支付信息列表
     * @param cndVO
     * @return
     */
    @RequestMapping(value = "/paylist",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询支付信息列表")
    public OfficeResopnseBean getPurContractPay(@RequestBody PurContractPayQueryCndVO cndVO){
        Result<PurContractPayViewVO> result = purchaseContractManager.getPurContractPay(cndVO);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 获取支付信息详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getpay",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查看支付信息详情")
    public OfficeResopnseBean getPurContractPay(Integer id){
        PurContractPayViewVO payViewVO = purchaseContractManager.getPurContractPay(id);
        return OfficeResopnseBean.newSuccessBean(payViewVO);
    }

    /**
     * 保存、更新支付信息
     * @param payViewVO
     * @return
     */
    @RequestMapping(value = "/savepay",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改支付信息")
    public OfficeResopnseBean savePurContractPay(@RequestBody PurContractPayViewVO payViewVO){
        Integer key = purchaseContractManager.savePurContractPay(payViewVO);
        return OfficeResopnseBean.newSuccessBean(key);
    }

    /**
     * 获取核算口径归属字典
     * @return
     */
    @RequestMapping(value = "/persongroupdic",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据部门、年份查询核算口径归属")
    public OfficeResopnseBean getPersonnelGroupDic(@RequestParam(required = true) String deptId,@RequestParam(required = true) Integer year){
        List<PublicDicVO> list = purchaseContractManager.getPersonnelGroupDic(deptId,year);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    /**
     * 生成支付申请
     * @param payViewVO
     * @return
     */
    @RequestMapping(value = "/savepayapplication",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.MODIFY,operDesc = "生成支付申请信息")
    public OfficeResopnseBean savePaymentApplication(@RequestBody PurContractPayViewVO payViewVO){
        Integer key = purchaseContractManager.savePaymentApplication(payViewVO);
        return OfficeResopnseBean.newSuccessBean(key);
    }

    /**
     * 项目选择
     */
    @RequestMapping(value = "/projects",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询项目列表")
    public OfficeResopnseBean getProjectList(@RequestParam Integer pageNo,
                                             @RequestParam Integer pageSize,
                                             @RequestParam String contractNo,
                                             @RequestParam(required = false) String inputContent){
        Result<ProjectLookVO> result = projectManager.getProjectLookList(pageNo, pageSize, contractNo,inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 客户往来单位列表
     */
    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "客户往来单位列表")
    public OfficeResopnseBean getCustomerContactsList(@RequestParam Integer pageNo,
                                                      @RequestParam Integer pageSize,
                                                      @RequestParam(required = false) String inputContent){
        Result<CustomerContactsVO> result = purchaseContractManager.getCustomerContactsList(pageNo, pageSize, inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /**
     * 客户往来单位，携带收款单位信息
     * @param pageNo
     * @param pageSize
     * @param inputContent
     * @return
     */
    @RequestMapping(value = "/customercontact",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查询客户往来单位列表，有收款单位")
    public OfficeResopnseBean getCustomerContacts(@RequestParam Integer pageNo,
                                                      @RequestParam Integer pageSize,
                                                      @RequestParam(required = false) String inputContent){
        Result<CustomerContactViewVO> result = purchaseContractManager.getCustomerContacts(pageNo, pageSize, inputContent);
        return OfficeResopnseBean.newSuccessBean(result);
    }

    /** 上传文件类型字典查询 */
    @GetMapping(value = "/dic")
    @OperLog(operType = OperLogType.QUERY,operDesc = "传文件类型字典")
    public OfficeResopnseBean getDicList() {
        Map<String, Object> dics = purchaseContractManager.getDicList();
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(dics);
        return responseBean;
    }

    /** 上传资料查找 */
    @GetMapping(value = "/files")
    @OperLog(operType = OperLogType.QUERY,operDesc = "上传资料")
    public OfficeResopnseBean getPublicWordsList(@RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize,
                                                 @RequestParam Integer menuId,
                                                 @RequestParam Integer mainId,
                                                 @RequestParam Integer type) {
        Result<PublicWordsViewVO> result = purchaseContractManager.getPublicWordsList(pageNo, pageSize, mainId, menuId, type);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody(result);
        return responseBean;
    }

    /** 上传文件 */
    @PostMapping(value = "/fileupload")
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "文件上传")
    public OfficeResopnseBean uploadFile(@RequestParam MultipartFile file, @RequestParam Integer contractId, @RequestParam Integer menuId, HttpServletRequest request) {
        String personId = ContextUtils.getUserId(request);
        try {
            purchaseContractManager.uploadFile(file, contractId, menuId, personId);
            OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
            responseBean.setBody("上传成功！");
            return responseBean;
        } catch (IOException e) {
            e.printStackTrace();
            OfficeResopnseBean responseBean = OfficeResopnseBean.newFailBean(500,"获取上传文件格式失败！");
            return responseBean;
        }
    }
    @GetMapping(value = "/filedownload")
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "文件下载")
    public void downloadFile(Integer fileId, Integer wordId, HttpServletRequest request, HttpServletResponse response){
        String personId = ContextUtils.getUserId(request);
        PublicWordsVO wordsVO = purchaseContractManager.downloadFile(fileId, wordId,personId);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(wordsVO.getFileBytes().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(wordsVO.getFileName(), "UTF-8"));
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(wordsVO.getFileBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @DeleteMapping(value = "/filedelete")
    @OperLog(operType = OperLogType.DELETE,operDesc = "上传文件删除")
    public OfficeResopnseBean deleteFile(Integer fileId, Integer wordId){
        purchaseContractManager.deleteFile(fileId, wordId);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("上传文件删除成功！");
        return responseBean;
    }

    /** 保存采购合同 */
    @PostMapping(value = "/contractsave")
    @OperLog(operType = OperLogType.SAVE,operDesc = "保存采购合同")
    public OfficeResopnseBean savePurchaseContract(@RequestBody PurchaseContractSaveVO contractSaveVO) {
        PurchaseContractViewVO purchaseContract = contractSaveVO.getPurchaseContract();
        List<Integer> deletes = contractSaveVO.getDeletes();
        List<PurchaseContractPaymentVO> saves = contractSaveVO.getSaves();
        String contractNo = contractSaveVO.getContractNo();

        if (deletes == null) {
            deletes = new ArrayList<>();
        }
        if (saves == null) {
            saves = new ArrayList<>();
        }
        purchaseContractManager.savePurchaseContract(purchaseContract,saves, deletes,contractNo);
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        responseBean.setBody("保存采购合同成功");
        return responseBean;
    }

    /**
     * 付款条件列表
     */
    @GetMapping(value = "/paymentquery")
    @OperLog(operType = OperLogType.QUERY,operDesc = "付款条件列表")
    public OfficeResopnseBean getPurchaseContractPaymentList(Integer contractId){
        List<PurchaseContractPaymentVO> list = purchaseContractManager.getPurchaseContractPaymentList(contractId);
        return OfficeResopnseBean.newSuccessBean(list);
    }

}

package com.bsoft.office.sales.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.PublicWordsDTO;
import com.bsoft.common.dto.PublicWordsViewDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.common.service.PublicWordsService;
import com.bsoft.common.service.SystemDicService;
import com.bsoft.cost.dto.AccountCaliberDTO;
import com.bsoft.cost.service.AccountCaliberService;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.SystemDicVO;
import com.bsoft.office.sales.condition.PurContractPayQueryCndVO;
import com.bsoft.office.sales.condition.PurchaseContractQueryCndVO;
import com.bsoft.office.sales.manager.PurchaseContractManager;
import com.bsoft.office.sales.vo.*;
import com.bsoft.sales.dto.*;
import com.bsoft.sales.service.CustomerContactsService;
import com.bsoft.sales.service.PurchaseContractService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 12:06
 * @Description: 采购合同Manager实现类
 */
@Service
public class PurchaseContractManagerImpl implements PurchaseContractManager {
    @Autowired
    private IGenerator iGenerator;
    @Reference(timeout = 60000)
    private PurchaseContractService purchaseContractService;
    @Reference
    private PublicDicService publicDicService;
    @Reference
    private CustomerContactsService customerContactsService;
    @Reference(timeout = 60000)
    private PublicWordsService publicWordsService;
    @Reference(timeout = 60000)
    private AccountCaliberService accountCaliberService;
    @Reference
    private SystemDicService systemDicService;

    @Override
    public Result<PurchaseContractViewVO> getPurchaseContract(PurchaseContractQueryCndVO cndVO) {
        PurchaseContractQueryCndDTO cndDTO = iGenerator.convert(cndVO,PurchaseContractQueryCndDTO.class);
        Result<PurchaseContractViewDTO> result = purchaseContractService.getPurchaseContract(cndDTO);
        return iGenerator.convert(result,PurchaseContractViewVO.class);
    }

    @Override
    public Result<PurContractPayViewVO> getPurContractPay(PurContractPayQueryCndVO cndVO) {
        PurContractPayQueryCndDTO cndDTO = iGenerator.convert(cndVO,PurContractPayQueryCndDTO.class);
        Result<PurContractPayViewDTO> result = purchaseContractService.getPurContractPay(cndDTO);
        return iGenerator.convert(result,PurContractPayViewVO.class);
    }

    @Override
    public PurContractPayViewVO getPurContractPay(Integer id) {
        PurContractPayViewDTO payViewDTO = purchaseContractService.getPurContractPay(id);
        return iGenerator.convert(payViewDTO,PurContractPayViewVO.class);
    }

    @Override
    public Integer savePurContractPay(PurContractPayViewVO payViewVO) {
        PurContractPayViewDTO payViewDTO = iGenerator.convert(payViewVO,PurContractPayViewDTO.class);
        if (payViewDTO.getRegistrantDate() == null){
            payViewDTO.setRegistrantDate(new Date());
        }
        Integer key = purchaseContractService.savePurContractPay(payViewDTO);
        return key;
    }

    @Override
    public List<PublicDicVO> getPersonnelGroupDic(String deptId,Integer year) {
        List<AccountCaliberDTO> accountCaliberDTOList = accountCaliberService.getAccountCaliberByDeptId(deptId,year);
        List<PublicDicVO> publicDicVOS = new ArrayList<>();
        for(AccountCaliberDTO accountCaliberDTO:accountCaliberDTOList){
            PublicDicVO publicDicVO = new PublicDicVO();
            publicDicVO.setId(Integer.valueOf(accountCaliberDTO.getAccountCalibers()));
            publicDicVO.setName(accountCaliberDTO.getAccountCaliberNames());
            publicDicVO.setType(3505);
            publicDicVOS.add(publicDicVO);
        }
        return publicDicVOS;
    }

    @Override
    public Integer savePaymentApplication(PurContractPayViewVO payViewVO) {
        PurContractPayViewDTO payViewDTO = iGenerator.convert(payViewVO,PurContractPayViewDTO.class);
        return purchaseContractService.savePaymentApplication(payViewDTO);
    }

    @Override
    public Result<CustomerContactsVO> getCustomerContactsList(Integer pageNo, Integer pageSize, String inputContent) {
        Result<CustomerContactsDTO> result = customerContactsService.getCustomerContactsList(pageNo, pageSize, inputContent);
        return iGenerator.convert(result, CustomerContactsVO.class);
    }

    @Override
    public Result<CustomerContactViewVO> getCustomerContacts(Integer pageNo, Integer pageSize, String inputContent) {
        Result<CustomerContactViewDTO> result = customerContactsService.getCustomerContacts(pageNo, pageSize, inputContent);
        return iGenerator.convert(result, CustomerContactViewVO.class);
    }

    @Override
    public Map<String, Object> getDicList() {
        List<PublicDicVO> fileTypes = iGenerator.convert(publicDicService.getPublicDic(2002), PublicDicVO.class); // 文件类型
        List<SystemDicVO> paymentItems = iGenerator.convert(systemDicService.getSystemDic(919), SystemDicVO.class); // 付款科目
        Map<String, Object> dics = new HashMap<>();
        dics.put("fileTypes",fileTypes);
        dics.put("paymentItems",paymentItems);
        return dics;
    }

    @Override
    public Result<PublicWordsViewVO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type) {
        Result<PublicWordsViewDTO> result = publicWordsService.getPublicWordsList(pageNo, pageSize, mainId, menuId, type);
        return iGenerator.convert(result, PublicWordsViewVO.class);
    }

    @Override
    public void uploadFile(MultipartFile file, Integer contractId, Integer menuId, String personId) throws IOException {
        PublicWordsVO publicWordsVO = new PublicWordsVO();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        //判断是否为IE浏览器的文件名，IE浏览器下文件名会带有盘符信息
        // Check for Unix-style path
        int unixSep = fileName.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = fileName.lastIndexOf('\\');
        int pos = Math.max(winSep, unixSep);
        if (pos != -1)  {
            fileName = fileName.substring(pos + 1);
        }
        // 控制上传文件的类型
        List<PublicDicDTO> fileUploadTypes = publicDicService.getPublicDic(2002);
        String format = fileName.substring(fileName.lastIndexOf(".") + 1);
        boolean check = false;
        for (PublicDicDTO uploadType : fileUploadTypes) {
            if(format.equals(uploadType.getName())){
                check = true;
                break;
            }
        }
        if (check) {
            BigDecimal fileSize = new BigDecimal(file.getSize()).divide(new BigDecimal(1024 * 1024), 2, RoundingMode.HALF_UP); // 单位兆
            publicWordsVO.setFileName(fileName);
            publicWordsVO.setFileSize(fileSize.doubleValue());
            publicWordsVO.setMenuId(menuId);
            publicWordsVO.setMainId(contractId);
            publicWordsVO.setUploader(personId);
            publicWordsVO.setType(1);
            publicWordsVO.setFileBytes(file.getBytes());
            PublicWordsDTO word= iGenerator.convert(publicWordsVO, PublicWordsDTO.class);
            publicWordsService.savePublicWords(word);
        } else {
            throw new ServiceException("上传格式不正确");
        }
    }

    @Override
    public PublicWordsVO downloadFile(Integer fileId, Integer wordId, String personId) {
        PublicWordsDTO word = publicWordsService.getWaterMarkPublicWords(fileId, wordId,personId);
        return iGenerator.convert(word, PublicWordsVO.class);
    }

    @Override
    public void deleteFile(Integer fileId, Integer wordId) {
        publicWordsService.deleteFile(fileId, wordId);
    }

    @Override
    public void savePurchaseContract(PurchaseContractViewVO purchaseContract, List<PurchaseContractPaymentVO> saves, List<Integer> deletes, String contractNo) {
        if (!saves.isEmpty()) {
            saves.forEach(item -> {
                if (item.getId() < 0) {
                    item.setId(null);
                }
            });
        }
        PurchaseContractViewDTO contractDTO = iGenerator.convert(purchaseContract, PurchaseContractViewDTO.class);
        List<PurchaseContractPaymentDTO> paymentDTOS = iGenerator.convert(saves, PurchaseContractPaymentDTO.class);
        purchaseContractService.savePurchaseContract(contractDTO,paymentDTOS,deletes,contractNo);
    }

    @Override
    public List<PurchaseContractPaymentVO> getPurchaseContractPaymentList(Integer contractId) {
        List<PurchaseContractPaymentDTO> paymentDTOList = purchaseContractService.getPurchaseContractPaymentList(contractId);
        return iGenerator.convert(paymentDTOList, PurchaseContractPaymentVO.class);
    }

}

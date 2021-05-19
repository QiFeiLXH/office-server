package com.bsoft.office.sales.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.PublicWordsDTO;
import com.bsoft.common.dto.PublicWordsViewDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.common.service.PublicWordsService;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.sales.condition.SalesAgreementQueryCndVO;
import com.bsoft.office.sales.manager.CooperationAgreementManager;
import com.bsoft.office.sales.vo.*;
import com.bsoft.sales.dto.*;
import com.bsoft.sales.service.CoopertaionAgreementService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 13:21
 * @Description
 */
@Service
public class CooperationAgreementManagerImpl implements CooperationAgreementManager {
    @Reference(timeout = 10000)
    private CoopertaionAgreementService coopertaionAgreementService;
    @Reference
    private PublicDicService publicDicService;
    @Reference(timeout = 60000)
    private PublicWordsService publicWordsService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<SalesPartnerViewVO> getSalesPartnerList(String inputContent,Integer pageNo, Integer pageSize) {
        Result<SalesPartnerViewDTO> result = coopertaionAgreementService.getSalesPartnerList(inputContent,pageNo, pageSize);
        return iGenerator.convert(result, SalesPartnerViewVO.class);
    }

    @Override
    public Integer saveSalesPartner(SalesPartnerVO salesPartner,String provinceText, String cityText, String countyText) {
        SalesPartnerDTO salesPartnerDTO = iGenerator.convert(salesPartner, SalesPartnerDTO.class);
        Integer partnerId = coopertaionAgreementService.saveSalesPartner(salesPartnerDTO, provinceText, cityText, countyText);
        return partnerId;
    }

    @Override
    public void deleteSalesPartner(Integer id) {
        coopertaionAgreementService.deleteSalesPartner(id);
    }

    @Override
    public Result<SalesAgreementViewVO> getSalesAgreementList(SalesAgreementQueryCndVO cnds) {
        SalesAgreementQueryCndDTO cndDTO = iGenerator.convert(cnds, SalesAgreementQueryCndDTO.class);
        Result<SalesAgreementViewDTO> result = coopertaionAgreementService.getSalesAgreementList(cndDTO);
        return iGenerator.convert(result, SalesAgreementViewVO.class);
    }

    @Override
    public void deleteSalesAgreement(Integer id) {
        coopertaionAgreementService.deleteSalesAgreement(id);
    }

    @Override
    public Map<String, Object> getDicList() {
        List<PublicDicVO> originalStatusDic = iGenerator.convert(publicDicService.getPublicDic(1504), PublicDicVO.class); // 原件状态
        List<PublicDicVO> cooperateTypeDic = iGenerator.convert(publicDicService.getPublicDic(1505), PublicDicVO.class); // 合作类别
        List<PublicDicVO> ownerShipDic = iGenerator.convert(publicDicService.getPublicDic(1501), PublicDicVO.class); // 业务归属
        List<PublicDicVO> fileTypesDic = iGenerator.convert(coopertaionAgreementService.getFileUploadType(), PublicDicVO.class); // 文件类型
        Map<String, Object> dicMap = new HashMap<>();
        dicMap.put("originalStatusDic", originalStatusDic);
        dicMap.put("cooperateTypeDic", cooperateTypeDic);
        dicMap.put("ownerShipDic", ownerShipDic);
        dicMap.put("fileTypesDic", fileTypesDic);
        return dicMap;
    }

    @Override
    public List<SalesPartnerViewVO> getPartnerSelectList(String partnerName) {
        List<SalesPartnerViewDTO> list = coopertaionAgreementService.getSalesPartnerList(partnerName);
        return iGenerator.convert(list, SalesPartnerViewVO.class);
    }

    @Override
    public Result<PublicWordsViewVO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer menuId, Integer type) {
        Result<PublicWordsViewDTO> result = publicWordsService.getPublicWordsList(pageNo, pageSize, mainId, menuId, type);
        return iGenerator.convert(result, PublicWordsViewVO.class);
    }

    @Override
    public SalesAgreementVO saveAgreement(SalesAgreementVO salesAgreementVO,String personId ) {
        SalesAgreementDTO salesAgreementDTO = iGenerator.convert(salesAgreementVO, SalesAgreementDTO.class);
        SalesAgreementDTO salesAgreement = coopertaionAgreementService.saveSalesAgreement(salesAgreementDTO, personId);
        SalesAgreementVO resultVO = iGenerator.convert(salesAgreement, SalesAgreementVO.class);
        return resultVO;
    }

    @Override
    public void uploadFile(MultipartFile file, Integer agreementId, Integer menuId, String personId)  throws IOException {
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
        List<PublicDicDTO> fileUploadTypes = coopertaionAgreementService.getFileUploadType();
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
            publicWordsVO.setMainId(agreementId);
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

}

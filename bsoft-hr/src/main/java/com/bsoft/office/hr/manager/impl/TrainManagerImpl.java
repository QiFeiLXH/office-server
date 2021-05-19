package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.hr.condition.PersonalTrainQueryCnd;
import com.bsoft.office.hr.condition.TrainKnowledgeQueryCnd;
import com.bsoft.office.hr.manager.TrainManager;
import com.bsoft.office.hr.vo.PersonalTrainVO;
import com.bsoft.office.hr.vo.TrainKnowledgeLearnViewVO;
import com.bsoft.office.hr.vo.TrainKnowledgeShareViewVO;
import com.bsoft.person.dto.*;
import com.bsoft.person.service.TrainService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 14:24
 * @Description
 */
@Service
public class TrainManagerImpl implements TrainManager {
    @Reference(timeout = 60000)
    private TrainService trainService;
    @Reference
    private ServerDateService serverDateService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<TrainKnowledgeLearnViewVO> getKnowledgeLearnList(TrainKnowledgeQueryCnd trainKnowledgeQueryCnd) {
        TrainQueryCndDTO cnd = iGenerator.convert(trainKnowledgeQueryCnd, TrainQueryCndDTO.class);
        Result<TrainLearnDTO> result =  trainService.getKnowledgeLearnList(cnd);
        return iGenerator.convert(result, TrainKnowledgeLearnViewVO.class);
    }

    @Override
    public Result<TrainKnowledgeShareViewVO> getKnowledgeShareList(TrainKnowledgeQueryCnd trainKnowledgeQueryCnd) {
        TrainQueryCndDTO cnd = iGenerator.convert(trainKnowledgeQueryCnd, TrainQueryCndDTO.class);
        Result<TrainShareDTO> result =  trainService.getKnowledgeShareList(cnd);
        return iGenerator.convert(result, TrainKnowledgeShareViewVO.class);
    }

    @Override
    public List<TrainKnowledgeLearnViewVO> getErrorLearnList(String personId) {
        List<TrainLearnDTO> records = trainService.getImportLearnErrorList(personId);
        return iGenerator.convert(records, TrainKnowledgeLearnViewVO.class);
    }

    @Override
    public List<TrainKnowledgeShareViewVO> getErrorShareList(String personId) {
        List<TrainShareDTO> records = trainService.getImportShareErrorList(personId);
        return iGenerator.convert(records, TrainKnowledgeShareViewVO.class);
    }

    @Override
    public void deleteBatchLearnList(List<Integer> deletes) {
        trainService.deleteBatchLearnList(deletes);
    }

    @Override
    public void deleteBatchShareList(List<Integer> deletes) {
        trainService.deleteBatchShareList(deletes);
    }

    @Override
    public ImportResultVO importKnowledgeLearnData(List<TrainKnowledgeLearnViewVO> list, String personId) {
        List<TrainKnowledgeLearnViewVO> needSaveData = new ArrayList<>();
        List<TrainKnowledgeLearnViewVO> errorData = new ArrayList<>();
        Date currentDate = serverDateService.getServerDate();
        // 百分比解析
        NumberFormat nf = NumberFormat.getPercentInstance();
        // 时间解析
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");


        list.forEach(learnViewVO -> {
            learnViewVO.setRegister(personId);
            learnViewVO.setRegistrationDate(currentDate);
            // 将读取的数据转换成应保存的字段数据
            try {
                // 转换学习进度
                learnViewVO.setLearningRate(nf.parse(learnViewVO.getLearningRateStr()).doubleValue());
                // 转换学习时长
                learnViewVO.setLearningTime(new BigDecimal(learnViewVO.getLearningTimeStr()).doubleValue());
                // 转换获得学分
                learnViewVO.setEarnedCredits(new BigDecimal(learnViewVO.getEarnedCreditsStr()).doubleValue());
                // 转换首次学习时间
                learnViewVO.setStartDate(sdf.parse(learnViewVO.getStartDateStr()));
                // 转换最近学习时间
                learnViewVO.setEndDate(sdf.parse(learnViewVO.getEndDateStr()));
                needSaveData.add(learnViewVO);
            } catch (Exception e) {
                errorData.add(learnViewVO);
            }
        });
        List<TrainLearnDTO> needSaveDataDTO = iGenerator.convert(needSaveData, TrainLearnDTO.class);
        List<TrainLearnDTO> errorDataDTO = iGenerator.convert(errorData, TrainLearnDTO.class);
        ImportResultDTO result = trainService.saveKnowledgeLearn(personId, needSaveDataDTO, errorDataDTO);
        return iGenerator.convert(result, ImportResultVO.class);
    }

    @Override
    public ImportResultVO importKnowledgeShareData(List<TrainKnowledgeShareViewVO> list, String personId) {
        List<TrainKnowledgeShareViewVO> needSaveData = new ArrayList<>();
        List<TrainKnowledgeShareViewVO> errorData = new ArrayList<>();
        Date currentDate = serverDateService.getServerDate();
        // 时间解析
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        list.forEach(shareViewVO -> {
            shareViewVO.setRegister(personId);
            shareViewVO.setRegistrationDate(currentDate);

            try {
                // 转换分享时间
                shareViewVO.setShareDate(sdf.parse(shareViewVO.getShareDateStr()));
                needSaveData.add(shareViewVO);
            } catch (Exception e) {
                errorData.add(shareViewVO);
            }
        });

        List<TrainShareDTO> needSaveDataDTO = iGenerator.convert(needSaveData, TrainShareDTO.class);
        List<TrainShareDTO> errorDataDTO = iGenerator.convert(errorData, TrainShareDTO.class);
        ImportResultDTO result = trainService.saveKnowledgeShare(personId, needSaveDataDTO, errorDataDTO);
        return iGenerator.convert(result, ImportResultVO.class);
    }

    @Override
    public Result<PersonalTrainVO> getPersonalTrainList(PersonalTrainQueryCnd cnd) {
        PersonalTrainQueryCndDTO cndDTO = iGenerator.convert(cnd, PersonalTrainQueryCndDTO.class);
        Result<PersonalTrainDTO> result = trainService.getPersonalTrainList(cndDTO);
        return iGenerator.convert(result, PersonalTrainVO.class);
    }
}

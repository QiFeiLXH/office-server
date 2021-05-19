package com.bsoft.office.work.manager.impl;

import com.bsoft.clue.dto.SalesPlanDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.work.condition.MeetPersonQueryCnd;
import com.bsoft.office.work.manager.MeetPersonManager;
import com.bsoft.office.work.vo.MeetPersonExcelErrorVO;
import com.bsoft.office.work.vo.MeetPersonExcelVO;
import com.bsoft.office.work.vo.MeetPersonVO;
import com.bsoft.work.dto.MeetPersonDTO;
import com.bsoft.work.dto.MeetPersonQueryCndDTO;
import com.bsoft.work.service.MeetPersonService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author zhanglf
 * @Date 2020-12-21 15:39
 * @Version 1.0
 */
@Component
public class MeetPersonManagerImpl implements MeetPersonManager {
    @Reference
    private MeetPersonService meetPersonService;
    @Override
    public void saveMeetPerson(String personId, MeetPersonVO meetPerson) {
        MeetPersonDTO meetPersonDTO = GeneratorUtil.instance().convert(meetPerson,MeetPersonDTO.class);
        meetPersonService.saveMeetPerson(personId,meetPersonDTO);
    }

    @Override
    public void deleteMeetPerson(String personId, Integer id) {
        meetPersonService.deleteMeetPerson(personId,id);
    }

    @Override
    public Result<MeetPersonVO> getMeetPersons(String personId, MeetPersonQueryCnd cnd) {
        MeetPersonQueryCndDTO cndDTO = GeneratorUtil.instance().convert(cnd,MeetPersonQueryCndDTO.class);
        Result<MeetPersonDTO> result = meetPersonService.getMeetPersons(personId,cndDTO);
        return GeneratorUtil.instance().convert(result,MeetPersonVO.class);
    }

    @Override
    public ImportResultVO importMeetPersonData(String personId,List<MeetPersonExcelVO> importVOList,Integer meetId) {
        List<MeetPersonDTO> importDTOList = GeneratorUtil.instance().convert(importVOList, MeetPersonDTO.class);
        Map<String, List<MeetPersonDTO>> checkResult = this.checkImportData(personId,importDTOList,meetId);
        List<MeetPersonDTO> saveList = checkResult.get("saveList");
        List<MeetPersonDTO> errorList = checkResult.get("errorList");
        meetPersonService.importMeetPersonData(personId,saveList,errorList);
        return new ImportResultVO(saveList.size(), errorList.size());
    }

    @Override
    public List<MeetPersonExcelErrorVO> exportErrorData(String personId) {
        List<MeetPersonDTO> list = meetPersonService.exportErrorData(personId);
        return GeneratorUtil.instance().convert(list,MeetPersonExcelErrorVO.class);
    }

    @Override
    public String havePersonExits(String personId, MeetPersonVO meetPerson) {
        MeetPersonDTO meetPersonDTO = GeneratorUtil.instance().convert(meetPerson,MeetPersonDTO.class);
        return meetPersonService.havePersonExits(personId,meetPersonDTO);
    }

    @Override
    public Boolean personExitsMeet(String personId, MeetPersonVO meetPerson) {
        MeetPersonDTO meetPersonDTO = GeneratorUtil.instance().convert(meetPerson,MeetPersonDTO.class);
        Boolean exitFlag = meetPersonService.personExitsMeet(personId,meetPersonDTO);
        return exitFlag;
    }

    /**
     * 校验导入数据
     */
    private Map<String, List<MeetPersonDTO>> checkImportData(String personId,List<MeetPersonDTO> importList,Integer meetId) {
        List<MeetPersonDTO> saveList = new ArrayList<>();
        List<MeetPersonDTO> errorList = new ArrayList<>();
        HashMap<String, List<MeetPersonDTO>> result = new HashMap<>();
        List<MeetPersonDTO> exitsPersonList = meetPersonService.getMeetPersons(personId,meetId);
        List<String> exitsMobiles = new ArrayList<>();
        if(exitsPersonList.size() > 0){
            exitsPersonList.forEach(item->{
                exitsMobiles.add(item.getMobileNo());
            });
        }
        // 非空判断
        importList.forEach(item -> {
            Boolean hasNull = StringUtils.isBlank(item.getMobileNo())
                    || StringUtils.isBlank(item.getPersonName());
            if (hasNull) {
                item.setFailReason("必填数据不能为空");
                errorList.add(item);
            } else {
                if(exitsMobiles.contains(item.getMobileNo())){
                    item.setFailReason("该手机号已参与会议");
                    errorList.add(item);
                }else{
                    saveList.add(item);
                }
            }
        });
        // 将结果用map封装传回
        result.put("saveList", saveList);
        result.put("errorList", errorList);
        return result;
    }
}

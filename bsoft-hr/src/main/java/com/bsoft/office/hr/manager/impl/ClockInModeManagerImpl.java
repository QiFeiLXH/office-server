package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.ClockInModeDeptInfoDTO;
import com.bsoft.hr.dto.ClockInModePersonalInfoDTO;
import com.bsoft.hr.dto.ClockInModeQueryCndDTO;
import com.bsoft.hr.service.ClockInModeService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.condition.ClockInModeQueryCnd;
import com.bsoft.office.hr.manager.ClockInModeManager;
import com.bsoft.office.hr.vo.ClockInModeDeptInfoVO;
import com.bsoft.office.hr.vo.ClockInModePersonalInfoVO;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 打卡方式维护
 */
@Component
public class ClockInModeManagerImpl implements ClockInModeManager {
    @Reference(timeout = 60000)
    private ClockInModeService clockInModeService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ClockInModeDeptInfoVO> listDeptInfo(String userId, ClockInModeQueryCnd cnd) {
        ClockInModeQueryCndDTO queryCndDTO = iGenerator.convert(cnd, ClockInModeQueryCndDTO.class);
        Result<ClockInModeDeptInfoDTO> resultDTO = clockInModeService.listDeptInfoWithPage(userId, queryCndDTO);
        Result<ClockInModeDeptInfoVO> resultVO = iGenerator.convert(resultDTO, ClockInModeDeptInfoVO.class);
        resultVO.setItems(deptInfoParserTree(resultVO.getItems()));
        return resultVO;
    }

    @Override
    public Result<ClockInModePersonalInfoVO> listPersonalInfo(String userId, ClockInModeQueryCnd cnd) {
        ClockInModeQueryCndDTO queryCndDTO = iGenerator.convert(cnd, ClockInModeQueryCndDTO.class);
        Result<ClockInModePersonalInfoDTO> resultDTO = clockInModeService.listPersonalInfoWithPage(userId, queryCndDTO);
        Result<ClockInModePersonalInfoVO> resultVO = iGenerator.convert(resultDTO, ClockInModePersonalInfoVO.class);
        return iGenerator.convert(resultVO, ClockInModePersonalInfoVO.class);
    }

    @Override
    public void setDept(String userId, List<ClockInModeDeptInfoVO> deptInfoVOList) {
        List<ClockInModeDeptInfoDTO> deptInfoDTOList = iGenerator.convert(deptInfoVOList, ClockInModeDeptInfoDTO.class);
        clockInModeService.setDept(userId, deptInfoDTOList);
    }

    @Override
    public void setPersonal(String userId, List<ClockInModePersonalInfoVO> personalInfoVOList) {
        List<ClockInModePersonalInfoDTO> personalInfoDTOList = iGenerator.convert(personalInfoVOList, ClockInModePersonalInfoDTO.class);
        clockInModeService.setPersonal(userId, personalInfoDTOList);
    }

    private List<ClockInModeDeptInfoVO> deptInfoParserTree(List<ClockInModeDeptInfoVO> oldList) {
        try {
            Collection<ClockInModeDeptInfoVO> parentCol = Collections2.filter(oldList, x -> StringUtils.isBlank(x.getParentDept()));
            List<ClockInModeDeptInfoVO> parentList = new ArrayList<>(parentCol);
            parentList.forEach(parent -> {
                Collection<ClockInModeDeptInfoVO> childrenCol = Collections2.filter(oldList, x -> parent.getDept().equals(x.getParentDept()));
                List<ClockInModeDeptInfoVO> childrenList = new ArrayList<>(childrenCol);
                parent.setChildren(childrenList);
            });
            if(parentList.size() == 0){
                return oldList;
            } else {
                return parentList;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

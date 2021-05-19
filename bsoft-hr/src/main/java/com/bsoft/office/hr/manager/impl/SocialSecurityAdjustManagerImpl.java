package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.PersonSocialPlaceDTO;
import com.bsoft.hr.dto.PersonSocialPlaceQueryCndDTO;
import com.bsoft.hr.dto.SocialAdjustmentRecordDTO;
import com.bsoft.hr.service.SocialSecurityService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.condition.PersonSocialPlaceQueryCnd;
import com.bsoft.office.hr.manager.SocialSecurityAdjustManager;
import com.bsoft.office.hr.vo.PersonSocialPlaceViewVO;
import com.bsoft.office.hr.vo.SocialAdjustmentRecordVO;
import com.bsoft.office.hr.vo.SocialAdjustmentRecordViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 8:47
 * @Description
 */
@Service
public class SocialSecurityAdjustManagerImpl implements SocialSecurityAdjustManager {
    @Autowired
    private IGenerator iGenerator;
    @Reference(timeout = 10000)
    private SocialSecurityService socialSecurityService;

    @Override
    public Result<PersonSocialPlaceViewVO> getPersonalSocialPlaceList(PersonSocialPlaceQueryCnd cnd) {
        PersonSocialPlaceQueryCndDTO cndDTO = iGenerator.convert(cnd, PersonSocialPlaceQueryCndDTO.class);
        Result<PersonSocialPlaceDTO> result = socialSecurityService.getPersonalSocialPlaceList(cndDTO);
        return iGenerator.convert(result, PersonSocialPlaceViewVO.class);
    }

    @Override
    public void savePersonalSocialPlaces(List<SocialAdjustmentRecordVO> records, String personId) {
        List<SocialAdjustmentRecordDTO> recordDTOS = iGenerator.convert(records, SocialAdjustmentRecordDTO.class);
        socialSecurityService.savePersonalSocialPlaces(recordDTOS,personId);
    }

    @Override
    public Result<SocialAdjustmentRecordViewVO> getPersonAdjustRecordList(Integer pageNo, Integer pageSize, String personId) {
        Result<SocialAdjustmentRecordDTO> result = socialSecurityService.getPersonalSocialAdjustmentRecordList(personId, pageNo, pageSize);
        return iGenerator.convert(result, SocialAdjustmentRecordViewVO.class);
    }
}

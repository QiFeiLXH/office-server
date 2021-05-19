package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.PersonSocialPlaceQueryCnd;
import com.bsoft.office.hr.vo.PersonSocialPlaceViewVO;
import com.bsoft.office.hr.vo.SocialAdjustmentRecordVO;
import com.bsoft.office.hr.vo.SocialAdjustmentRecordViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 8:47
 * @Description
 */
public interface SocialSecurityAdjustManager {
    Result<PersonSocialPlaceViewVO> getPersonalSocialPlaceList(PersonSocialPlaceQueryCnd cnd);

    void savePersonalSocialPlaces(List<SocialAdjustmentRecordVO> records, String personId);

    Result<SocialAdjustmentRecordViewVO> getPersonAdjustRecordList(Integer pageNo, Integer pageSize, String personId);
}

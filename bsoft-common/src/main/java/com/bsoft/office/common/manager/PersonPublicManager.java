package com.bsoft.office.common.manager;

import com.bsoft.office.common.condition.PersonSelectQueryCnd;
import com.bsoft.office.common.vo.PersonSelectViewVO;

import javax.management.Query;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/23 10:43
 * @Description
 */
public interface PersonPublicManager {
    PersonSelectViewVO getCurrentPerson(String userId);

    List<PersonSelectViewVO> findPersonSelectList(String simpleCode);

    List<PersonSelectViewVO> findSelectPersonList(String inputContent, Integer isValid);

    List<PersonSelectViewVO> getPersonSelectList(PersonSelectQueryCnd queryCnd);

    List<PersonSelectViewVO> getPersonsWithPersonIds(List<String> personIds);
}

package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.PublicDicVO;


public interface PersonTypeManager {
    /**
     * 获取人员财务类别
     * @param publicDicVO
     * @return
     */
    PublicDicVO getPersonTypeInfo(String userId, PublicDicVO publicDicVO);

    /**
     * 获取人员财务类别列表
     * @param publicDicVO
     * @return
     */
    Result<PublicDicVO> getPersonTypeInfoList(Integer pageNo,Integer pageSize,Integer type,Integer personflag);

    /**
     * 保存人员财务类别（hr）
     * @param publicDicVO
     */
    void addPersonType(String userId,PublicDicVO publicDicVO);

    /**
     * 修改人员财务类别（hr）
     * @param publicDicVO
     */
    void updatePersonType(String userId, PublicDicVO publicDicVO);


    /**
     * 注销人员财务类别（hr）
     * @param id
     */
    boolean logoutPersonType(Integer id);

}

package com.bsoft.office.work.manager;


import com.bsoft.office.work.condition.PolicyQueryCnd;
import com.bsoft.office.work.vo.ManagerGroupVO;
import com.bsoft.work.dto.ManagerGroupDTO;

import java.util.List;

/**
 * @author Huang GH
 * @date 2021/5/10 13:13
 */
public interface ManagerGroupManager {


    /**
     *
     * @param councilName:组名称
     * @param isCancel:是否注销
     * @return
     */
    List<ManagerGroupVO> findList(String councilName, Integer isCancel);

    /**
     *
     * @param councilId:组id
     * @param isCancel:注销标志
     */
    void cancelManagerGroup(Integer councilId,Integer isCancel);

    /**
     *
     * @param managerGroupList:要保存的组列表
     */
    void saveManagerGroups(List<ManagerGroupVO> managerGroupList);

    List<ManagerGroupDTO> findByQueryCnd(PolicyQueryCnd queryCnd);
}

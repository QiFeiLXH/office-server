package com.bsoft.office.work.manager;

import com.bsoft.office.work.vo.ManagerVO;

import java.util.List;

/**
 * @Author ding cj
 * @Date 2021/5/14 9:57
 * @Description
 */
public interface ManagerManager {
    /**
     * @param personName:姓名
     * @param councilId:委员会Id
     * @return
     */
    List<ManagerVO> findList(String personName, Integer councilId);

    /**
     *
     * @param id:主键id
     */
    void deleteManager(Integer id);

    /**
     *
     * @param managerList:要保存的记录
     */
    void saveManager(List<ManagerVO> managerList);
}

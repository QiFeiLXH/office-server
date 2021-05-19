package com.bsoft.office.common.manager;

import com.bsoft.office.common.vo.DeptVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/23 10:43
 * @Description
 */
public interface DeptPublicManager {
    List<DeptVO> getDeptTree(String logout);

    List<DeptVO> listDeptForSelect(String logout, String deptType);

    List<DeptVO> listDeptForSelectWithPerson(String logout, String deptType,String personId);

    List<DeptVO> getAllValidRegionList();
}

package com.bsoft.office.organ.manager;

import com.bsoft.cost.dto.DeptCostTypeViewDTO;
import com.bsoft.office.organ.vo.CostTypeDeptViewVO;
import com.bsoft.office.organ.vo.DeptCostTypeViewVO;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 10:04
 * @Description:
 */
public interface DeptCostTypeManager {

    List<CostTypeDeptViewVO> findDeptList(Integer year,Integer flag, Integer bmlb, Integer zxbz,String deptId);

    DeptCostTypeViewVO getDeptCostType(Integer year, String deptNo);

    void saveCostType(DeptCostTypeViewVO deptCostTypeViewVO);

    boolean checkAnnualGener(Integer year);

    void annualGener(Integer year,String personId);
}

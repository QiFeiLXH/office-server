package com.bsoft.office.organ.manager;

import com.bsoft.common.result.Result;
import com.bsoft.dept.dto.DeptSelectDTO;
import com.bsoft.office.organ.condition.DeptMaintainInfoQueryCnd;
import com.bsoft.office.organ.vo.DeptCostMaintainInfoVO;
import com.bsoft.office.organ.vo.DeptCostMaintainVO;


import java.util.List;

public interface DeptCostMaintainManager {
    /**
     * 获取部门集合
     */
    List<String> getDeptList();

    /**
     * 按部门更新财物类别信息(更新同时删除该部门下所有岗位的维护信息)
     */
    boolean updateDeptCost(String userId, DeptCostMaintainVO deptCostMaintainVO);

    /**
     * 按照岗位更新财物类别信息
     */
    List<String> updatePostCost(String userId,List<DeptCostMaintainVO> deptCostMaintainVOList);

    /**
     * 查询部门下所有的岗位财务类别信息(按岗位)
     */
    List<DeptCostMaintainVO> selectWithDept(String Dept);

    /**
     * 查询部门下所有的岗位财务类别信息（按部门）
     */
    DeptCostMaintainVO getDeptFinancialType(String Dept);

    /**
     * 获取部门选择器组件数据
     * @param logout 注销标志 ''全部，0未注销，1注销
     * @param maintain 维护标志标志   0未维护，1全部
     * @param deptType 部门类别 ''全部，1行政职能，2大区，3事业部，4其他
     * @return java.util.List<com.bsoft.dept.dto.DeptSelectDTO;>
     */
    List<DeptSelectDTO> listDeptForMaintainSelect(String logout, Integer maintain, String deptType);



    /**
     * 获取部门维护信息
     */
    Result<DeptCostMaintainInfoVO> listDeptInfo(String userId, DeptMaintainInfoQueryCnd cnd);


    /**
     * 修改部门维护信息
     * @param queryCndDTO
     * @return
     */
    void updateDeptInfoWithPage(String userId, List<DeptMaintainInfoQueryCnd> queryCndDTO);
}

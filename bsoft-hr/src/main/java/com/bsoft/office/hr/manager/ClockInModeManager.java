package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.ClockInModeQueryCnd;
import com.bsoft.office.hr.vo.ClockInModeDeptInfoVO;
import com.bsoft.office.hr.vo.ClockInModePersonalInfoVO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 打卡方式维护
 */
public interface ClockInModeManager {
    /**
     * 获取部门打卡方式信息
     */
    Result<ClockInModeDeptInfoVO> listDeptInfo(String userId, ClockInModeQueryCnd cnd);
    /**
     * 获取个人打卡方式信息
     */
    Result<ClockInModePersonalInfoVO> listPersonalInfo(String userId, ClockInModeQueryCnd cnd);
    /**
     * 设置部门打卡方式
     */
    void setDept(String userId, List<ClockInModeDeptInfoVO> deptInfoVOList);
    /**
     * 设置个人打卡方式
     */
    void setPersonal(String userId, List<ClockInModePersonalInfoVO> personalInfoVOList);
}
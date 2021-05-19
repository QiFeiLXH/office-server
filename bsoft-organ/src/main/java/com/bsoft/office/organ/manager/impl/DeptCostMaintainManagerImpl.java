package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.dept.dto.DeptSelectDTO;
import com.bsoft.dept.service.DeptService;
import com.bsoft.hr.dto.*;
import com.bsoft.hr.service.DeptCostMaintainService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.organ.condition.DeptMaintainInfoQueryCnd;
import com.bsoft.office.organ.manager.DeptCostMaintainManager;
import com.bsoft.office.organ.vo.DeptCostMaintainInfoVO;
import com.bsoft.office.organ.vo.DeptCostMaintainVO;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class DeptCostMaintainManagerImpl implements DeptCostMaintainManager {
    @Reference(timeout = 60000)
    private DeptCostMaintainService deptCostMaintainService;
    @Reference(timeout = 60000)
    private DeptService deptService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<String> getDeptList() {
        return deptCostMaintainService.getDeptList();
    }

    @Override
    public boolean updateDeptCost(String userId, DeptCostMaintainVO deptCostMaintainVO) {
        DeptCostMaintainDTO convert = iGenerator.convert(deptCostMaintainVO, DeptCostMaintainDTO.class);
        return  deptCostMaintainService.updateDeptCost(userId,convert);

    }

    @Override
    public List<String> updatePostCost(String userId,List<DeptCostMaintainVO> deptCostMaintainVOList) {
        List<DeptCostMaintainDTO> convert = iGenerator.convert(deptCostMaintainVOList, DeptCostMaintainDTO.class);
        return deptCostMaintainService.updatePostCost(userId,convert);
    }

    @Override
    public List<DeptCostMaintainVO> selectWithDept(String Dept) {
        List<DeptCostMaintainDTO> deptCostMaintainDTOS = deptCostMaintainService.selectWithDept(Dept);
        List<DeptCostMaintainVO> convert = iGenerator.convert(deptCostMaintainDTOS, DeptCostMaintainVO.class);
        return convert;
    }

    @Override
    public DeptCostMaintainVO getDeptFinancialType(String Dept) {
        DeptCostMaintainDTO deptCostMaintainDTOS = deptCostMaintainService.getDeptFinancialType(Dept);
        DeptCostMaintainVO convert = iGenerator.convert(deptCostMaintainDTOS, DeptCostMaintainVO.class);
        return convert;
    }

    @Override
    public List<DeptSelectDTO> listDeptForMaintainSelect(String logout, Integer maintain, String deptType) {
//        return deptService.listDeptForMaintainSelect(logout,maintain,deptType);
        return null;

    }

    @Override
    public Result<DeptCostMaintainInfoVO> listDeptInfo(String userId, DeptMaintainInfoQueryCnd cnd) {
        DeptMaintainInfoQueryCndDTO queryCndDTO = iGenerator.convert(cnd, DeptMaintainInfoQueryCndDTO.class);
        Result<DeptMaintainInfoDTO> resultDTO = deptCostMaintainService.listDeptInfoWithPage(userId, queryCndDTO);
        Result<DeptCostMaintainInfoVO> resultVO = iGenerator.convert(resultDTO, DeptCostMaintainInfoVO.class);
        resultVO.setItems(deptInfoParserTree(resultVO.getItems()));
        return resultVO;
    }

    @Override
    public void updateDeptInfoWithPage(String userId, List<DeptMaintainInfoQueryCnd> cnd) {
        List<DeptMaintainInfoQueryCndDTO> queryCndDTO = iGenerator.convert(cnd, DeptMaintainInfoQueryCndDTO.class);
        deptCostMaintainService.updateDeptInfoWithPage(userId,queryCndDTO);
    }


    private List<DeptCostMaintainInfoVO> deptInfoParserTree(List<DeptCostMaintainInfoVO> oldList) {
        try {
            Collection<DeptCostMaintainInfoVO> parentCol = Collections2.filter(oldList, x -> StringUtils.isBlank(x.getParentDept()));
            List<DeptCostMaintainInfoVO> parentList = new ArrayList<>(parentCol);
            parentList.forEach(parent -> {
                Collection<DeptCostMaintainInfoVO> childrenCol = Collections2.filter(oldList, x -> parent.getDept().equals(x.getParentDept()));
                List<DeptCostMaintainInfoVO> childrenList = new ArrayList<>(childrenCol);
                parent.setChildren(childrenList);
            });
            if(parentList.size() == 0){
                return oldList;
            } else {
                return parentList;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

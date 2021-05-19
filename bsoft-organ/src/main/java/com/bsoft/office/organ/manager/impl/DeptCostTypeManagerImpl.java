package com.bsoft.office.organ.manager.impl;

import com.bsoft.cost.dto.CostTypeDeptViewDTO;
import com.bsoft.cost.dto.DeptCostTypeViewDTO;
import com.bsoft.cost.service.DeptCostTypeService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.organ.manager.DeptCostTypeManager;
import com.bsoft.office.organ.vo.CostTypeDeptViewVO;
import com.bsoft.office.organ.vo.DeptCostTypeViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 10:05
 * @Description:
 */
@Component
public class DeptCostTypeManagerImpl implements DeptCostTypeManager {
    @Reference
    private DeptCostTypeService deptCostTypeService;

    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<CostTypeDeptViewVO> findDeptList(Integer year,Integer flag, Integer bmlb, Integer zxbz,String deptId) {
        List<CostTypeDeptViewDTO> list = deptCostTypeService.findDeptList(year,flag, bmlb, zxbz, deptId);
        return generatorUtil.convert(list,CostTypeDeptViewVO.class);
    }

    @Override
    public DeptCostTypeViewVO getDeptCostType(Integer year, String deptNo) {
        DeptCostTypeViewDTO dto = deptCostTypeService.getDeptCostType(year,deptNo);
        return generatorUtil.convert(dto,DeptCostTypeViewVO.class);
    }

    @Override
    public void saveCostType(DeptCostTypeViewVO vo) {
        DeptCostTypeViewDTO dto = generatorUtil.convert(vo,DeptCostTypeViewDTO.class);
        deptCostTypeService.saveCostType(dto);
    }

    @Override
    public boolean checkAnnualGener(Integer year) {
        return deptCostTypeService.checkAnnualGener(year);
    }

    @Override
    public void annualGener(Integer year, String personId) {
        deptCostTypeService.annualGener(year,personId);
    }
}

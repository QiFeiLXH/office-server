package com.bsoft.office.common.manager.impl;

import com.bsoft.dept.dto.DeptSelectDTO;
import com.bsoft.dept.service.DeptService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.DeptPublicManager;
import com.bsoft.office.common.vo.DeptVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/23 10:43
 * @Description
 */
@Component
public class DeptPublicManagerImpl implements DeptPublicManager {
    @Reference(timeout = 60000)
    private DeptService deptService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<DeptVO> getDeptTree(String logout) {
        List<DeptSelectDTO> list = deptService.findDeptSelectList(logout);
        List<DeptVO> orgDeptVOS = generatorUtil.convert(list,DeptVO.class);
        return orgDeptVOS;
    }


    @Override
    public List<DeptVO> listDeptForSelect(String logout, String deptType) {
        List<DeptSelectDTO> list = deptService.listDeptForSelect(logout, deptType);
        List<DeptVO> orgDeptVOS = generatorUtil.convert(list,DeptVO.class);
        return orgDeptVOS;
    }

    @Override
    public List<DeptVO> listDeptForSelectWithPerson(String logout, String deptType, String personId) {
        List<DeptSelectDTO> list = deptService.listDeptForSelectWithPerson(logout, deptType, personId);
        List<DeptVO> orgDeptVOS = generatorUtil.convert(list, DeptVO.class);
        return orgDeptVOS;
    }

    @Override
    public List<DeptVO> getAllValidRegionList() {
        List<DeptSelectDTO> list = deptService.getAllValidParentDeptList();
        return generatorUtil.convert(list, DeptVO.class);
    }
}

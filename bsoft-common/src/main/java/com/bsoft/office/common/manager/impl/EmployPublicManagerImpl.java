package com.bsoft.office.common.manager.impl;

import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.EmployPublicManager;
import com.bsoft.office.common.vo.AdministrativeAreaVO;
import com.bsoft.person.dto.AdministrativeAreaDTO;
import com.bsoft.person.service.EmployService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/26 10:20
 * @Description
 */
@Component
public class EmployPublicManagerImpl implements EmployPublicManager {
    @Reference(timeout = 60000)
    private EmployService employService;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<AdministrativeAreaVO> getAdministrativeAreaTree() {
        List<AdministrativeAreaDTO> areaTree = employService.getAdministrativeAreaTree();
        return generatorUtil.convert(areaTree,AdministrativeAreaVO.class);
    }
}

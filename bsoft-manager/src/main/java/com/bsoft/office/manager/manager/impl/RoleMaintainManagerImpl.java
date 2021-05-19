package com.bsoft.office.manager.manager.impl;

import com.bsoft.auth.dto.RoleMaintainBaseDTO;
import com.bsoft.auth.dto.RoleNameDTO;
import com.bsoft.auth.service.RoleMaintainService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.manager.manager.RoleMaintainManager;
import com.bsoft.office.manager.vo.RoleMaintainBaseVO;
import com.bsoft.office.manager.vo.RoleNameVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/8/3
 * @Description:
 */
@Component
public class RoleMaintainManagerImpl implements RoleMaintainManager {

    @Reference
    private RoleMaintainService roleMaintainService;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<RoleNameVO> getRoles(Integer status, String content) {
        List<RoleNameDTO> roles = roleMaintainService.getRoles(status, content);
        return iGenerator.convert(roles,RoleNameVO.class);
    }

    @Override
    public RoleNameVO saveRole(RoleNameVO roleNameVO) {
        RoleNameDTO roleNameDTO = iGenerator.convert(roleNameVO,RoleNameDTO.class);
        roleNameDTO = roleMaintainService.saveRole(roleNameDTO);
        return iGenerator.convert(roleNameDTO,RoleNameVO.class);
    }

    @Override
    public List<RoleMaintainBaseVO> getDeptRoles(String dept) {
        List<RoleMaintainBaseDTO> roleMaintainBase = roleMaintainService.getRoleMaintainBase(dept);
        return iGenerator.convert(roleMaintainBase,RoleMaintainBaseVO.class);
    }

    @Override
    public void saveDeptRoles(List<RoleMaintainBaseVO> deptRoles) {
        List<RoleMaintainBaseDTO> list = iGenerator.convert(deptRoles, RoleMaintainBaseDTO.class);
        roleMaintainService.saveDeptRoles(list);
    }

    @Override
    public List<Map<String, Object>> getDeptRoleDetails() {
        return roleMaintainService.getDeptRoleDetails();
    }

    @Override
    public Map<String, Object> exportDeptRoleDetails() {
        List<Map<String, Object>> records = roleMaintainService.getDeptRoleDetails();
        LinkedHashMap<String, String> sheetHead = this.getSheetHead(null);
        Map<String, Object> colsAndData = new HashMap<>();
        colsAndData.put("head", sheetHead);
        colsAndData.put("data",records);
        return colsAndData;
    }

    @Override
    public List<RoleNameVO> saveRoles(List<RoleNameVO> roles) {
        List<RoleNameDTO> list = iGenerator.convert(roles,RoleNameDTO.class);
        list = roleMaintainService.saveRoles(list);
        return iGenerator.convert(list,RoleNameVO.class);
    }

    /**
     * @param otherColumns 其他字段（除公共字段外）
     * @return
     */
    public LinkedHashMap<String, String> getSheetHead(LinkedHashMap<String, String> otherColumns) {
        List<RoleNameVO> roles = this.getRoles(0,"");
        LinkedHashMap<String, String> costColumns = new LinkedHashMap<>(200);
        roles.forEach(column ->{
            costColumns.put(("name_"+column.getId()).toUpperCase(),column.getRoleName());
        });
        LinkedHashMap<String, String> head = new LinkedHashMap<>(150);
        LinkedHashMap<String, String> baseProjectLevelMap = new LinkedHashMap<>();

        baseProjectLevelMap.put("BMMC","部门名称");

        head.putAll(baseProjectLevelMap);
        if (otherColumns != null) {
            head.putAll(otherColumns);
        }
        head.putAll(costColumns);
        return head;

    }


}

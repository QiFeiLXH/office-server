package com.bsoft.office.common.manager;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/19 17:04
 * @Description
 */
public interface DeptPermissionManager {
    List<String> getPersonalAuthorityDepts(String personId, Integer flag);

    void saveAuthorityDept(String personId, Integer flag, List<String> needSaves, List<String> needDeletes);
}

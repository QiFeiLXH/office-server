package com.bsoft.office.common.manager;

import com.bsoft.office.common.vo.AdministrativeAreaVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/26 10:19
 * @Description
 */
public interface EmployPublicManager {
    List<AdministrativeAreaVO> getAdministrativeAreaTree();
}

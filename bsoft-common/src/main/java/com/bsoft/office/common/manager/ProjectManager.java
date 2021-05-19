package com.bsoft.office.common.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.ProjectLookVO;
import com.bsoft.office.common.vo.ProjectVO;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:52
 * @Description
 */
public interface ProjectManager {
    Result<ProjectVO> getProjectList(Integer pageNo,Integer pageSize, String contractNo);

    Result<ProjectLookVO> getProjectLookList(Integer pageNo, Integer pageSize, String contractNo, String inputContent);

    /**
     * 工程、服务，未完结项目
     * @param pageNo
     * @param pageSize
     * @param inputContent
     * @return
     */
    Result<ProjectLookVO> getAllProjectList(Integer pageNo, Integer pageSize, String inputContent);

}

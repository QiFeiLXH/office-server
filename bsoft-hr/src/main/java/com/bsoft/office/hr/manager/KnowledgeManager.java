package com.bsoft.office.hr.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.hr.vo.KnowledgeNumViewVO;
import com.bsoft.office.hr.vo.KnowledgeVO;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/6 12:53
 * @Description
 */
public interface KnowledgeManager {
    Result<KnowledgeNumViewVO> getKnowledgeNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize);

    Result<KnowledgeVO> getPersonalKnowledgeList(String personId, Integer pageNo, Integer pageSize);

    FileServerDefinitionDTO downloadFile(Integer fileId);
}

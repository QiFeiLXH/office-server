package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.FileServerService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.manager.KnowledgeManager;
import com.bsoft.office.hr.vo.KnowledgeNumViewVO;
import com.bsoft.office.hr.vo.KnowledgeVO;
import com.bsoft.person.dto.KnowledgeDTO;
import com.bsoft.person.dto.KnowledgeNumDTO;
import com.bsoft.person.service.KnowledgeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/6 12:53
 * @Description
 */
@Service
public class KnowledgeManagerImpl implements KnowledgeManager {
    @Reference
    private KnowledgeService knowledgeService;
    @Reference(timeout = 60000)
    private FileServerService fileServerService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<KnowledgeNumViewVO> getKnowledgeNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        Result<KnowledgeNumDTO> result = knowledgeService.getKnowledgeNumList(deptId, inputContent, pageNo, pageSize);
        return iGenerator.convert(result, KnowledgeNumViewVO.class);
    }

    @Override
    public Result<KnowledgeVO> getPersonalKnowledgeList(String personId, Integer pageNo, Integer pageSize) {
        Result<KnowledgeDTO> result = knowledgeService.getPersonalKnowledgeList(personId, pageNo, pageSize);
        return iGenerator.convert(result,KnowledgeVO.class);
    }

    @Override
    public FileServerDefinitionDTO downloadFile(Integer fileId) {
        FileServerDefinitionDTO file = fileServerService.get(fileId);
        return file;
    }
}

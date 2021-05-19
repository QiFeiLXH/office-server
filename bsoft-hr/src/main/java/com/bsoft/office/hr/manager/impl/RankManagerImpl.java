package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.FileServerService;
//import com.bsoft.hr.dto.RankDTO;
import com.bsoft.hr.service.RankService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.hr.manager.RankManager;
import com.bsoft.office.hr.vo.RankViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/3 13:13
 * @Description
 */
@Service
public class RankManagerImpl implements RankManager {
    @Reference
    private RankService rankService;
    @Reference(timeout = 60000)
    private FileServerService fileServerService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<RankViewVO> getRankList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        /*Result<RankDTO> result = rankService.getRankList(year, deptId, inputContent, pageNo, pageSize);
        return iGenerator.convert(result, RankViewVO.class);*/
        return null;
    }

    @Override
    public FileServerDefinitionDTO downloadFile(Integer fileId) {
        FileServerDefinitionDTO file = fileServerService.get(fileId);
        return file;
    }
}

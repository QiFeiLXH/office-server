package com.bsoft.office.common.manager.impl;

import com.bsoft.common.dto.CostDicDTO;
import com.bsoft.common.service.CostDicService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.CostDicManager;
import com.bsoft.office.common.vo.CostDicVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
@Component
public class CostDicManagerImpl implements CostDicManager {

    @Reference
    private CostDicService costDicService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<CostDicVO> getCostDicList(Integer type, Integer logout) {
        List<CostDicDTO> resultDTO = costDicService.getCostDicList(type, logout);
        return iGenerator.convert(resultDTO, CostDicVO.class);
    }

    @Override
    public List<CostDicVO> getCostDicList(Integer type,Integer subType, Integer logout, String inputContent) {
        List<CostDicDTO> resultDTO = costDicService.getCostDicList(type, subType, logout, inputContent);
        return iGenerator.convert(resultDTO, CostDicVO.class);
    }
}

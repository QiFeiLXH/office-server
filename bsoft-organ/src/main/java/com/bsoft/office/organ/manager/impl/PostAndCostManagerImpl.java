package com.bsoft.office.organ.manager.impl;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.hr.dto.PostAndCostRuleDTO;
import com.bsoft.hr.service.PostAndCostRuleService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.organ.manager.PostAndCostRuleManager;
import com.bsoft.office.organ.vo.PostAndCostRuleVO;
import com.bsoft.person.dto.HumanDicDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PostAndCostManagerImpl implements PostAndCostRuleManager {

    @Reference(timeout = 60000)
    private PostAndCostRuleService postAndCostRuleService;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public List<PostAndCostRuleVO> getPostAndCostRuleInfoList() {
        List<PostAndCostRuleDTO> postAndCostRuleInfoList = postAndCostRuleService.getPostAndCostRuleInfoList();
        return iGenerator.convert(postAndCostRuleInfoList,PostAndCostRuleVO.class);
    }

    @Override
    public void updatePostAndCostRule(PostAndCostRuleVO postAndCostRuleVO) {
        PostAndCostRuleDTO convert = iGenerator.convert(postAndCostRuleVO, PostAndCostRuleDTO.class);
        postAndCostRuleService.updatePostAndCostRule(convert);
    }

    @Override
    public boolean deletePostAndCostRule(Integer id) {
        return postAndCostRuleService.deletePostAndCostRule(id);
    }

    @Override
    public List<HumanDicDTO> getPostList() {
        return postAndCostRuleService.getPostList();
    }

    @Override
    public List<SystemDicDTO> getCostList() {
        return postAndCostRuleService.getCostList();
    }

    @Override
    public List<PublicDicDTO> getFinanceList() {
        return postAndCostRuleService.getFinanceList();
    }
}

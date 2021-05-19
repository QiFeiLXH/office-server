package com.bsoft.office.organ.manager;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.office.organ.vo.PostAndCostRuleVO;
import com.bsoft.person.dto.HumanDicDTO;

import java.util.List;

public interface PostAndCostRuleManager {
    /**
     * 获取岗位费用默认规则列表
     * @param
     * @return
     */
    List<PostAndCostRuleVO> getPostAndCostRuleInfoList();

    /**
     * 修改岗位费用默认规则（hr）
     * @param postAndCostRuleVO
     */
    void updatePostAndCostRule( PostAndCostRuleVO postAndCostRuleVO);


    /**
     * 删除岗位费用默认规则（hr）
     * @param id
     */
    boolean deletePostAndCostRule( Integer id);

    /**
     * 查询公共表所有岗位大类（common）
     * @param
     */
    List<HumanDicDTO> getPostList();

    /**
     * 查询公共表所有费用类别（common）
     * @param
     */
    List<SystemDicDTO> getCostList();

    /**
     * 查询公共表所有财务类别（common）
     * @param
     */
    List<PublicDicDTO> getFinanceList();
}

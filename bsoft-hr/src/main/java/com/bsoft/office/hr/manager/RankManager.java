package com.bsoft.office.hr.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.hr.vo.RankViewVO;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/3 13:13
 * @Description
 */
public interface RankManager {
    Result<RankViewVO> getRankList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize);

    FileServerDefinitionDTO downloadFile(Integer fileId);
}

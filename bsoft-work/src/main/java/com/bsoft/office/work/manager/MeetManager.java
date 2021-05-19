package com.bsoft.office.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.work.condition.MeetQueryCnd;
import com.bsoft.office.work.vo.MeetPersonVO;
import com.bsoft.office.work.vo.MeetVO;
import com.bsoft.office.work.vo.MeetViewVO;
import com.bsoft.work.dto.MeetDTO;
import com.bsoft.work.dto.MeetPersonDTO;
import com.bsoft.work.dto.MeetQueryCndDTO;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:29
 * @Version 1.0
 */
public interface MeetManager {
    void saveMeet(String personId, MeetVO meetVO);

    /**
     * 根据查询条件获取会议列表
     * @param cnd
     * @return
     */
    Result<MeetViewVO> getMeetList(String personId, MeetQueryCnd cnd);

    /**
     * 会议发放参会证
     */
    void grantProve(String personId,Integer id);
}

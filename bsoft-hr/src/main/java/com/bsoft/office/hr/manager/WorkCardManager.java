package com.bsoft.office.hr.manager;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.office.hr.condition.WorkCardQueryCnd;
import com.bsoft.office.hr.vo.WorkCardDateCountVO;
import com.bsoft.office.hr.vo.WorkCardViewVO;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/16 9:55
 * @Description
 */
public interface WorkCardManager {
    List<WorkCardDateCountVO> getDateList();

    Result<WorkCardViewVO> getWorkCardList(WorkCardQueryCnd cnd);

    Result<WorkCardViewVO> getWorkCardMakeList(WorkCardQueryCnd cnd);

    Result<WorkCardViewVO> getWorkCardOpenAccessList(WorkCardQueryCnd cnd);

    Double getPersonWorkCardAmount(Integer personType, Date startDate);

    Integer getWorkCardVerifyCount(WorkCardQueryCnd cnd);

    Integer getWorkCardReceiveCount(WorkCardQueryCnd cnd);

    Integer getWorkCardMakeCount(WorkCardQueryCnd cnd);

    Integer getWorkCardOpenAccessCount(WorkCardQueryCnd cnd);

    void verifyWorkCard(WorkCardViewVO workCardViewVO);

    void openAccessWorkCard(WorkCardViewVO workCardViewVO);

    void makeWorkCard(WorkCardViewVO workCardViewVO);

    void receiveWorkCard(String personId);

    List<FileServerDefinitionDTO> getPersonalImageFiles(List<WorkCardViewVO> persons);

    void updateOneInchPhoto(Integer fileId, Integer recruitmentId);

    void batchReceiveWorkCard(List<String> personIds);

    List<WorkCardViewVO> getWorkCardNeedMakingList(List<String> personIds);
}

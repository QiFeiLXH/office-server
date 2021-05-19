package com.bsoft.office.work.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.work.condition.MeetPersonQueryCnd;
import com.bsoft.office.work.vo.MeetPersonExcelErrorVO;
import com.bsoft.office.work.vo.MeetPersonExcelVO;
import com.bsoft.office.work.vo.MeetPersonVO;
import com.bsoft.work.dto.MeetPersonDTO;
import com.bsoft.work.dto.MeetPersonQueryCndDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:39
 * @Version 1.0
 */
public interface MeetPersonManager {
    void saveMeetPerson(String personId, MeetPersonVO meetPerson);

    void deleteMeetPerson(String personId,Integer id);

    Result<MeetPersonVO> getMeetPersons(String personId, MeetPersonQueryCnd cnd);

    ImportResultVO importMeetPersonData(String personId,List<MeetPersonExcelVO> importVOList,Integer meetId);

    /**
     * 导出错误数据
     * @param personId 操作人工号
     * @return 错误数据列表
     */
    List<MeetPersonExcelErrorVO> exportErrorData(String personId);

    String havePersonExits(String personId,MeetPersonVO meetPerson);

    /**
     * 判断该人员是否已存在对应会议中
     * @return
     */
    Boolean personExitsMeet(String personId,MeetPersonVO meetPerson);
}

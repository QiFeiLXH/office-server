package com.bsoft.office.hr.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.hr.condition.PersonalTrainQueryCnd;
import com.bsoft.office.hr.condition.TrainKnowledgeQueryCnd;
import com.bsoft.office.hr.vo.PersonalTrainVO;
import com.bsoft.office.hr.vo.TrainKnowledgeLearnViewVO;
import com.bsoft.office.hr.vo.TrainKnowledgeShareViewVO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 14:24
 * @Description
 */
public interface TrainManager {
    Result<TrainKnowledgeLearnViewVO> getKnowledgeLearnList(TrainKnowledgeQueryCnd trainKnowledgeQueryCnd);

    Result<TrainKnowledgeShareViewVO> getKnowledgeShareList(TrainKnowledgeQueryCnd trainKnowledgeQueryCnd);

    List<TrainKnowledgeLearnViewVO> getErrorLearnList(String personId);

    List<TrainKnowledgeShareViewVO> getErrorShareList(String personId);

    void deleteBatchLearnList(List<Integer> deletes);

    void deleteBatchShareList(List<Integer> deletes);

    ImportResultVO importKnowledgeLearnData(List<TrainKnowledgeLearnViewVO> list, String personId);

    ImportResultVO importKnowledgeShareData(List<TrainKnowledgeShareViewVO> list, String personId);

    Result<PersonalTrainVO> getPersonalTrainList(PersonalTrainQueryCnd cnd);
}

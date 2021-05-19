package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.WorkCardDTO;
import com.bsoft.hr.dto.WorkCardDateCountDTO;
import com.bsoft.hr.dto.WorkCardQueryCndDTO;
import com.bsoft.hr.service.WorkCardService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.FilePublicManager;
import com.bsoft.office.common.utils.FileUtils;
import com.bsoft.office.hr.condition.WorkCardQueryCnd;
import com.bsoft.office.hr.manager.WorkCardManager;
import com.bsoft.office.hr.vo.WorkCardDateCountVO;
import com.bsoft.office.hr.vo.WorkCardViewVO;
import com.bsoft.person.service.EmployService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/16 9:55
 * @Description
 */
@Service
public class WorkCardManagerImpl implements WorkCardManager {
    @Reference(timeout = 60000)
    private WorkCardService workCardService;
    @Reference
    private EmployService employService;
    @Autowired
    private FilePublicManager filePublicManager;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<WorkCardDateCountVO> getDateList() {
        List<WorkCardDateCountDTO> list = workCardService.getDateList();
        return iGenerator.convert(list, WorkCardDateCountVO.class);
    }

    @Override
    public Result<WorkCardViewVO> getWorkCardList(WorkCardQueryCnd cnd) {
        WorkCardQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkCardQueryCndDTO.class);
        Result<WorkCardDTO> result = workCardService.getWorkCardList(cndDTO);
        return iGenerator.convert(result, WorkCardViewVO.class);
    }

    @Override
    public Result<WorkCardViewVO> getWorkCardMakeList(WorkCardQueryCnd cnd) {
        WorkCardQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkCardQueryCndDTO.class);
        Result<WorkCardDTO> result = workCardService.getWorkCardMakeList(cndDTO);
        return iGenerator.convert(result, WorkCardViewVO.class);
    }

    @Override
    public Result<WorkCardViewVO> getWorkCardOpenAccessList(WorkCardQueryCnd cnd) {
        WorkCardQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkCardQueryCndDTO.class);
        Result<WorkCardDTO> result = workCardService.getWorkCardOpenAccessList(cndDTO);
        return iGenerator.convert(result, WorkCardViewVO.class);
    }

    @Override
    public Double getPersonWorkCardAmount(Integer personType, Date startDate) {
        return workCardService.getPersonWorkCardAmount(personType, startDate);
    }

    @Override
    public Integer getWorkCardVerifyCount(WorkCardQueryCnd cnd) {
        WorkCardQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkCardQueryCndDTO.class);
        return workCardService.getWorkCardVerifyCount(cndDTO);
    }

    @Override
    public Integer getWorkCardReceiveCount(WorkCardQueryCnd cnd) {
        WorkCardQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkCardQueryCndDTO.class);
        return workCardService.getWorkCardReceiveCount(cndDTO);
    }

    @Override
    public Integer getWorkCardMakeCount(WorkCardQueryCnd cnd) {
        WorkCardQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkCardQueryCndDTO.class);
        return workCardService.getWorkCardMakeCount(cndDTO);
    }

    @Override
    public Integer getWorkCardOpenAccessCount(WorkCardQueryCnd cnd) {
        WorkCardQueryCndDTO cndDTO = iGenerator.convert(cnd, WorkCardQueryCndDTO.class);
        return workCardService.getWorkCardOpenAccessCount(cndDTO);
    }

    @Override
    public void verifyWorkCard(WorkCardViewVO workCardViewVO) {
        WorkCardDTO workCardDTO = iGenerator.convert(workCardViewVO, WorkCardDTO.class);
        workCardService.verifyWorkCard(workCardDTO);
    }

    @Override
    public void openAccessWorkCard(WorkCardViewVO workCardViewVO) {
        WorkCardDTO workCardDTO = iGenerator.convert(workCardViewVO, WorkCardDTO.class);
        workCardService.openAccessWorkCard(workCardDTO);
    }

    @Override
    public void makeWorkCard(WorkCardViewVO workCardViewVO) {
        WorkCardDTO workCardDTO = iGenerator.convert(workCardViewVO, WorkCardDTO.class);
        workCardService.makeWorkCard(workCardDTO);
    }

    @Override
    public void receiveWorkCard(String personId) {
        workCardService.receiveWorkCard(personId);
    }

    @Override
    public List<FileServerDefinitionDTO> getPersonalImageFiles(List<WorkCardViewVO> persons) {
        List<FileServerDefinitionDTO> images = new ArrayList<>();
        persons.forEach(person -> {
            if (person.getOneInchPhoto() != null) {
                FileServerDefinitionDTO image = filePublicManager.downloadFile(person.getOneInchPhoto());
                String fileName = person.getPersonId() + " & " + person.getPersonName() + "." + FileUtils.getFileSuffix(image.getFileName());
                image.setFileName(fileName);
                images.add(image);
            }

        });
        return images;
    }

    @Override
    public void updateOneInchPhoto(Integer fileId, Integer recruitmentId) {
        employService.updateOneInchPhoto(fileId,recruitmentId);
    }

    @Override
    public void batchReceiveWorkCard(List<String> personIds) {
        workCardService.batchReceiveWorkCard(personIds);
    }

    @Override
    public List<WorkCardViewVO> getWorkCardNeedMakingList(List<String> personIds) {
        List<WorkCardDTO> workCardDTOS = workCardService.getWorkCardNeedMakingList(personIds);
        List<WorkCardViewVO> workCards = iGenerator.convert(workCardDTOS, WorkCardViewVO.class);
        processWorkCardAccess(workCards);
        return workCards;
    }

    // 楼层处理，连续的楼层以连接符连接
    private void processWorkCardAccess(List<WorkCardViewVO> workCards) {
        if (workCards != null && !workCards.isEmpty()) {
            workCards.forEach(workCard -> {
                List<String> accessArray = new ArrayList<>();
                String[] accessControlArray = workCard.getAccessControl().split(",");
                List<Integer> accessControlList = Arrays.asList(accessControlArray).stream().map(i -> Integer.valueOf(i)).sorted().collect(Collectors.toList());
                Integer head = accessControlList.get(0);
                Integer tail = accessControlList.get(0);
                for (Integer item : accessControlList) {
                    if (item - tail <= 1) {
                        tail = item;
                    } else {
                        String index = null;
                        if (head == tail) {
                            index = head + "楼";
                        } else {
                            index = head + "楼-" + tail + "楼";
                        }
                        accessArray.add(index);
                        head = item;
                        tail = item;
                    }
                }
                String lastEl = null;
                if (head == tail) {
                    lastEl = head + "楼";
                } else {
                    lastEl = head + "楼-" + tail + "楼";
                }
                accessArray.add(lastEl);
                String accessControl = accessArray.stream().collect(Collectors.joining(","));
                workCard.setAccessControl(accessControl);
                workCard.setAccessControlStr(accessControl);
            });
        }
    }
}

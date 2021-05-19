package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.AccountCaliberDTO;
import com.bsoft.cost.service.AccountCaliberService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.manager.CommunicationSubsidyManager;
import com.bsoft.office.common.manager.HumanDicManager;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.sort.ListBeanSort;
import com.bsoft.office.common.vo.CommunicationSubsidyVO;
import com.bsoft.office.common.vo.HumanDicVO;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.hr.condition.PersonTransferConditionQueryCndVO;
import com.bsoft.office.hr.manager.PersonTransferManager;
import com.bsoft.office.hr.vo.PersonTransferConditionVO;
import com.bsoft.office.hr.vo.PersonTransferDicVO;
import com.bsoft.office.hr.vo.PersonTransferQueryCndVO;
import com.bsoft.office.hr.vo.PersonTransferVO;
import com.bsoft.person.dto.PersonTransferConditionDTO;
import com.bsoft.person.dto.PersonTransferDTO;
import com.bsoft.person.dto.PersonTransferQueryCndDTO;
import com.bsoft.person.service.PersonService;
import com.bsoft.person.service.PersonTransferService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:13
 * @Description:
 */

@Component
public class PersonTransferManagerImpl implements PersonTransferManager {
    @Reference
    private PersonTransferService personTransferService;
    @Autowired
    private HumanDicManager humanDicManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private CommunicationSubsidyManager communicationSubsidyManager;
    @Autowired
    private AccountCaliberService accountCaliberService;
    @Reference(timeout = 60000)
    private PersonService personService;
    @Autowired
    private IGenerator iGenerator;

    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<PersonTransferVO> findPersonTransfer(PersonTransferQueryCndVO cndVO) {
        PersonTransferQueryCndDTO cndDTO = generatorUtil.convert(cndVO,PersonTransferQueryCndDTO.class);
        Result<PersonTransferDTO> result = personTransferService.findPersonTransfer(cndDTO);
        return generatorUtil.convert(result,PersonTransferVO.class);
    }

    @Override
    public PersonTransferDicVO getAllDic() {
        List<HumanDicVO> postDic = generatorUtil.convert(humanDicManager.getHumanDic(14),HumanDicVO.class);
        List<HumanDicVO> jobCategoryDic = generatorUtil.convert(humanDicManager.getHumanDic(2),HumanDicVO.class);
        List<PublicDicVO> personnelGroupDic = generatorUtil.convert(publicDicManager.getPublicDics(3505),PublicDicVO.class);
        List<CommunicationSubsidyVO> communicationSubsidyDic = communicationSubsidyManager.getCommunicationSubsidy();
        PersonTransferDicVO personTransferDicVO = new PersonTransferDicVO();
        personTransferDicVO.setPostDic(postDic);
        personTransferDicVO.setJobCategoryDic(jobCategoryDic);
        personTransferDicVO.setPersonnelGroupDic(personnelGroupDic);
        personTransferDicVO.setCommunicationSubsidyDic(communicationSubsidyDic);
        return personTransferDicVO;
    }

    @Override
    public void savePersonTransfer(List<PersonTransferVO> personTransferVOS, String personId) {
        List<PersonTransferDTO> personTransferDTOS = generatorUtil.convert(personTransferVOS,PersonTransferDTO.class);
        personTransferService.savePersonTransfer(personTransferDTOS,personId);
    }

    @Override
    public List<PublicDicVO> getPersonnelGroupDic(String deptId, Integer year) {
        List<AccountCaliberDTO> accountCaliberDTOList = accountCaliberService.getAccountCaliberByDeptId(deptId,year);
        List<PublicDicVO> publicDicVOS = new ArrayList<>();
        for(AccountCaliberDTO accountCaliberDTO:accountCaliberDTOList){
            PublicDicVO publicDicVO = new PublicDicVO();
            publicDicVO.setId(Integer.valueOf(accountCaliberDTO.getAccountCalibers()));
            publicDicVO.setName(accountCaliberDTO.getAccountCaliberNames());
            publicDicVO.setType(3505);
            publicDicVOS.add(publicDicVO);
        }
        ListBeanSort.sort(publicDicVOS,"id",true);
        return publicDicVOS;
    }

    @Override
    public Result<PersonTransferConditionVO> getPersonTransferCondition(PersonTransferConditionQueryCndVO cndVO) {
        PersonTransferQueryCndDTO convert = iGenerator.convert(cndVO, PersonTransferQueryCndDTO.class);
        Result<PersonTransferConditionDTO> personTransfer = null;
        try {
            personTransfer = personService.getPersonTransfer(convert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        return personTransfer.setItems(iGenerator.convert(personTransfer.getItems(),PersonTransferConditionVO.class));
         return iGenerator.convert(personTransfer,PersonTransferConditionVO.class);
    }

    @Override
    public List<PersonTransferConditionVO> getExcelPersonTransferCondition(PersonTransferConditionQueryCndVO cndVO) {
        PersonTransferQueryCndDTO convert = iGenerator.convert(cndVO, PersonTransferQueryCndDTO.class);
        List<PersonTransferConditionDTO> personTransfer = null;
        try {
            personTransfer = personService.getExcelPersonTransfer(convert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return iGenerator.convert(personTransfer,PersonTransferConditionVO.class);
    }
}

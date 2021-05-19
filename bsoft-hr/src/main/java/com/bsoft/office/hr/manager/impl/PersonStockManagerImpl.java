package com.bsoft.office.hr.manager.impl;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.hr.dto.PersonStockDTO;
import com.bsoft.hr.dto.PersonStockQueryCndDTO;
import com.bsoft.hr.service.PersonStockService;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.exportExcel.ImportResultVO;
import com.bsoft.office.hr.condition.PersonStockQueryCnd;
import com.bsoft.office.hr.manager.PersonStockManager;
import com.bsoft.office.hr.vo.PersonStockErrorTemplateVO;
import com.bsoft.office.hr.vo.PersonStockTemplateVO;
import com.bsoft.office.hr.vo.PersonStockViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 10:16
 * @Description
 */
@Component
public class PersonStockManagerImpl implements PersonStockManager {
    @Reference(timeout = 60000)
    private PersonStockService personStockService;
    @Reference
    private ServerDateService serverDateService;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<PersonStockViewVO> getPersonStockList(PersonStockQueryCnd cnd) {
        PersonStockQueryCndDTO cndDTO = iGenerator.convert(cnd, PersonStockQueryCndDTO.class);
        Result<PersonStockDTO> result = personStockService.getPersonStockList(cndDTO);
        return iGenerator.convert(result, PersonStockViewVO.class);
    }

    @Override
    public void logoutOnePersonStock(Integer id) {
        personStockService.logoutOnePersonStock(id);
    }

    @Override
    public void batchLogoutPersonStocks(List<Integer> ids) {
        personStockService.batchLogoutPersonStocks(ids);
    }

    @Override
    public void savePersonStock(PersonStockViewVO personStock) {
        PersonStockDTO personStockDTO = iGenerator.convert(personStock, PersonStockDTO.class);
        personStockService.savePersonStock(personStockDTO);
    }

    @Override
    public ImportResultVO importPersonStockData(List<PersonStockTemplateVO> personStocks, String personId) {
        Date serverDate = serverDateService.getServerDate();
        personStocks.forEach(personStock -> {
            personStock.setRegister(personId);
            personStock.setRegisterDate(serverDate);
        });

        List<PersonStockDTO> list = iGenerator.convert(personStocks, PersonStockDTO.class);
        ImportResultDTO result = personStockService.savePersonStocks(list, personId);
        return iGenerator.convert(result, ImportResultVO.class);
    }

    @Override
    public List<PersonStockErrorTemplateVO> getErrorPersonStockList(String personId) {
        List<PersonStockDTO> list = personStockService.getErrorPersonStockList(personId);
        return iGenerator.convert(list, PersonStockErrorTemplateVO.class);
    }

    @Override
    public List<PersonStockViewVO> getAllPersonStockList(PersonStockQueryCnd cnd) {
        PersonStockQueryCndDTO cndDTO = iGenerator.convert(cnd, PersonStockQueryCndDTO.class);
        List<PersonStockDTO> list = personStockService.getAllPersonStockList(cndDTO);
        return iGenerator.convert(list, PersonStockViewVO.class);
    }
}

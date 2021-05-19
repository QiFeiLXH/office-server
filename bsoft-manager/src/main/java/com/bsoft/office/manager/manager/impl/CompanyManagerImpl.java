package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.dto.CompanyViewDTO;
import com.bsoft.common.service.CompanyService;
import com.bsoft.office.common.dozer.GeneratorUtil;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.sort.ListBeanSort;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.manager.CompanyManager;
import com.bsoft.office.manager.vo.CompanyViewVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 11:13
 * @Description:
 */
@Component
public class CompanyManagerImpl implements CompanyManager {

    @Autowired
    private PublicDicManager publicDicManager;
    @Reference
    private CompanyService companyService;
    @Autowired
    private GeneratorUtil generatorUtil;

    //获取所有分子公司
    @Override
    public List<CompanyViewVO> getCompanyList() {
        List<CompanyViewDTO> list = companyService.getAllCompany();
        List<CompanyViewVO> companyViewVOS = generatorUtil.convert(list,CompanyViewVO.class);
        List<CompanyViewVO> root = companyViewVOS.stream().filter(s->s.getParentCompanyId().equals(0)).collect(Collectors.toList());
        root.forEach(CompanyViewVO->{
            List<CompanyViewVO> child = companyViewVOS.stream().filter(s->s.getParentCompanyId().equals(CompanyViewVO.getCompanyId())).collect(Collectors.toList());
            if (child.size() > 0){
                CompanyViewVO.setChildren(child);
                child.forEach(childCompanyViewVO->{
                    generCompanyTree(childCompanyViewVO,companyViewVOS);
                });
            }
        });
        return root;
    }

    private void generCompanyTree(CompanyViewVO parent,List<CompanyViewVO> all){
        List<CompanyViewVO> child = all.stream().filter(s->s.getParentCompanyId().equals(parent.getCompanyId())).collect(Collectors.toList());
        if (child.size() > 0){
            parent.setChildren(child);
            child.forEach(CompanyViewVO->{
                generCompanyTree(CompanyViewVO,all);
            });
        }
    }

    //保存、更新分子公司
    @Override
    public CompanyViewVO saveCompany(CompanyViewVO companyViewVO) {
        CompanyViewDTO companyViewDTO = generatorUtil.convert(companyViewVO,CompanyViewDTO.class);
        Integer companyId = companyService.saveCompany(companyViewDTO);
        CompanyViewDTO companyViewDTO1 = companyService.getCompanyById(companyId);
        return generatorUtil.convert(companyViewDTO1,CompanyViewVO.class);
    }

    //获取分子公司用途字典
    @Override
    public List<PublicDicVO> getPurposeList() {
        return publicDicManager.getPublicDics(9912);
    }

    //获取详细分子公司信息
    @Override
    public CompanyViewVO getCompany(Integer id) {
        CompanyViewDTO companyViewDTO = companyService.getCompanyById(id);
        return generatorUtil.convert(companyViewDTO,CompanyViewVO.class);
    }

    @Override
    public List<CompanyViewVO> getNotCancelledCompany() {
        List<CompanyViewDTO> list = companyService.getNotCancelledCompany();
        List<CompanyViewVO> companyViewVOS = generatorUtil.convert(list,CompanyViewVO.class);
        List<CompanyViewVO> root = companyViewVOS.stream().filter(s->s.getParentCompanyId().equals(0)).collect(Collectors.toList());
        root.forEach(CompanyViewVO->{
            List<CompanyViewVO> child = companyViewVOS.stream().filter(s->s.getParentCompanyId().equals(CompanyViewVO.getCompanyId())).collect(Collectors.toList());
            if (child.size() > 0){
                CompanyViewVO.setChildren(child);
                child.forEach(childCompanyViewVO->{
                    generCompanyTree(childCompanyViewVO,companyViewVOS);
                });
            }
        });
        return root;
    }

    @Override
    public void doCancle(Integer companyId) {
        companyService.cancelCompany(companyId);
    }
}

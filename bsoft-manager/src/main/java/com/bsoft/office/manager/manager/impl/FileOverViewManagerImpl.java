package com.bsoft.office.manager.manager.impl;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.common.service.FileServerService;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.menu.dto.MenuDTO;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.common.jsonutil.JSONUtils;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.FileOverViewQueryCnd;
import com.bsoft.office.manager.manager.FileOverViewManager;
import com.bsoft.office.manager.vo.FileMenuVO;
import com.bsoft.office.manager.vo.FileRecordVO;
import com.bsoft.word.dto.WordFileRecordDTO;
import com.bsoft.word.dto.WordFileRecordQueryCndDTO;
import com.bsoft.word.service.WordFileRecordService;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Component
public class FileOverViewManagerImpl implements FileOverViewManager {

    private static final Logger logger = LoggerFactory.getLogger(FileOverViewManagerImpl.class);
    @Reference(timeout = 10000)
    private WordFileRecordService wordFileRecordService;
    @Reference(timeout = 10000)
    private FileServerService fileServerService;
    @Reference
    private PublicDicService publicDicService;
    @Autowired
    private IGenerator generatorUtil;

    public List<FileMenuVO> getFileMenuTree(String userId, Integer systemid) {
        List<MenuDTO> menuDTOS = wordFileRecordService.getFileMenu(userId);
        List<FileMenuVO> fileMenuVOS = new ArrayList<FileMenuVO>();
        for(int i=0; i<menuDTOS.size(); i++){
            MenuDTO menuDTO = menuDTOS.get(i);
            if(menuDTO.getSystem() == systemid){
                FileMenuVO fileMenuVO = new FileMenuVO();
                fileMenuVO.setId(menuDTO.getId());
                fileMenuVO.setRoutetitle(menuDTO.getName());
                fileMenuVO.setParentId(menuDTO.getParentId());
                fileMenuVO.setSort(menuDTO.getSort());
                fileMenuVO.setIcon(menuDTO.getIcon());
                fileMenuVO.setPath(menuDTO.getObject());
                fileMenuVO.setComponent(menuDTO.getComponent());
                fileMenuVO.setName(menuDTO.getPermisionid());
                fileMenuVO.setActive(menuDTO.getActive());
                fileMenuVO.setPubFlag(menuDTO.getPubFlag());
                fileMenuVO.setSystem(menuDTO.getSystem());
                fileMenuVOS.add(fileMenuVO);
            }
        }

        List<FileMenuVO> fileMenuVOList1 = new ArrayList<FileMenuVO>();
        Collection<FileMenuVO> result = Collections2.filter(fileMenuVOS, x->x.getParentId().equals(0));
        List<FileMenuVO> fileMenuVOList2 = new ArrayList<FileMenuVO>(result);
        fileMenuVOList1.addAll(fileMenuVOList2);

        this.processMenu(fileMenuVOS,fileMenuVOList1);
        return fileMenuVOList1;
    }

    @Override
    public List<PublicDicVO> getSystemList() {
        List<PublicDicDTO> result = publicDicService.getPublicDicWithFlag(9908, 1);
        return generatorUtil.convert(result, PublicDicVO.class);
    }

    @Override
    public List<PublicDicVO> getFileTypeList() {
        List<PublicDicDTO> result = publicDicService.getPublicDic(2002);
        return generatorUtil.convert(result, PublicDicVO.class);
    }

    @Override
    public Result<FileRecordVO> getYearFolderList(String userId, FileOverViewQueryCnd queryCnd) {
        WordFileRecordQueryCndDTO queryCndDTO = generatorUtil.convert(queryCnd, WordFileRecordQueryCndDTO.class);
        Result<WordFileRecordDTO> resultDTO = wordFileRecordService.getYearMenu(userId, queryCndDTO);
        Result<FileRecordVO> resultVO = generatorUtil.convert(resultDTO, FileRecordVO.class);
        resultVO.setItems(this.processYearMenu(resultDTO.getItems(), queryCnd.getMenuId()));
        return resultVO;
    }

    @Override
    public Result<FileRecordVO> getMonthFolderList(String userId, FileOverViewQueryCnd queryCnd) {
        WordFileRecordQueryCndDTO queryCndDTO = generatorUtil.convert(queryCnd, WordFileRecordQueryCndDTO.class);
        Result<WordFileRecordDTO> resultDTO = wordFileRecordService.getMonthMenu(userId, queryCndDTO);
        Result<FileRecordVO> resultVO = generatorUtil.convert(resultDTO, FileRecordVO.class);
        resultVO.setItems(this.processMonthMenu(resultDTO.getItems(), queryCnd.getMenuId(), queryCnd.getFileYear()));
        return resultVO;
    }

    @Override
    public Result<FileRecordVO> getFileList(String userId, FileOverViewQueryCnd queryCnd) {
        WordFileRecordQueryCndDTO queryCndDTO = generatorUtil.convert(queryCnd, WordFileRecordQueryCndDTO.class);
        Result<WordFileRecordDTO> resultDTO= wordFileRecordService.getFileList(userId, queryCndDTO);
        Result<FileRecordVO> resultVO = generatorUtil.convert(resultDTO, FileRecordVO.class);
        resultVO.setItems(this.processFileType(resultVO.getItems()));
        return resultVO;
    }

    @Override
    public OfficeResopnseBean removeFile(String userId, Integer id) {
        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();
        try{
            wordFileRecordService.removeFile(userId, id);
            responseBean.setMsg("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("删除失败!");
            return responseBean;
        }
        return responseBean;
    }

    @Override
    public OfficeResopnseBean changeFile(String userId, MultipartFile file,Integer id) throws Exception{

        OfficeResopnseBean responseBean = OfficeResopnseBean.newSuccessBean();

        // 获取文件名
        String originalFilename = this.getOriginalFileName(file);
        // 控制文件格式
        List<PublicDicDTO> fileUploadTypes = wordFileRecordService.getFileUploadType(userId);
        String format = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        boolean check = false;
        for (PublicDicDTO uploadType : fileUploadTypes) {
            if(format.equals(uploadType.getName())){
                check = true;
                break;
            }
        }
        if (!check) {
            responseBean.setCode(500);
            responseBean.setMsg("文件类型不合要求！");
            return responseBean;
        }

        WordFileRecordDTO wordFileRecordDTO = new WordFileRecordDTO();
        wordFileRecordDTO.setId(id);
        wordFileRecordDTO.setFileName(originalFilename);
        Long size = file.getSize();
        wordFileRecordDTO.setSize(size.doubleValue() / 1024 / 1024);
        wordFileRecordDTO.setData(file.getBytes());
        logger.info("修改文件[{}]", JSONUtils.toString(wordFileRecordDTO));
        try{
            wordFileRecordService.changeFile(userId, wordFileRecordDTO);
            responseBean.setMsg("重传成功!");
        }catch (Exception e){
            e.printStackTrace();
            responseBean.setCode(500);
            responseBean.setMsg("重传失败!");
            return responseBean;
        }
        return responseBean;
    }

    @Override
    public FileRecordVO downloadFile(Integer id) {
        FileServerDefinitionDTO fileServerDefinitionDTO = fileServerService.get(id);
        logger.info("下载文件[{}]", JSONUtils.toString(fileServerDefinitionDTO));
        return generatorUtil.convert(fileServerDefinitionDTO, FileRecordVO.class);
    }

    /**
     * 格式化树形菜单结构
     */
    private void processMenu(List<FileMenuVO> menus,List<FileMenuVO> parentList){
        for (int j = 0;j<parentList.size();j++){
            Integer parentId = parentList.get(j).getId();
            Collection<FileMenuVO> result = Collections2.filter(menus, x->x.getParentId().equals(parentId));
            if (result.size()>0){
                List<FileMenuVO> resultList = new ArrayList<>(result);
                parentList.get(j).setChildren(resultList);
                this.processMenu(menus,resultList);
            }
        }
    }

    /**
     * 处理年份菜单列表
     */
    private List<FileRecordVO> processYearMenu(List<WordFileRecordDTO> yearMenu, Integer menuId){
        List<FileRecordVO> resultYearMenu = new ArrayList<>();
        for(WordFileRecordDTO menu : yearMenu){
            FileRecordVO fileRecordVO = new FileRecordVO();
            fileRecordVO.setId(menu.getFileYear());
            fileRecordVO.setFileName(menu.getFileYear().toString().concat("年"));
            fileRecordVO.setFileYear(menu.getFileYear());
            fileRecordVO.setMenuId(menuId);
            fileRecordVO.setFileType("folder");
            resultYearMenu.add(fileRecordVO);
        }
        return resultYearMenu;
    }

    /**
     * 处理月份菜单列表
     */
    private List<FileRecordVO> processMonthMenu(List<WordFileRecordDTO> monthMenu, Integer menuId, Integer fileYear){
        List<FileRecordVO> resultMenu = new ArrayList<>();
        for(WordFileRecordDTO menu : monthMenu){
            FileRecordVO fileRecordVO = new FileRecordVO();
            fileRecordVO.setId(menu.getFileMonth());
            fileRecordVO.setFileName(menu.getFileMonth().toString().concat("月"));
            fileRecordVO.setFileYear(fileYear);
            fileRecordVO.setFileMonth(menu.getFileMonth());
            fileRecordVO.setMenuId(menuId);
            fileRecordVO.setFileType("folder");
            resultMenu.add(fileRecordVO);
        }
        return resultMenu;
    }

    /**
     * 处理文件类型
     */
    private List<FileRecordVO> processFileType(List<FileRecordVO> fileRecordVOS) {
        List<FileRecordVO> result = new ArrayList<>();
        fileRecordVOS.forEach(vo -> {
            String name = vo.getFileName();
            String type = name.substring(name.lastIndexOf(".") + 1);
            if(StringUtils.isNotBlank(type)){
                vo.setFileType(type);
            }else{
                vo.setFileType("unknown");
            }
            result.add(vo);
        });
        return result;
    }

    /**
     * 获取文件名
     */
    private String getOriginalFileName(MultipartFile file){
        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        //判断是否为IE浏览器的文件名，IE浏览器下文件名会带有盘符信息
        // Check for Unix-style path
        int unixSep = originalFilename.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = originalFilename.lastIndexOf('\\');
        int pos = Math.max(winSep, unixSep);
        if (pos != -1)  {
            originalFilename = originalFilename.substring(pos + 1);
        }
        return originalFilename;
    }


}

package com.bsoft.office.manager.controller;

import com.bsoft.common.dto.FileServerDefinitionDTO;
import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.annotation.OperLog;
import com.bsoft.office.common.annotation.RequiredExportLog;
import com.bsoft.office.common.condition.ExportLogParams;
import com.bsoft.office.common.manager.PublicDicManager;
import com.bsoft.office.common.operLog.OperLogType;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.manager.MenuAuthManager;
import com.bsoft.office.manager.vo.MenuAndAuthVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/10/19 9:56
 * @Description: 新权限管理系统菜单管理
 */
@RestController
@RequestMapping(value = "/menumanager")
public class MenuAuthController {
    private static final Logger logger = LoggerFactory.getLogger(MenuAuthController.class);

    @Autowired
    private MenuAuthManager menuManager;
    @Autowired
    private PublicDicManager publicDicManager;

    @RequestMapping(value = "/systemlist",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取信息系统列表")
    public OfficeResopnseBean getSystemList(){
        List<PublicDicVO> list = publicDicManager.getPublicDicsWithFlag(9908,1);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/authrange",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "获取权限范围字典列表")
    public OfficeResopnseBean getAuthRangeList(){
        List<PublicDicVO> list = publicDicManager.getPublicDics(9911);
        return OfficeResopnseBean.newSuccessBean(list);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "根据系统获取菜单列表")
    public OfficeResopnseBean getMenuAuthBySystem(@RequestParam(value = "system") Integer system){
        List<MenuAndAuthVO> menuAndAuthVOList = menuManager.getMenuInfo(system);
        return OfficeResopnseBean.newSuccessBean(menuAndAuthVOList);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "禁用、删除菜单信息")
    public OfficeResopnseBean deleteMenu(@RequestParam(value = "menuId") Integer menuId,
                                         @RequestParam(value = "system") Integer system
                                        ){
        menuManager.deleteMenu(menuId,system);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @OperLog(operType = OperLogType.QUERY,operDesc = "查看菜单详情")
    public OfficeResopnseBean getMenuInfo(@RequestParam(value = "menuId") Integer menuId){
        MenuAndAuthVO menuAndAuthVO = menuManager.getMenuDetailInfo(menuId);
        return OfficeResopnseBean.newSuccessBean(menuAndAuthVO);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.SAVE,operDesc = "新增、修改菜单信息")
    public OfficeResopnseBean saveMenuInfo(@RequestBody MenuAndAuthVO menuAndAuthVO){
        Integer menuId = menuManager.saveMenuInfo(menuAndAuthVO);
        return OfficeResopnseBean.newSuccessBean(menuId);
    }

    @RequestMapping(value = "/fileupload",method = RequestMethod.POST)
    @OperLog(operType = OperLogType.UPLOAD,operDesc = "上传帮助文档")
    public OfficeResopnseBean fileupload(@RequestParam("file") MultipartFile file,
                                         @RequestParam("menuId") Integer menuId,
                                         @RequestParam("fileId") Integer fileId
    ){
        if (file.isEmpty()){
            throw new ServiceException("上传文件不能为空!");
        }
        Integer key = menuManager.uploadFile(file,menuId,fileId);
        return OfficeResopnseBean.newSuccessBean(key);
    }

    @RequestMapping(value = "/deletehelp",method = RequestMethod.DELETE)
    @OperLog(operType = OperLogType.DELETE,operDesc = "删除帮助文档")
    public OfficeResopnseBean deleteHelpWord(@RequestParam("fileId") Integer fileId){
        menuManager.deleteHelpWord(fileId);
        return OfficeResopnseBean.newSuccessBean();
    }

    @RequestMapping(value = "/helpdownload",method = RequestMethod.GET)
    @RequiredExportLog
    @OperLog(operType = OperLogType.DOWNLOAD,operDesc = "下载帮助文档")
    public void helpWordDownload(ExportLogParams params,Integer id, HttpServletResponse response){
        FileServerDefinitionDTO fileServerDefinitionDTO = menuManager.getHelpWord(id);
        ServletOutputStream sout = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentLength(fileServerDefinitionDTO.getData().length);
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileServerDefinitionDTO.getFileName(), "UTF-8"));
            sout = response.getOutputStream();
            bos = new BufferedOutputStream(sout);
            bos.write(fileServerDefinitionDTO.getData());
            logger.info("下载帮助文档成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

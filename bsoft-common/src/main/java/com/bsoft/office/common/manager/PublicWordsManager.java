package com.bsoft.office.common.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.common.vo.PublicWordsVO;
import com.bsoft.office.common.vo.PublicWordsViewVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/18 10:57
 * @Description
 */
public interface PublicWordsManager {

    /*** 获取上传文档的类型 ，eg: ppt,jpg,xls,etc...
     * @Param:
     * @return List<PublicDicVO>
     */
    List<PublicDicVO> getFileTypesDic();

    /*** 获取上传文档的类型 ，eg: ppt,jpg,xls,etc...
     * @Param: pageNo 页码
     * @Param: pageSize 单页条数
     * @Param: mainId 主表id
     * @Param: type 类别
     * @Param: key
     * @return Result<PublicWordsViewVO>
     */
    Result<PublicWordsViewVO> getPublicWordsList(Integer pageNo, Integer pageSize, Integer mainId, Integer type, Integer wordType);

    /*** 获取上传文档的类型 ，eg: ppt,jpg,xls,etc...
     * @Param: file 文件
     * @Param: mainId 主表id
     * @Param: menuId 菜单id
     * @Param: personId 工号
     * @Param: key
     * @return Result<PublicWordsViewVO>
     */
    void uploadFile(MultipartFile file, Integer mainId, Integer menuId, String personId, Integer wordType) throws IOException;

    /*** 文档下载
     * @Param: fileId 文档服务器文档id
     * @Param: wordId 中间表文档id
     * @Param: personId 工号
     * @return Result<PublicWordsViewVO>
     */
    PublicWordsVO downloadFile(Integer fileId, Integer wordId, String personId);

    /*** 删除文档
     * @Param: fileId 文档服务器文档id
     * @Param: wordId 中间表id
     * @return Result<PublicWordsViewVO>
     */
    void deleteFile(Integer fileId, Integer wordId);
}

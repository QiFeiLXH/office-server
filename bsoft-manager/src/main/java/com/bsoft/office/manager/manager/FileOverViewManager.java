package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.response.OfficeResopnseBean;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.FileOverViewQueryCnd;
import com.bsoft.office.manager.vo.FileMenuVO;
import com.bsoft.office.manager.vo.FileRecordVO;
import com.bsoft.word.dto.WordFileRecordQueryCndDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileOverViewManager {
    List<FileMenuVO> getFileMenuTree(String userId, Integer systemId);
    List<PublicDicVO> getSystemList();
    List<PublicDicVO> getFileTypeList();
    Result<FileRecordVO> getYearFolderList(String userId, FileOverViewQueryCnd queryCnd);
    Result<FileRecordVO> getMonthFolderList(String userId, FileOverViewQueryCnd queryCnd);
    Result<FileRecordVO> getFileList(String userId, FileOverViewQueryCnd queryCnd);
    OfficeResopnseBean removeFile(String userId, Integer id);
    OfficeResopnseBean changeFile(String userId, MultipartFile file, Integer id) throws Exception;
    FileRecordVO downloadFile(Integer id);
}

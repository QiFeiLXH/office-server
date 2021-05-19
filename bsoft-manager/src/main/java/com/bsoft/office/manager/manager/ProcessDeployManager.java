package com.bsoft.office.manager.manager;

import com.bsoft.common.result.Result;
import com.bsoft.office.common.vo.PublicDicVO;
import com.bsoft.office.manager.condition.ProcessDeployQueryCnd;
import com.bsoft.office.manager.vo.ProcessDeployVO;
import com.bsoft.office.manager.vo.ProcessFileVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProcessDeployManager {

    Result<ProcessDeployVO> getProcessDeployList(ProcessDeployQueryCnd cnd,String personId);

    List<PublicDicVO> getProcessDeployType();

    void saveProcessDeploy(ProcessDeployVO processDeployVO,String personId);

    Integer uploadProcessFile(MultipartFile file, Integer agreementId, Integer menuId, String personId) throws IOException;

    void deployProcess(Integer id,String personId);

}

package com.bsoft.office.system.managerImpl;

import com.bsoft.logs.dto.ExportLogDTO;
import com.bsoft.message.logs.ExportLogMessage;
import com.bsoft.office.common.dozer.IGenerator;
import com.bsoft.office.system.manager.ExportLogManager;
import com.bsoft.office.system.vo.ExportLogVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.system.managerImpl
 * @Author: Qi fei
 * @CreateTime: 2020-06-04 20:45
 * @Description:
 */
@Service
public class ExportLogManagerImpl implements ExportLogManager {
    @Reference
    private ExportLogMessage exportLogMessage;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public void saveExportLog(ExportLogVO exportLogVO) {
        ExportLogDTO exportLogDTO = iGenerator.convert(exportLogVO, ExportLogDTO.class);
        exportLogMessage.send(exportLogDTO);
    }
}

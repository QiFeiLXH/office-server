package com.bsoft.office.system.manager;

import com.bsoft.office.system.vo.ExportLogVO;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.system.manager
 * @Author: Qi fei
 * @CreateTime: 2020-06-04 20:44
 * @Description:
 */
public interface ExportLogManager {
    void saveExportLog(ExportLogVO exportLogVO);
}

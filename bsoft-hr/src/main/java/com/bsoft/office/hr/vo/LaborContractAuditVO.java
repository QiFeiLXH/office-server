package com.bsoft.office.hr.vo;

import com.bsoft.office.common.vo.TaskAuditVO;
import lombok.Data;

@Data
public class LaborContractAuditVO {
    private String processInstanceId;
    private Integer flag;
    private Integer id;
    private LaborContractApplyVO laborContractApplyVO;
    private TaskAuditVO taskAuditVO;
}

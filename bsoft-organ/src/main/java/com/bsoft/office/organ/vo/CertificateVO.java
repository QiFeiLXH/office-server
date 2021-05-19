package com.bsoft.office.organ.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

public class CertificateVO {
    private Integer id;
    @OperLogFieldName(value = "教育经历ID")
    private Integer educationId;
    @OperLogFieldName(value = "证书ID")
    private Integer certificateID;
    @OperLogFieldName(value = "开证书名称")
    private String certificateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Integer certificateID) {
        this.certificateID = certificateID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
}

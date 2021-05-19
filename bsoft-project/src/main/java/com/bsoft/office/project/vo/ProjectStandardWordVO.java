package com.bsoft.office.project.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;

/**
 * @Author zhanglf
 * @Date 2020-04-14 10:46
 * @Version 1.0
 * @Description
 */
public class ProjectStandardWordVO{
    @OperLogFieldName(value = "文档ID")
    private Integer fileKey; //文档ID wdid
    @OperLogFieldName(value = "工程阶段")
    private Integer stage; //工程阶段stage
    @OperLogFieldName(value = "管理分类")
    private Integer wordManageType; //管理分类 glfl
    @OperLogFieldName(value = "所属里程碑")
    private Integer milestone; //所属里程碑 sslcb
    @OperLogFieldName(value = "文档编号")
    private String fileNumber; //文档编号 wdbh
    @OperLogFieldName(value = "分工")
    private Integer submitRole; //分工 tjjs
    @OperLogFieldName(value = "类别")
    private Integer fileType; //类别 wdlb
    @OperLogFieldName(value = "文档名称")
    private String fileName; //文档名称 wdmc
    @OperLogFieldName(value = "提交要求 大")
    private Integer scaleLarge; //提交要求 大 tjyq_d
    @OperLogFieldName(value = "提交要求 中")
    private Integer scaleMiddle; //提交要求 中 tjyq_z
    @OperLogFieldName(value = "提交要求 小")
    private Integer scaleSmall; //提交要求 小 tjyq_x
    @OperLogFieldName(value = "提交要求 微")
    private Integer scaleTiny; //提交要求 微 tjyq_w
    @OperLogFieldName(value = "签章要求")
    private Integer signature; //签章要求 客户确认方式 qzyq
    @OperLogFieldName(value = "提交要求 是否必须")
    private Integer isRequired; //提交要求 是否必须 tjyq
    @OperLogFieldName(value = "参考文档")
    private String referenceTemplate; //参考文档 ckwd
    @OperLogFieldName(value = "注销标志")
    private Integer logoff; //注销标志 logoff
    @OperLogFieldName(value = "文档路径")
    private String path; //文档路径 path
    @OperLogFieldName(value = "序号")
    private Integer no; //序号 xh

    public Integer getFileKey() {
        return fileKey;
    }

    public void setFileKey(Integer fileKey) {
        this.fileKey = fileKey;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getWordManageType() {
        return wordManageType;
    }

    public void setWordManageType(Integer wordManageType) {
        this.wordManageType = wordManageType;
    }

    public Integer getMilestone() {
        return milestone;
    }

    public void setMilestone(Integer milestone) {
        this.milestone = milestone;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Integer getSubmitRole() {
        return submitRole;
    }

    public void setSubmitRole(Integer submitRole) {
        this.submitRole = submitRole;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getScaleLarge() {
        return scaleLarge;
    }

    public void setScaleLarge(Integer scaleLarge) {
        this.scaleLarge = scaleLarge;
    }

    public Integer getScaleMiddle() {
        return scaleMiddle;
    }

    public void setScaleMiddle(Integer scaleMiddle) {
        this.scaleMiddle = scaleMiddle;
    }

    public Integer getScaleSmall() {
        return scaleSmall;
    }

    public void setScaleSmall(Integer scaleSmall) {
        this.scaleSmall = scaleSmall;
    }

    public Integer getScaleTiny() {
        return scaleTiny;
    }

    public void setScaleTiny(Integer scaleTiny) {
        this.scaleTiny = scaleTiny;
    }

    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getReferenceTemplate() {
        return referenceTemplate;
    }

    public void setReferenceTemplate(String referenceTemplate) {
        this.referenceTemplate = referenceTemplate;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}

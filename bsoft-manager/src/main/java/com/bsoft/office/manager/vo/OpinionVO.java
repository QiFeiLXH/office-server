package com.bsoft.office.manager.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/8/5 15:25
 * @Description: 意见VO
 */
@ExcelIgnoreUnannotated
public class OpinionVO{
    @OperLogFieldName(value = "id")
    private Integer id;
    @OperLogFieldName(value = "系统ID")
    private Integer system;
    @ExcelProperty(value = "建议意见", index = 4)
    @OperLogFieldName(value = "建议意见")
    private String content;
    @OperLogFieldName(value = "图片路径")
    private String path;
    @OperLogFieldName(value = "提交人")
    private String submitter;
    @OperLogFieldName(value = "提交人部门")
    private String submitterDept;
    @OperLogFieldName(value = "提交时间")
    @ExcelProperty(value = "提交时间", index = 3)
    private Date submitDate;
    @OperLogFieldName(value = "状态")
    private Integer status;
    @OperLogFieldName(value = "反馈内容")
    @ExcelProperty(value = "反馈内容", index = 7)
    private String feedbackContent;
    @OperLogFieldName(value = "反馈时间")
    @ExcelProperty(value = "反馈时间", index = 8)
    private Date feedbackDate;
    @OperLogFieldName(value = "反馈人")
    private String feedbacker;
    @OperLogFieldName(value = "提交人姓名")
    @ExcelProperty(value = "提交人", index = 2)
    private String submitterText;
    @OperLogFieldName(value = "反馈人姓名")
    @ExcelProperty(value = "反馈人", index = 6)
    private String feedbackerText;
    @OperLogFieldName(value = "状态名称")
    @ExcelProperty(value = "状态", index = 5)
    private String statusText;
    @OperLogFieldName(value = "系统名称")
    @ExcelProperty(value = "系统", index = 0)
    private String systemText;
    @OperLogFieldName(value = "功能模块")
    @ExcelProperty(value = "功能模块", index = 1)
    private String feedbackModule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getSubmitterDept() {
        return submitterDept;
    }

    public void setSubmitterDept(String submitterDept) {
        this.submitterDept = submitterDept;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getFeedbacker() {
        return feedbacker;
    }

    public void setFeedbacker(String feedbacker) {
        this.feedbacker = feedbacker;
    }

    public String getSubmitterText() {
        return submitterText;
    }

    public void setSubmitterText(String submitterText) {
        this.submitterText = submitterText;
    }

    public String getFeedbackerText() {
        return feedbackerText;
    }

    public void setFeedbackerText(String feedbackerText) {
        this.feedbackerText = feedbackerText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getSystemText() {
        return systemText;
    }

    public void setSystemText(String systemText) {
        this.systemText = systemText;
    }

    public String getFeedbackModule() {
        return feedbackModule;
    }

    public void setFeedbackModule(String feedbackModule) {
        this.feedbackModule = feedbackModule;
    }
}

package com.bsoft.office.hr.vo;

import com.bsoft.office.common.annotation.OperLogFieldName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 15:48
 * @Description:
 */
public class PersonTurViewVO {
    @OperLogFieldName(value = "主键")
    private Integer id;
    @OperLogFieldName(value = "申请人工号")
    private String personId;//申请人
    @OperLogFieldName(value = "申请人姓名")
    private String personName;
    @OperLogFieldName(value = "申请日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date applyDate;//申请日期
    @OperLogFieldName(value = "所在部门代码")
    private String depno;//所在部门
    @OperLogFieldName(value = "所在部门名称")
    private String deptName;
    @OperLogFieldName(value = "帮带老师工号")
    private String teacherId;//帮带老师工号
    @OperLogFieldName(value = "帮带老师姓名")
    private String teacherName;
    @OperLogFieldName(value = "试用期结束日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;//试用期结束日期
    @OperLogFieldName(value = "转正岗位")
    private String post;//转正岗位
    @OperLogFieldName(value = "转正职级")
    private String rank;//转正职级
    @OperLogFieldName(value = "个人工作小结")
    private String workReport;//个人工作小结
    @OperLogFieldName(value = "导师评价")
    private String teacherEvaluation;//导师评价
    @OperLogFieldName(value = "导师胜任能力评价")
    private Integer teacherAbilityEvaluation;//导师胜任能力评价
    @OperLogFieldName(value = "部门评价")
    private String depEvaluation;//部门评价
    @OperLogFieldName(value = "部门胜任能力评价")
    private Integer competencyEvaluation;//部门胜任能力评价
    @OperLogFieldName(value = "考试方式")
    private String testMode;//考试方式
    @OperLogFieldName(value = "工作考核成绩")
    private Double workScore;//工作考核成绩
    @OperLogFieldName(value = "知识技能成绩")
    private Double knowledgeScore;//知识技能成绩
    @OperLogFieldName(value = "综合得分")
    private Double compositeScore;//综合得分
    @OperLogFieldName(value = "转正标志")
    private Integer correctionFlag;//转正标志
    @OperLogFieldName(value = "转正日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date correctionDate;//转正日期
    @OperLogFieldName(value = "流水号")
    private String lshid;//流水号
    @OperLogFieldName(value = "转正考试流水号")
    private String examLshid;//转正考试流水号
    @OperLogFieldName(value = "审批意见")
    private String approvalOpinion;//审批意见

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getWorkReport() {
        return workReport;
    }

    public void setWorkReport(String workReport) {
        this.workReport = workReport;
    }

    public String getTeacherEvaluation() {
        return teacherEvaluation;
    }

    public void setTeacherEvaluation(String teacherEvaluation) {
        this.teacherEvaluation = teacherEvaluation;
    }

    public Integer getTeacherAbilityEvaluation() {
        return teacherAbilityEvaluation;
    }

    public void setTeacherAbilityEvaluation(Integer teacherAbilityEvaluation) {
        this.teacherAbilityEvaluation = teacherAbilityEvaluation;
    }

    public String getDepEvaluation() {
        return depEvaluation;
    }

    public void setDepEvaluation(String depEvaluation) {
        this.depEvaluation = depEvaluation;
    }

    public Integer getCompetencyEvaluation() {
        return competencyEvaluation;
    }

    public void setCompetencyEvaluation(Integer competencyEvaluation) {
        this.competencyEvaluation = competencyEvaluation;
    }

    public String getTestMode() {
        return testMode;
    }

    public void setTestMode(String testMode) {
        this.testMode = testMode;
    }

    public Double getWorkScore() {
        return workScore;
    }

    public void setWorkScore(Double workScore) {
        this.workScore = workScore;
    }

    public Double getKnowledgeScore() {
        return knowledgeScore;
    }

    public void setKnowledgeScore(Double knowledgeScore) {
        this.knowledgeScore = knowledgeScore;
    }

    public Double getCompositeScore() {
        return compositeScore;
    }

    public void setCompositeScore(Double compositeScore) {
        this.compositeScore = compositeScore;
    }

    public Integer getCorrectionFlag() {
        return correctionFlag;
    }

    public void setCorrectionFlag(Integer correctionFlag) {
        this.correctionFlag = correctionFlag;
    }

    public Date getCorrectionDate() {
        return correctionDate;
    }

    public void setCorrectionDate(Date correctionDate) {
        this.correctionDate = correctionDate;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public String getExamLshid() {
        return examLshid;
    }

    public void setExamLshid(String examLshid) {
        this.examLshid = examLshid;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }
}

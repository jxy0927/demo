package com.example.demo.dao.entity;

import java.util.Date;

public class QuestionnaireEntity {
    private String id;
    private String projectId;
    private String projectName;
    private String questionnaireName;
    private String questionnaireContent;
    private String questionnaireType;
    private Date startTime;
    private Date stopTime;
    private String answer;
    private String questionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public String getQuestionnaireContent() {
        return questionnaireContent;
    }

    public void setQuestionnaireContent(String questionnaireContent) {
        this.questionnaireContent = questionnaireContent;
    }

    public String getQuestionnaireType() {
        return questionnaireType;
    }

    public void setQuestionnaireType(String questionnaireType) {
        this.questionnaireType = questionnaireType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "QuestionnaireEntity{" +
                "id='" + id + '\'' +
                ", projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", questionnaireName='" + questionnaireName + '\'' +
                ", questionnaireContent='" + questionnaireContent + '\'' +
                ", questionnaireType='" + questionnaireType + '\'' +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                ", answer='" + answer + '\'' +
                ", questionId='" + questionId + '\'' +
                '}';
    }
}

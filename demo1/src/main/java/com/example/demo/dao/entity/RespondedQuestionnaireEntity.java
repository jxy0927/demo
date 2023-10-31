package com.example.demo.dao.entity;

import java.util.Date;

public class RespondedQuestionnaireEntity {
    private String projectId;
    private String questionnaireName;
    private String respondent;
    private Date time;
    private String problemId;

    @Override
    public String toString() {
        return "RespondedQuestionnaireEntity{" +
                "projectId='" + projectId + '\'' +
                ", questionnaireName='" + questionnaireName + '\'' +
                ", respondent='" + respondent + '\'' +
                ", time=" + time +
                ", problemId='" + problemId + '\'' +
                '}';
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }
}


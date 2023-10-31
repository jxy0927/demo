package com.example.demo.dao.entity;

public class QuestionBankEntity {
    private String problemId;
    private String questionNumber;
    private String answerContent;
    private String status;

    @Override
    public String toString() {
        return "QuestionBank{" +
                "problemId='" + problemId + '\'' +
                ", questionNumber='" + questionNumber + '\'' +
                ", answerContent='" + answerContent + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

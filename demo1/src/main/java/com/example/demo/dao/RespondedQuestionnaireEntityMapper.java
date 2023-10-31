package com.example.demo.dao;

import com.example.demo.dao.entity.RespondedQuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RespondedQuestionnaireEntityMapper {
    List<RespondedQuestionnaireEntity> selectRespondedQuestionnaire(RespondedQuestionnaireEntity respondedQuestionnaireEntity);

    List<RespondedQuestionnaireEntity> selectRespondedQuestionnaireByName(RespondedQuestionnaireEntity respondedQuestionnaireEntity);
}


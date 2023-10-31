package com.example.demo.service;

import com.example.demo.dao.RespondedQuestionnaireEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.entity.RespondedQuestionnaireEntity;
import java.util.List;

@Service
public class RespondedQuestionnaireService {
    @Autowired
    private RespondedQuestionnaireEntityMapper respondedQuestionnaireEntityMapper;

    public List<RespondedQuestionnaireEntity> selectRespondedQuestionnaire(RespondedQuestionnaireEntity respondedQuestionnaireEntity){
        List<RespondedQuestionnaireEntity> result = respondedQuestionnaireEntityMapper.selectRespondedQuestionnaire(respondedQuestionnaireEntity);
        return result;
    }

    public List<RespondedQuestionnaireEntity> selectRespondedQuestionnaireByName(RespondedQuestionnaireEntity respondedQuestionnaireEntity){
        List<RespondedQuestionnaireEntity> result = respondedQuestionnaireEntityMapper.selectRespondedQuestionnaireByName(respondedQuestionnaireEntity);
        return result;
    }
}

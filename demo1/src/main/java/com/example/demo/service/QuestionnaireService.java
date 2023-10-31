package com.example.demo.service;

import com.example.demo.dao.QuestionnaireEntityMapper;
import com.example.demo.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.common.utils.UUIDUtil;

import java.util.List;

@Service
public class QuestionnaireService {


    @Autowired
    private QuestionnaireEntityMapper questionnaireEntityMapper;
    /**
     * 创建问卷
     */
    public  int  addQuestionnaireInfo(QuestionnaireEntity questionnaireEntity){
        questionnaireEntity.setId(UUIDUtil.getOneUUID());
        System.out.println("1questionnaireEntity===========" + questionnaireEntity.toString() );
        int questionnaireResult=  questionnaireEntityMapper.insert(questionnaireEntity);
        if (questionnaireResult != 0) {
            return 3;//用户3代表用户存在
        }else {
            return questionnaireResult;
        }
    }
    /*
   查找问卷
    */
    public List<QuestionnaireEntity> queryQuestionnairetListByProjectId(QuestionnaireEntity questionnaireEntity){
        List<QuestionnaireEntity> result = questionnaireEntityMapper.queryQuestionnairetListByProjectId(questionnaireEntity);
        return result;
    }

    /*
    按id删除项目
     */
    public int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity){
        System.out.println("111111111111questionnaireEntity========" + questionnaireEntity.toString());
        int userResult=questionnaireEntityMapper.deleteQuestionnaireById(questionnaireEntity);
        System.out.println("22222222222222222questionnaireEntity========" + questionnaireEntity.toString());
        return userResult;
    }
}

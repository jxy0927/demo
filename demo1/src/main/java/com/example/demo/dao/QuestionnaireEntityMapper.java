package com.example.demo.dao;

import com.example.demo.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper
public interface QuestionnaireEntityMapper {

    /**
    *创建问卷
     **/
    int insert(QuestionnaireEntity questionnaireEntity);
    /*
//  查询指定工程下的问卷
//   */
    List<QuestionnaireEntity> queryQuestionnairetListByProjectId(QuestionnaireEntity questionnaireEntity);
    /*
    删除指定id的问卷
     */
    int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity);
}

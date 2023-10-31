package com.example.demo.service;
import com.example.demo.dao.QuestionBankEntityMapper;
import com.example.demo.dao.entity.QuestionBankEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionBankService {
    @Autowired
    private QuestionBankEntityMapper questionBankEntityMapper;

    /*
    查询每个问卷的题库列表
     */
    public List<QuestionBankEntity> queryQuestionList(QuestionBankEntity questionBankEntity){
        List<QuestionBankEntity> result = questionBankEntityMapper.queryQuestionList(questionBankEntity);
        return result;
    }
}

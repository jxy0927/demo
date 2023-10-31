package com.example.demo.dao;

import com.example.demo.dao.entity.QuestionBankEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper
public interface QuestionBankEntityMapper {
    List<QuestionBankEntity> queryQuestionList(QuestionBankEntity questionBankEntity);
}

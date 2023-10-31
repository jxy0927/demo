package com.example.demo.controller;

import com.example.demo.dao.entity.QuestionBankEntity;
import com.example.demo.dao.entity.QuestionnaireEntity;
import com.example.demo.dao.entity.RespondedQuestionnaireEntity;
import com.example.demo.service.QuestionBankService;
import com.example.demo.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.service.RespondedQuestionnaireService;

import java.util.List;

@RestController
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private RespondedQuestionnaireService respondedQuestionnaireService;
    @Autowired
    private QuestionBankService questionBankService;



    /**
    查询指定问卷的所有问题
     */
    @RequestMapping(value = "/queryQuestionList",method = RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity queryQuestionnaire(@RequestBody QuestionBankEntity questionBankEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
//        System.out.println("-----------"+questionBankEntity);
        try{
            List<QuestionBankEntity> result=questionBankService.queryQuestionList(questionBankEntity);
            System.out.println("结果--------"+result);
            if(CollectionUtils.isEmpty(result)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setMessage("无项目信息");

            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("查询成功");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 项目添加
     */
    @RequestMapping(value = "/addQuestionnaire",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addProjectInfo(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        System.out.println("添加------"+questionnaireEntity);
        try {
            int result = questionnaireService.addQuestionnaireInfo(questionnaireEntity);
            System.out.println(result);

            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /*
   查询指定项目的所有被答问卷
    */
    @RequestMapping(value = "/selectRespondedQuestionnaire",method = RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity selectRespondedQuestionnaire(@RequestBody RespondedQuestionnaireEntity respondedQuestionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try{
            List<RespondedQuestionnaireEntity> result=respondedQuestionnaireService.selectRespondedQuestionnaire(respondedQuestionnaireEntity);
            if(CollectionUtils.isEmpty(result)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setMessage("无项目信息");

            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("查询成功");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /*
   根据答卷人姓名查询被答问卷
    */
    @RequestMapping(value = "/selectRespondedQuestionnaireByName",method = RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity selectRespondedQuestionnaireByName(@RequestBody RespondedQuestionnaireEntity respondedQuestionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try{
            List<RespondedQuestionnaireEntity> result=respondedQuestionnaireService.selectRespondedQuestionnaireByName(respondedQuestionnaireEntity);
            System.out.println("查询问卷-----"+result);
            if(CollectionUtils.isEmpty(result)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setMessage("无项目信息");

            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("查询成功");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /*
    问卷查询
     */
    @RequestMapping(value = "/queryQuestionnairetListByProjectId",method = RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity queryQuestionnairetListByProjectId(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
//        System.out.println("添加----"+questionnaireEntity);
        try{
            List<QuestionnaireEntity> result=questionnaireService.queryQuestionnairetListByProjectId(questionnaireEntity);
            if(CollectionUtils.isEmpty(result)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setMessage("无项目信息");

            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("查询成功");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    /*
    项目删除
     */
    @RequestMapping(value = "/deleteQuestionnaireById",method = RequestMethod.POST,headers="Accept=application/json")
    public HttpResponseEntity deleteQuestionnaireById(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        System.out.println("删除---"+questionnaireEntity);
        try{
            int result=questionnaireService.deleteQuestionnaireById(questionnaireEntity);
            if(result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}

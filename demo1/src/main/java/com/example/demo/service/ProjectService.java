package com.example.demo.service;

import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.dao.entity.ProjectEntity;
import com.example.demo.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.demo.dao.ProjectEntityMapper;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private  ProjectEntityMapper projectEntityMapper;

    public List<ProjectEntity>   queryProjectList(ProjectEntity projectEntity){
        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }
    /**
     * 创建项目
     */
    public  int  addProjectInfo(ProjectEntity projectEntity){
        projectEntity.setId(UUIDUtil.getOneUUID());
        int userResult=  projectEntityMapper.insert(projectEntity);
        if (userResult != 0) {
            return 3;//用户3代表用户存在
        }else {
            return userResult;
        }
    }
    /**
     * 修改项目信息
     */
    public int modifyProjectInfo(ProjectEntity projectEntity){
        int projectResult =projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        return  projectResult;
    }
    /**
     * 删除项目信息
     */
    public  int  deleteProjectById(ProjectEntity projectEntity){
        int projectResult =projectEntityMapper.deleteProjectById(projectEntity);
        return projectResult;
    }

    /**
     *查询项目信息
     */
    public List<ProjectEntity> selectProjectInfo(ProjectEntity projectEntity) {
        List<ProjectEntity> result = projectEntityMapper.selectProjectInfo(projectEntity);
        return result;
    }
}

package com.example.demo.dao;

import com.example.demo.dao.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectEntityMapper {

    /**
     * 查询项目列表
     * */
    List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);

    /**
     * 创建项目的基本信息
     * */
    int insert(ProjectEntity projectEntity);
    /**
     * 根据id删除项目信息
     */
    int deleteProjectById(ProjectEntity projectEntity);
    /**
     *修改项目信息
     */
    int updateByPrimaryKeySelective(ProjectEntity projectEntity);
    /**
     * 查询项目
     * */
    List<ProjectEntity> selectProjectInfo(ProjectEntity projectEntity);
}

package com.zp95sky.dijun.project.biz;

import com.zp95sky.dijun.project.domain.ProjectDo;
import com.zp95sky.dijun.project.domain.ProjectListDo;
import com.zp95sky.dijun.project.dto.AddProjectDto;
import com.zp95sky.dijun.project.dto.EditProjectDto;

import java.util.List;

/**
 * 项目业务处理
 */
public interface ProjectBiz {

    /**
     * 添加项目
     * @param projectDto 项目信息
     */
    void addProject(AddProjectDto projectDto);

    /**
     * 删除项目
     * @param id 项目ID
     */
    void deleteProject(Integer id);

    /**
     * 编辑项目
     * @param id 项目ID
     * @param projectDto 项目信息
     */
    void editProject(Integer id, EditProjectDto projectDto);

    /**
     * 查询所有项目列表
     * @return 项目列表
     */
    List<ProjectListDo> getProjectList();

    /**
     * 查询项目详情
     * @param id 项目ID
     * @return 项目信息
     */
    ProjectDo getProjectInfo(Integer id);

}

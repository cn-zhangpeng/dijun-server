package com.zp95sky.dijun.project.biz.impl;

import cn.hutool.core.lang.Snowflake;
import com.zp95sky.dijun.common.constant.ResponseConstant;
import com.zp95sky.dijun.project.biz.ProjectBiz;
import com.zp95sky.dijun.project.domain.ProjectDo;
import com.zp95sky.dijun.project.domain.ProjectListDo;
import com.zp95sky.dijun.project.dto.AddProjectDto;
import com.zp95sky.dijun.project.dto.EditProjectDto;
import com.zp95sky.dijun.project.entity.Project;
import com.zp95sky.dijun.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectBizImpl implements ProjectBiz {

    private final ProjectService projectService;

    private final Snowflake snowflake;

    @Override
    public void addProject(AddProjectDto projectDto) {
        Project project = Project.builder()
                .id(snowflake.nextId()).name(projectDto.getName())
                .coverImage(projectDto.getCoverImage()).description(projectDto.getDescription())
                .createTime(LocalDateTime.now())
                .build();
        projectService.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectService.removeById(id);
    }

    @Override
    public void editProject(Long id, EditProjectDto projectDto) {
        Project project = Project.builder()
                .id(id).name(projectDto.getName())
                .coverImage(projectDto.getCoverImage()).description(projectDto.getDescription())
                .build();
        projectService.updateById(project);
    }

    @Override
    public List<ProjectListDo> getProjectList() {
        List<Project> projectList = projectService.list();
        if (CollectionUtils.isEmpty(projectList)) {
            return Collections.emptyList();
        }

        return projectList.stream().map(this::buildProjectListDo).collect(Collectors.toList());
    }

    @Override
    public ProjectDo getProjectInfo(Long id) {
        Project project = projectService.getById(id);
        Assert.notNull(project, ResponseConstant.ERROR_PROJECT_NOT_EXIST);

        return buildProjectDo(project);
    }

    private ProjectListDo buildProjectListDo(Project project) {
        return ProjectListDo.builder()
                .id(project.getId()).name(project.getName())
                .coverImage(project.getCoverImage())
                .build();
    }

    private ProjectDo buildProjectDo(Project project) {
        return ProjectDo.builder()
                .id(project.getId()).name(project.getName())
                .coverImage(project.getCoverImage()).description(project.getDescription())
                .build();
    }

}

package com.zp95sky.dijun.project.biz.impl;

import com.zp95sky.dijun.common.constant.ErrorConstant;
import com.zp95sky.dijun.common.utils.AssertUtil;
import com.zp95sky.dijun.project.biz.ProjectBiz;
import com.zp95sky.dijun.project.domain.ProjectDo;
import com.zp95sky.dijun.project.domain.ProjectListDo;
import com.zp95sky.dijun.project.dto.AddProjectDto;
import com.zp95sky.dijun.project.dto.EditProjectDto;
import com.zp95sky.dijun.project.entity.Project;
import com.zp95sky.dijun.project.service.ProjectService;
import com.zp95sky.dijun.user.biz.AuthBiz;
import com.zp95sky.dijun.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectBizImpl implements ProjectBiz {

    private final AuthBiz authBiz;

    private final ProjectService projectService;

    @Override
    public Integer addProject(AddProjectDto projectDto) {
        User user = authBiz.getCurUser();

        Project project = Project.builder()
                .companyId(user.getCompanyId()).name(projectDto.getName())
                .coverImage(projectDto.getCoverImage()).description(projectDto.getDescription())
                .createTime(LocalDateTime.now())
                .build();
        projectService.save(project);
        return project.getId();
    }

    @Override
    public void deleteProject(Integer id) {
        projectService.removeById(id);
    }

    @Override
    public void editProject(Integer id, EditProjectDto projectDto) {
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

    @SneakyThrows
    @Override
    public ProjectDo getProjectInfo(Integer id) {
        Project project = projectService.getById(id);
        AssertUtil.notEmpty(project, ErrorConstant.PROJECT_NOT_EXIST);

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

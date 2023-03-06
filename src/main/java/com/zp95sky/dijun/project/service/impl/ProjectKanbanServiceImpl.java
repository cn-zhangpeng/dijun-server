package com.zp95sky.dijun.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.dijun.project.entity.ProjectKanban;
import com.zp95sky.dijun.project.mapper.ProjectKanbanMapper;
import com.zp95sky.dijun.project.service.ProjectKanbanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectKanbanServiceImpl extends ServiceImpl<ProjectKanbanMapper, ProjectKanban> implements ProjectKanbanService {

    @Override
    public List<ProjectKanban> listByProjectId(Long projectId) {
        LambdaQueryWrapper<ProjectKanban> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectKanban::getProjectId, projectId);
        return list(queryWrapper);
    }

}

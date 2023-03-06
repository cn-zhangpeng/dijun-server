package com.zp95sky.dijun.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.dijun.project.entity.ProjectTask;
import com.zp95sky.dijun.project.mapper.ProjectTaskMapper;
import com.zp95sky.dijun.project.service.ProjectTaskService;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServiceImpl extends ServiceImpl<ProjectTaskMapper, ProjectTask> implements ProjectTaskService {
}

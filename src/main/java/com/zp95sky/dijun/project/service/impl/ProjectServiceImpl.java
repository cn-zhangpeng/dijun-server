package com.zp95sky.dijun.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.dijun.project.entity.Project;
import com.zp95sky.dijun.project.mapper.ProjectMapper;
import com.zp95sky.dijun.project.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}

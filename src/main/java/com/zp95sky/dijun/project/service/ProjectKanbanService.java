package com.zp95sky.dijun.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.dijun.project.entity.ProjectKanban;

import java.util.List;

/**
 * 项目看板处理
 */
public interface ProjectKanbanService extends IService<ProjectKanban> {

    /**
     * 根据项目ID查询看板列表
     * @param projectId 项目ID
     * @return 看板列表
     */
    List<ProjectKanban> listByProjectId(Integer projectId);

}

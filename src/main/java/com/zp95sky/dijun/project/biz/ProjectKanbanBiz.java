package com.zp95sky.dijun.project.biz;

import com.zp95sky.dijun.project.domain.ProjectKanbanListDo;

import java.util.List;

/**
 * 项目看板业务处理
 */
public interface ProjectKanbanBiz {

    /**
     * 查询看板列表
     * @param projectId 项目ID
     * @return 看板列表
     */
    List<ProjectKanbanListDo> getKanbanList(Integer projectId);

}

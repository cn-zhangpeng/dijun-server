package com.zp95sky.dijun.project.biz;

import com.zp95sky.dijun.project.domain.ProjectTaskListDo;

import java.util.List;

/**
 * 项目任务业务处理
 */
public interface ProjectTaskBiz {

    /**
     * 查询任务列表
     * @param kanbanId 看板ID
     * @return 任务列表
     */
    List<ProjectTaskListDo> getTaskList(Long kanbanId);

}

package com.zp95sky.dijun.project.biz;

import com.zp95sky.dijun.common.response.BasePageData;
import com.zp95sky.dijun.project.domain.ProjectTaskDo;
import com.zp95sky.dijun.project.domain.ProjectTaskListDo;

/**
 * 项目任务业务处理
 */
public interface ProjectTaskBiz {

    /**
     * 查询任务列表
     * @param kanbanId 看板ID
     * @param page 当前页
     * @param pageSize 查询条数
     * @return 任务列表及分页信息
     */
    BasePageData<ProjectTaskListDo> getTaskList(Integer kanbanId, Integer page, Integer pageSize);

    /**
     * 查询任务详情
     * @param taskId 任务ID
     * @return 任务详情
     */
    ProjectTaskDo getTaskDetail(Integer taskId);

}

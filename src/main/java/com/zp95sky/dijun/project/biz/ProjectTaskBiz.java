package com.zp95sky.dijun.project.biz;

import com.zp95sky.dijun.common.response.BaseResponse;
import com.zp95sky.dijun.project.domain.ProjectTaskListDo;

import java.util.List;

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
    BaseResponse<ProjectTaskListDo> getTaskList(Long kanbanId, Integer page, Integer pageSize);

}

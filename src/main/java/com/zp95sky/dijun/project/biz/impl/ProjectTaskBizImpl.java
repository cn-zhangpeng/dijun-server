package com.zp95sky.dijun.project.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zp95sky.dijun.common.response.BaseResponse;
import com.zp95sky.dijun.common.response.ResponseUtil;
import com.zp95sky.dijun.project.biz.ProjectTaskBiz;
import com.zp95sky.dijun.project.domain.ProjectTaskListDo;
import com.zp95sky.dijun.project.entity.ProjectTask;
import com.zp95sky.dijun.project.service.ProjectTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectTaskBizImpl implements ProjectTaskBiz {

    private final ProjectTaskService taskService;

    @Override
    public BaseResponse<ProjectTaskListDo> getTaskList(Long kanbanId, Integer page, Integer pageSize) {
        Page<ProjectTask> pageParam = new Page<>(page, pageSize);
        LambdaQueryWrapper<ProjectTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectTask::getKanbanId, kanbanId);

        IPage<ProjectTask> taskPage = taskService.page(pageParam, queryWrapper);
        List<ProjectTask> taskList = taskPage.getRecords();

        if (CollectionUtils.isEmpty(taskList)) {
            return ResponseUtil.buildPageResultEmpty(page, pageSize);
        }

        List<ProjectTaskListDo> taskListDos = taskList.stream().map(this::buildProjectTaskListDo).collect(Collectors.toList());
        return ResponseUtil.buildPageResultSuccess(page, pageSize, taskPage.getTotal(), taskListDos);
    }

    private ProjectTaskListDo buildProjectTaskListDo(ProjectTask projectTask) {
        return ProjectTaskListDo.builder()
                .id(projectTask.getId()).name(projectTask.getName())
                .executorName(projectTask.getExecutorId()).endTime(projectTask.getEndTime())
                .build();
    }

}

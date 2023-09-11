package com.zp95sky.dijun.project.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zp95sky.dijun.common.response.BasePageData;
import com.zp95sky.dijun.project.biz.ProjectTaskBiz;
import com.zp95sky.dijun.project.domain.ProjectTaskDo;
import com.zp95sky.dijun.project.domain.ProjectTaskListDo;
import com.zp95sky.dijun.project.entity.ProjectTask;
import com.zp95sky.dijun.project.service.ProjectTaskService;
import com.zp95sky.dijun.user.entity.User;
import com.zp95sky.dijun.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectTaskBizImpl implements ProjectTaskBiz {

    private final ProjectTaskService taskService;
    private final UserService userService;

    @Override
    public BasePageData<ProjectTaskListDo> getTaskList(Integer kanbanId, Integer page, Integer pageSize) {
        Page<ProjectTask> pageParam = new Page<>(page, pageSize);
        LambdaQueryWrapper<ProjectTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectTask::getKanbanId, kanbanId);

        IPage<ProjectTask> taskPage = taskService.page(pageParam, queryWrapper);
        List<ProjectTask> taskList = taskPage.getRecords();

        if (CollectionUtils.isEmpty(taskList)) {
            return BasePageData.buildEmptyData();
        }

        List<ProjectTaskListDo> taskListDos = taskList.stream().map(this::buildProjectTaskListDo).collect(Collectors.toList());
        appendExecutorName(taskListDos);
        return BasePageData.buildData(page, pageSize, taskPage.getTotal(), taskListDos);
    }

    @Override
    public ProjectTaskDo getTaskDetail(Integer taskId) {
        ProjectTask task = taskService.getById(taskId);
        if (ObjectUtils.isEmpty(task)) {
            return null;
        }

        return buildProjectTaskDo(task);
    }

    private ProjectTaskDo buildProjectTaskDo(ProjectTask task) {
        ProjectTaskDo taskDo = ProjectTaskDo.builder()
                .id(task.getId()).name(task.getName()).priority(task.getPriority())
                .startTime(task.getStartTime()).endTime(task.getEndTime())
                .build();

        User user = userService.getById(task.getExecutorId());
        taskDo.setExecutor(ProjectTaskDo.TaskExecutor.builder()
                .id(user.getId()).name(user.getNickname())
                .build());
        return taskDo;
    }

    private void appendExecutorName(List<ProjectTaskListDo> taskListDos) {
        Set<Integer> ids = taskListDos.stream().map(t -> t.getExecutor().getId()).collect(Collectors.toSet());
        List<User> userList = userService.listByIds(ids);
        Map<Integer, String> userMap = userList.stream().collect(Collectors.toMap(User::getId, User::getNickname));
        taskListDos.forEach(t -> t.getExecutor().setName(userMap.get(t.getExecutor().getId())));
    }

    private ProjectTaskListDo buildProjectTaskListDo(ProjectTask projectTask) {
        ProjectTaskListDo.TaskExecutor taskExecutor = ProjectTaskListDo.TaskExecutor.builder()
                .id(projectTask.getExecutorId()).build();
        return ProjectTaskListDo.builder()
                .id(projectTask.getId()).name(projectTask.getName())
                .executor(taskExecutor).endTime(projectTask.getEndTime())
                .build();
    }

}

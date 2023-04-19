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
import com.zp95sky.dijun.user.entity.User;
import com.zp95sky.dijun.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    public BaseResponse<ProjectTaskListDo> getTaskList(Integer kanbanId, Integer page, Integer pageSize) {
        Page<ProjectTask> pageParam = new Page<>(page, pageSize);
        LambdaQueryWrapper<ProjectTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectTask::getKanbanId, kanbanId);

        IPage<ProjectTask> taskPage = taskService.page(pageParam, queryWrapper);
        List<ProjectTask> taskList = taskPage.getRecords();

        if (CollectionUtils.isEmpty(taskList)) {
            return ResponseUtil.buildPageResultEmpty(page, pageSize);
        }

        List<ProjectTaskListDo> taskListDos = taskList.stream().map(this::buildProjectTaskListDo).collect(Collectors.toList());
        appendExecutorName(taskListDos);
        return ResponseUtil.buildPageResultSuccess(page, pageSize, taskPage.getTotal(), taskListDos);
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

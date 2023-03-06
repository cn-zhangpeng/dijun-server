package com.zp95sky.dijun.project.controller;

import com.zp95sky.dijun.common.response.BaseResponse;
import com.zp95sky.dijun.common.response.ResponseUtil;
import com.zp95sky.dijun.project.biz.ProjectTaskBiz;
import com.zp95sky.dijun.project.domain.ProjectTaskListDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "项目任务管理")
@RestController
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectTaskController {

    private final ProjectTaskBiz taskBiz;

    @ApiOperation("查询看板列表")
    @ApiImplicitParam(name = "kid", value = "看板ID", paramType = "path", dataTypeClass = String.class)
    @GetMapping("/kanbans/{kid}/tasks")
    public BaseResponse<List<ProjectTaskListDo>> getTaskList(@PathVariable("kid") Long kanbanId) {
        List<ProjectTaskListDo> taskListDos = taskBiz.getTaskList(kanbanId);
        return ResponseUtil.buildResultSuccess(taskListDos);
    }

}

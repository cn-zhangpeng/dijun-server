package com.zp95sky.dijun.project.controller;

import com.zp95sky.dijun.common.response.BaseResponse;
import com.zp95sky.dijun.project.biz.ProjectTaskBiz;
import com.zp95sky.dijun.project.domain.ProjectTaskListDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目任务管理")
@RestController
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectTaskController {

    private final ProjectTaskBiz taskBiz;

    @ApiOperation("查询看板列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kid", value = "看板ID", paramType = "path", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "page", value = "当前页", paramType = "query", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "pageSize", value = "查询条数", paramType = "query", dataTypeClass = Integer.class)
    })
    @GetMapping("/kanbans/{kid}/tasks")
    public BaseResponse<ProjectTaskListDo> getTaskList(@PathVariable("kid") Integer kanbanId,
                                                             @RequestParam Integer page,
                                                             @RequestParam Integer pageSize) {
        return taskBiz.getTaskList(kanbanId, page, pageSize);
    }

}

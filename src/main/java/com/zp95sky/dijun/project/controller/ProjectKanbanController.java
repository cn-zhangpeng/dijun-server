package com.zp95sky.dijun.project.controller;

import com.zp95sky.dijun.project.biz.ProjectKanbanBiz;
import com.zp95sky.dijun.project.domain.ProjectKanbanListDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "项目看板管理")
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectKanbanController {

    private final ProjectKanbanBiz kanbanBiz;

    @ApiOperation("查询看板列表")
    @ApiImplicitParam(name = "pid", value = "项目ID", paramType = "path", dataTypeClass = String.class)
    @GetMapping("/{pid}/kanbans")
    public List<ProjectKanbanListDo> getKanbanList(@PathVariable("pid") Integer projectId) {
        return kanbanBiz.getKanbanList(projectId);
    }

}

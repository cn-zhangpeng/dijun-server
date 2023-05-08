package com.zp95sky.dijun.project.controller;

import com.zp95sky.dijun.project.biz.ProjectBiz;
import com.zp95sky.dijun.project.domain.ProjectDo;
import com.zp95sky.dijun.project.domain.ProjectListDo;
import com.zp95sky.dijun.project.dto.AddProjectDto;
import com.zp95sky.dijun.project.dto.EditProjectDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "项目管理")
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectController {

    private final ProjectBiz projectBiz;

    @ApiOperation("添加项目")
    @PostMapping
    public Integer addProject(@RequestBody AddProjectDto projectDto) {
        return projectBiz.addProject(projectDto);
    }

    @ApiOperation("删除项目")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, paramType = "path", dataTypeClass = String.class)
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectBiz.deleteProject(id);
    }

    @ApiOperation("编辑项目")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, paramType = "path", dataTypeClass = String.class)
    @PutMapping("/{id}")
    public void editProject(@PathVariable Integer id, @RequestBody EditProjectDto projectDto) {
        projectBiz.editProject(id, projectDto);
    }

    @ApiOperation("查询项目列表")
    @GetMapping
    public List<ProjectListDo> getProjectList() {
        return projectBiz.getProjectList();
    }

    @ApiOperation("查询项目信息")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, paramType = "path", dataTypeClass = String.class)
    @GetMapping("/{id}")
    public ProjectDo getProjectInfo(@PathVariable Integer id) {
        return projectBiz.getProjectInfo(id);
    }

}

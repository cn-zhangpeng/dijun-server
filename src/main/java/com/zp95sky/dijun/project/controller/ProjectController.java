package com.zp95sky.dijun.project.controller;

import com.zp95sky.dijun.common.response.BaseResponse;
import com.zp95sky.dijun.common.response.ResponseUtil;
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
@RequestMapping("/project")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ProjectController {

    private final ProjectBiz projectBiz;

    @ApiOperation("添加项目")
    @PostMapping
    public BaseResponse<Void> addProject(@RequestBody AddProjectDto projectDto) {
        projectBiz.addProject(projectDto);
        return ResponseUtil.buildResultSuccess();
    }

    @ApiOperation("删除项目")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, paramType = "path", dataTypeClass = String.class)
    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteProject(@PathVariable Long id) {
        projectBiz.deleteProject(id);
        return ResponseUtil.buildResultSuccess();
    }

    @ApiOperation("编辑项目")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, paramType = "path", dataTypeClass = String.class)
    @PutMapping("/{id}")
    public BaseResponse<Void> editProject(@PathVariable Long id, @RequestBody EditProjectDto projectDto) {
        projectBiz.editProject(id, projectDto);
        return ResponseUtil.buildResultSuccess();
    }

    @ApiOperation("查询项目列表")
    @GetMapping
    public BaseResponse<List<ProjectListDo>> getProjectList() {
        List<ProjectListDo> projectListDos = projectBiz.getProjectList();
        return ResponseUtil.buildResultSuccess(projectListDos);
    }

    @ApiOperation("查询项目信息")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, paramType = "path", dataTypeClass = String.class)
    @GetMapping("/{id}")
    public BaseResponse<ProjectDo> getProjectInfo(@PathVariable Long id) {
        ProjectDo projectDo = projectBiz.getProjectInfo(id);
        return ResponseUtil.buildResultSuccess(projectDo);
    }

}

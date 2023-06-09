package com.zp95sky.dijun.project.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "ProjectKanbanListDo", description = "项目看板列表信息")
@Data
@Builder
public class ProjectKanbanListDo {

    @ApiModelProperty(value = "看板ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "看板名称", required = true)
    private String name;

}

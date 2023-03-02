package com.zp95sky.dijun.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "AddProjectDto", description = "添加项目参数")
@Data
public class AddProjectDto {

    @ApiModelProperty(value = "项目名称", required = true)
    private String name;

    @ApiModelProperty(value = "项目封面")
    private String coverImage;

    @ApiModelProperty(value = "项目描述", required = true)
    private String description;

}

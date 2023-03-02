package com.zp95sky.dijun.project.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "ProjectListDo", description = "项目列表信息")
@Data
@Builder
public class ProjectListDo {

    @ApiModelProperty(value = "项目ID", required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "项目名称", required = true)
    private String name;

    @ApiModelProperty(value = "项目封面")
    private String coverImage;

}

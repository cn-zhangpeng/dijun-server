package com.zp95sky.dijun.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel(value = "ProjectTaskListDo", description = "项目列表信息")
@Data
@Builder
public class ProjectTaskListDo {

    @ApiModelProperty(value = "任务ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "任务名称", required = true)
    private String name;

    @ApiModelProperty(value = "执行者名称", required = true)
    private TaskExecutor executor;

    @ApiModelProperty(value = "任务结束时间", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    @ApiModel(value = "TaskExecutor", description = "项目任务执行者")
    @Data
    @Builder
    public static class TaskExecutor {

        @ApiModelProperty(value = "用户ID", required = true)
        private Integer id;

        @ApiModelProperty(value = "用户名称", required = true)
        private String name;

    }

}

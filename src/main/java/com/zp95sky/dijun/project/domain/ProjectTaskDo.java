package com.zp95sky.dijun.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zp95sky.dijun.project.enums.ProjectTaskPriorityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel(value = "ProjectTaskDo", description = "任务详情信息")
@Data
@Builder
public class ProjectTaskDo {

    @ApiModelProperty(value = "任务ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "任务名称", required = true)
    private String name;

    @ApiModelProperty("任务开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    @ApiModelProperty("任务结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    @ApiModelProperty("人物状态，true：已完成，false：未完成")
    private Boolean status;

    @ApiModelProperty(value = "任务优先级", required = true)
    private ProjectTaskPriorityEnum priority;

    @ApiModelProperty("任务执行者")
    private TaskExecutor executor;

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

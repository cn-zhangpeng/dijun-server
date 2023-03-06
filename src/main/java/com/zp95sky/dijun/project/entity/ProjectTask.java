package com.zp95sky.dijun.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zp95sky.dijun.project.enums.ProjectTaskPriorityEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目任务
 */
@Data
@Builder
@TableName("project_task")
public class ProjectTask {

    /** 任务ID */
    @TableId("id")
    private Long id;

    /** 任务ID */
    @TableField("kanban_id")
    private Long kanbanId;

    /** 任务名称 */
    @TableField("name")
    private String name;

    /** 任务开始时间 */
    @TableField("start_time")
    private LocalDateTime startTime;

    /** 任务结束时间 */
    @TableField("end_time")
    private LocalDateTime endTime;

    /** 任务优先级 */
    @TableField("priority")
    private ProjectTaskPriorityEnum priority;

    /** 执行者 */
    @TableField("executor_id")
    private Long executorId;

    /** 创建者 */
    @TableField("creator_id")
    private Long creatorId;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}

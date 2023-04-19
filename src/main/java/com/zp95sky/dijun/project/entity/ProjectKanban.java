package com.zp95sky.dijun.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目看板
 */
@Data
@Builder
@TableName("project_kanban")
public class ProjectKanban {

    /** 项目ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 项目ID */
    @TableField("project_id")
    private Integer projectId;

    /** 看板名称 */
    @TableField("name")
    private String name;

    /** 看板顺序（数字越小，排名越靠前） */
    @TableField("ordered")
    private Integer ordered;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}

package com.zp95sky.dijun.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 项目实体
 */
@Data
@Builder
@TableName("project")
public class Project {

    /** 项目ID */
    @TableId("id")
    private Long id;

    /** 项目名称 */
    @TableField("name")
    private String name;

    /** 项目封面图片 */
    @TableField("cover_image")
    private String coverImage;

    /** 项目描述 */
    @TableField("description")
    private String description;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}

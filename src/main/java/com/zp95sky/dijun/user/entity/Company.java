package com.zp95sky.dijun.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 企业实体
 */
@Data
@Builder
@TableName("company")
public class Company {

    /** 用户ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 企业名称 */
    @TableField("name")
    private String name;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}

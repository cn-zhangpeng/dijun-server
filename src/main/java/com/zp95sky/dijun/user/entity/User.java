package com.zp95sky.dijun.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("user")
public class User {

    /** 用户ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 用户昵称 */
    @TableField("nickname")
    private String nickname;

    /** 手机号 */
    @TableField("mobile")
    private String mobile;

    /** 密码 */
    @TableField("password")
    private String password;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}

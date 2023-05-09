package com.zp95sky.dijun.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体
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

    /** 邮箱 */
    @TableField("email")
    private String email;

    /** 密码 */
    @TableField("password")
    private String password;

    /** 用户头像 */
    @TableField("avatar")
    private String avatar;

    /** 企业ID */
    @TableField("company_id")
    private Integer companyId;

    /** 部门ID */
    @TableField("department_id")
    private Integer departmentId;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}

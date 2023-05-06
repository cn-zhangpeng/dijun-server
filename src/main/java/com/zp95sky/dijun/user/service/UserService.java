package com.zp95sky.dijun.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.dijun.user.entity.User;

/**
 * 用户处理
 */
public interface UserService extends IService<User> {

    /**
     * 根据邮件查询用户信息
     * @param email 邮件
     * @return 用户信息
     */
    User getByEmail(String email);

}

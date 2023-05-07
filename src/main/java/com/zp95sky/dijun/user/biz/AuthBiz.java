package com.zp95sky.dijun.user.biz;

import com.zp95sky.dijun.user.domain.LoginDo;
import com.zp95sky.dijun.user.dto.LoginDto;
import com.zp95sky.dijun.user.entity.User;

/**
 * 认证处理
 */
public interface AuthBiz {

    /**
     * 用户登录
     * @param loginDto 登录信息
     * @return 登录用户信息
     */
    LoginDo login(LoginDto loginDto);

    /**
     * 获取当前登录用户信息
     * @return 当前登录用户信息
     */
    User getCurUser();

    /**
     * 获取当前登录用户信息
     * @param token 用户Token
     * @return 当前登录用户信息
     */
    User getCurUser(String token);

    /**
     * 退出登录
     */
    void logout();

    /**
     * 退出登录
     * @param token 用户Token
     */
    void logout(String token);

}

package com.zp95sky.dijun.user.biz;

import com.zp95sky.dijun.user.domain.LoginDo;
import com.zp95sky.dijun.user.dto.LoginDto;

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

}

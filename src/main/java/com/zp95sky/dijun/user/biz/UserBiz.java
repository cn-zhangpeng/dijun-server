package com.zp95sky.dijun.user.biz;

import com.zp95sky.dijun.user.dto.AddUserDto;

/**
 * 用户处理
 */
public interface UserBiz {

    /**
     * 添加用户信息
     * @param userDto 用户信息
     * @return 用户ID
     */
    Integer addUser(AddUserDto userDto);

}

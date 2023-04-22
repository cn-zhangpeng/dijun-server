package com.zp95sky.dijun.user.biz.impl;

import cn.hutool.core.lang.Snowflake;
import com.zp95sky.dijun.common.constant.ErrorConstant;
import com.zp95sky.dijun.common.exception.CustomException;
import com.zp95sky.dijun.common.utils.RedisUtil;
import com.zp95sky.dijun.user.biz.AuthBiz;
import com.zp95sky.dijun.user.domain.LoginDo;
import com.zp95sky.dijun.user.dto.LoginDto;
import com.zp95sky.dijun.user.entity.User;
import com.zp95sky.dijun.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class AuthBizImpl implements AuthBiz {

    private final UserService userService;

    private final Snowflake snowflake;
    private final RedisUtil redisUtil;

    // token失效时间，单位（分钟）
    private static final long TOKEN_EXPIRE_TIME = 60;

    @SneakyThrows
    @Override
    public LoginDo login(LoginDto loginDto) {
        User user = userService.getByEmail(loginDto.getEmail());
        if (ObjectUtils.isEmpty(user) || !loginDto.getPassword().equals(user.getPassword())) {
            throw new CustomException(ErrorConstant.USER_EMAIL_OR_PASSWORD);
        }

        // 保存token
        String token = snowflake.nextIdStr();
        redisUtil.set(token, user, TOKEN_EXPIRE_TIME, TimeUnit.MINUTES);

        // 构建响应信息
        return LoginDo.builder()
                .id(user.getId()).nickname(user.getNickname())
                .accessToken(token)
                .build();
    }

}

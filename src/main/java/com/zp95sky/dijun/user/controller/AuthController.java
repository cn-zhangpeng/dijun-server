package com.zp95sky.dijun.user.controller;

import com.zp95sky.dijun.user.biz.AuthBiz;
import com.zp95sky.dijun.user.domain.LoginDo;
import com.zp95sky.dijun.user.dto.LoginDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证接口
 */

@Api(tags = "认证管理")
@RestController
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class AuthController {

    private final AuthBiz authBiz;

    @SneakyThrows
    @ApiOperation("登录")
    @PostMapping("/login")
    public LoginDo login(@RequestBody LoginDto loginDto) {
        return authBiz.login(loginDto);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public void logout() {
        authBiz.logout();
    }

}

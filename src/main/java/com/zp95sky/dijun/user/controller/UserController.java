package com.zp95sky.dijun.user.controller;

import com.zp95sky.dijun.user.biz.UserBiz;
import com.zp95sky.dijun.user.dto.AddUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证接口
 */

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class UserController {

    private final UserBiz userBiz;

    @SneakyThrows
    @ApiOperation("添加用户")
    @PostMapping
    public void addUser(@RequestBody AddUserDto userDto) {
        userBiz.addUser(userDto);
    }

}

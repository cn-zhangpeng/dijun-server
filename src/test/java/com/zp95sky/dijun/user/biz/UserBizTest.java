package com.zp95sky.dijun.user.biz;

import cn.hutool.crypto.SecureUtil;
import com.github.javafaker.Faker;
import com.zp95sky.dijun.annotation.CommonTestAnnotation;
import com.zp95sky.dijun.user.dto.AddUserDto;
import com.zp95sky.dijun.user.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Locale;

@CommonTestAnnotation
public class UserBizTest {

    @Resource
    private UserBiz userBiz;

    @Resource
    private UserService userService;

    private final Faker faker = new Faker(Locale.CHINA);

    private Integer userId;

    @Test
    public void testAddUser() {
        AddUserDto userDto = new AddUserDto();
        userDto.setNickname(faker.name().fullName());
        userDto.setMobile(faker.phoneNumber().cellPhone());
        userDto.setEmail(faker.internet().emailAddress());
        userDto.setPassword(SecureUtil.md5(faker.lorem().characters(8)));
        userId = userBiz.addUser(userDto);
        assert !ObjectUtils.isEmpty(userId);
    }

    @AfterEach
    public void tearDown() {
        if (!ObjectUtils.isEmpty(userId)) {
            userService.removeById(userId);
        }
    }

}

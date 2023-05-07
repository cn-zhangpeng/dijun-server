package com.zp95sky.dijun.user.biz;

import cn.hutool.crypto.SecureUtil;
import com.zp95sky.dijun.annotation.CommonTestAnnotation;
import com.zp95sky.dijun.user.domain.LoginDo;
import com.zp95sky.dijun.user.dto.LoginDto;
import com.zp95sky.dijun.user.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@CommonTestAnnotation
public class AuthBizTest {

    @Resource
    private AuthBiz authBiz;

    private LoginDo loginDo;

    @BeforeEach
    public void init() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("user1@email.com");
        loginDto.setPassword(SecureUtil.md5("123456"));
        loginDo = authBiz.login(loginDto);
    }

    @Test
    public void testGetCurUser() {
        User user = authBiz.getCurUser(loginDo.getAccessToken());
        assert !ObjectUtils.isEmpty(user);
    }

    @AfterEach
    public void tearDown() {
        if (!ObjectUtils.isEmpty(loginDo)) {
            authBiz.logout(loginDo.getAccessToken());
        }
    }

}

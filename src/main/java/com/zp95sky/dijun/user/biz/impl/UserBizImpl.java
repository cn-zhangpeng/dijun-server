package com.zp95sky.dijun.user.biz.impl;

import com.zp95sky.dijun.user.biz.UserBiz;
import com.zp95sky.dijun.user.dto.AddUserDto;
import com.zp95sky.dijun.user.entity.User;
import com.zp95sky.dijun.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class UserBizImpl implements UserBiz {

    private final UserService userService;

    @Override
    public Integer addUser(AddUserDto userDto) {
        User user =  buildUser(userDto.getNickname(), userDto.getMobile(), userDto.getEmail(), userDto.getPassword());
        userService.save(user);
        return user.getId();
    }

    private User buildUser(String nickname, String mobile, String email, String password) {
        return User.builder()
                .nickname(nickname).mobile(mobile).email(email)
                .password(password).createTime(LocalDateTime.now())
                .build();
    }

}

package com.zp95sky.dijun.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.dijun.user.entity.User;
import com.zp95sky.dijun.user.mapper.UserMapper;
import com.zp95sky.dijun.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

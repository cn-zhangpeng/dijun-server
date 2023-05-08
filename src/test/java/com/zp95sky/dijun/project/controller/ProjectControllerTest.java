package com.zp95sky.dijun.project.controller;

import cn.hutool.crypto.SecureUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.zp95sky.dijun.annotation.MockTestAnnotation;
import com.zp95sky.dijun.common.constant.CommonConstant;
import com.zp95sky.dijun.project.biz.ProjectBiz;
import com.zp95sky.dijun.project.dto.AddProjectDto;
import com.zp95sky.dijun.user.biz.AuthBiz;
import com.zp95sky.dijun.user.domain.LoginDo;
import com.zp95sky.dijun.user.dto.LoginDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockTestAnnotation
@Slf4j
public class ProjectControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private AuthBiz authBiz;

    @Resource
    private ProjectBiz projectBiz;

    private final Faker faker = new Faker(Locale.CHINA);

    private LoginDo loginDo;

    @BeforeEach
    public void init() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("user1@email.com");
        loginDto.setPassword(SecureUtil.md5("123456"));
        loginDo = authBiz.login(loginDto);
    }

    @SneakyThrows
    @Test
    public void testAddProject () {
        AddProjectDto projectDto = new AddProjectDto();
        projectDto.setName(faker.lorem().characters(10));
        projectDto.setCoverImage("https://img1.baidu.com/it/u=413643897,2296924942&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500");

        String projectStr = new ObjectMapper().writeValueAsString(projectDto);
        MvcResult mvcResult = mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(CommonConstant.TOKEN_HEADER_NAME, CommonConstant.TOKEN_PRE + loginDo.getAccessToken())
                        .content(projectStr))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        log.info("project id: {}", result);
        assert !ObjectUtils.isEmpty(result);

        projectBiz.deleteProject(Integer.valueOf(result));
    }

    @AfterEach
    public void tearDown() {
        if (!ObjectUtils.isEmpty(loginDo)) {
            authBiz.logout(loginDo.getAccessToken());
        }
    }

}

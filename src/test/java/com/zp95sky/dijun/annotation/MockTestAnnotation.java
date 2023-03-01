package com.zp95sky.dijun.annotation;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.lang.annotation.*;

/**
 * Mock 测试注解
 * @author 山海紫穹
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@BaseTestAnnotation
@AutoConfigureMockMvc
public @interface MockTestAnnotation {
}

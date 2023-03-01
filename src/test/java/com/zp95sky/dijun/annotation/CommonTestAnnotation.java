package com.zp95sky.dijun.annotation;

import java.lang.annotation.*;

/**
 * 通用测试注解
 * @author 山海紫穹
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@BaseTestAnnotation
public @interface CommonTestAnnotation {
}

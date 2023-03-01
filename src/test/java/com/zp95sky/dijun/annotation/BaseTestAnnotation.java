package com.zp95sky.dijun.annotation;

import com.zp95sky.dijun.DiJunApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

/**
 * @author 山海紫穹
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SpringBootTest(classes = {DiJunApplication.class})
@ActiveProfiles({"test"})
@interface BaseTestAnnotation {
}

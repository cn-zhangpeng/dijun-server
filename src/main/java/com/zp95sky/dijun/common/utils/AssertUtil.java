package com.zp95sky.dijun.common.utils;

import com.zp95sky.dijun.common.exception.CustomException;
import lombok.SneakyThrows;
import org.springframework.util.ObjectUtils;

/**
 * 断言工具类
 */
public class AssertUtil {

    public AssertUtil() {}

    @SneakyThrows
    public static void notEmpty(Object str, String error) {
        if (ObjectUtils.isEmpty(str)) {
            throw new CustomException(error);
        }
    }

    @SneakyThrows
    public static void isTrue(boolean expression, String error) {
        if (!expression) {
            throw new CustomException(error);
        }
    }

}

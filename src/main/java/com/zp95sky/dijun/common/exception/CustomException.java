package com.zp95sky.dijun.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends Exception {

    private final String code;

}

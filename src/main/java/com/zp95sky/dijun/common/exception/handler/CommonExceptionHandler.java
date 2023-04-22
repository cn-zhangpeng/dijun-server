package com.zp95sky.dijun.common.exception.handler;

import com.zp95sky.dijun.common.constant.ErrorConstant;
import com.zp95sky.dijun.common.exception.CustomException;
import com.zp95sky.dijun.common.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 异常处理
 * @author 山海紫穹
 */
@ControllerAdvice
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class CommonExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse resolveException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        if (e instanceof UndeclaredThrowableException) {
            Throwable throwable = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
            if (throwable instanceof CustomException) {
                return handleCustomException(response, (CustomException) throwable);
            }
        }
        if (e instanceof CustomException) {
            return handleCustomException(response, (CustomException) e);
        }

        String requestUri = request.getRequestURI();
        log.error(" >>>>>> " + requestUri + " error !", e);
        String code = ErrorConstant.COMMON_INTERNAL_SERVER_ERROR;
        String msg = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ErrorResponse.builder().code(code).msg(msg).build();
    }

    private ErrorResponse handleCustomException(HttpServletResponse response, CustomException exception) {
        String code = exception.getCode();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // token失效，返回401
        if (ErrorConstant.COMMON_TOKEN_INVALID.equals(code)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }

        String msg = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        return ErrorResponse.builder().code(code).msg(msg).build();
    }

}

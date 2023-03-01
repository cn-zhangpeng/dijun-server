package com.zp95sky.dijun.common.exception.handler;

import com.zp95sky.dijun.common.response.BaseResponse;
import com.zp95sky.dijun.common.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 * @author 山海紫穹
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse<Void> resolveException(HttpServletRequest request, Exception e) {
        String requestUri = request.getRequestURI();
        log.error(" >>>>>> " + requestUri + " error !", e);
        return ResponseUtil.buildGeneralResultError();
    }

}

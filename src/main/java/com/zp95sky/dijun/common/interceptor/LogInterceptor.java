package com.zp95sky.dijun.common.interceptor;

import cn.hutool.core.lang.Snowflake;
import com.zp95sky.dijun.common.constant.CommonConstant;
import com.zp95sky.dijun.common.constant.ErrorConstant;
import com.zp95sky.dijun.common.utils.AssertUtil;
import com.zp95sky.dijun.common.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 针对日志打印 traceId
 * @author 山海紫穹
 */
@Component
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LogInterceptor implements HandlerInterceptor {

    private final Snowflake snowflake;
    private final RedisUtil redisUtil;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${service.login.white-list}")
    private List<String> whiteList;

    @SneakyThrows
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        ThreadContext.put("traceId", snowflake.nextIdStr());

        // 白名单中，直接放行
        String requestUri = request.getRequestURI().replace(contextPath, "");
        if (whiteList.contains(requestUri)) {
            return true;
        }

        // token检测
        tokenCheck(request);

        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
        ThreadContext. remove(CommonConstant.TRACE_ID);
    }

    @SneakyThrows
    private void tokenCheck(HttpServletRequest request) {
        String token = request.getHeader(CommonConstant.TOKEN_HEADER_NAME);
        AssertUtil.notEmpty(token, ErrorConstant.COMMON_TOKEN_INVALID);
        AssertUtil.isTrue(token.startsWith(CommonConstant.TOKEN_PRE), ErrorConstant.COMMON_TOKEN_INVALID);

        String realToken = token.replace(CommonConstant.TOKEN_PRE, CommonConstant.EMPTY_STRING);
        AssertUtil.notEmpty(realToken, ErrorConstant.COMMON_TOKEN_INVALID);

        AssertUtil.isTrue(redisUtil.exists(realToken), ErrorConstant.COMMON_TOKEN_INVALID);
    }

}

package com.zp95sky.dijun.common.response;

import com.zp95sky.dijun.common.enums.ResponseCodeEnum;

import java.util.Collections;
import java.util.List;

/**
 * 返回工具类
 * @author 山海紫穹
 */
public class ResponseUtil {

    private ResponseUtil() {
    }

    public static <T> BaseResponse<T> buildResultSuccess(T data) {
        BaseResponse<T> result = new BaseResponse<>();
        result.setData(data);
        ResponseCodeEnum response = ResponseCodeEnum.SUCCESS;
        result.setCode(response.getCode());
        result.setMsg(response.getMsg());
        return result;
    }

    public static <T> BaseResponse<T> buildPageResultEmpty(Integer page, Integer pageSize) {
        return buildPageResultSuccess(page, pageSize, 0L, Collections.emptyList());
    }

    public static <T> BaseResponse<T> buildPageResultSuccess(Integer page, Integer pageSize, Long total, List<T> data) {
        BasePageData<T> pageData = new BasePageData<>();
        pageData.setPage(page);
        pageData.setPageSize(pageSize);
        pageData.setTotal(total);
        pageData.setData(data);

        BaseResponse<T> result = new BaseResponse<>();
        ResponseCodeEnum response = ResponseCodeEnum.SUCCESS;
        result.setCode(response.getCode());
        result.setMsg(response.getMsg());
        result.setData(pageData);
        return result;
    }

    public static <T> BaseResponse<T> buildResultSuccess() {
        return buildResultSuccess(null);
    }

    public static <T> BaseResponse<T> buildCustomError(ResponseCodeEnum codeEnum) {
        BaseResponse<T> result = new BaseResponse<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        return result;
    }

    public static BaseResponse<Void> buildGeneralResultError() {
        return buildCustomError(ResponseCodeEnum.ERROR_SYSTEM_ERROR);
    }

}

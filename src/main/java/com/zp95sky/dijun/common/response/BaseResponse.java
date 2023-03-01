package com.zp95sky.dijun.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 通用返回
 * @author 山海紫穹
 */
@ApiModel(value = "BaseResult<T> 通用返回格式", description = "通用返回格式")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResponse<T> {

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("提示信息")
    private String msg;

    @ApiModelProperty("请求响应数据")
    private Object data;

}

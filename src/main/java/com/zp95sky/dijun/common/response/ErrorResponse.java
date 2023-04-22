package com.zp95sky.dijun.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 通用返回
 * @author 山海紫穹
 */
@ApiModel(value = "ErrorResponse", description = "错误状态返回格式")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class ErrorResponse {

    @ApiModelProperty("错误码")
    private String code;

    @ApiModelProperty("提示信息")
    private String msg;

}

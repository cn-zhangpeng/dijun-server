package com.zp95sky.dijun.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "LoginDo", description = "登录用户信息")
@Data
@Builder
public class LoginDo {

    @ApiModelProperty(value = "用户ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "用户昵称", required = true)
    private String nickname;

    @ApiModelProperty(value = "Token", required = true)
    private String accessToken;

}

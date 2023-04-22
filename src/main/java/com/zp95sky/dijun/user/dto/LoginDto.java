package com.zp95sky.dijun.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "LoginDto", description = "登录信息")
@Data
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LoginDto {

    @NotEmpty
    @ApiModelProperty(value = "邮件地址", required = true)
    private String email;

    @NotEmpty
    @ApiModelProperty(value = "住类名", required = true)
    private String password;

}

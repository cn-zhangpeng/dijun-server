package com.zp95sky.dijun.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "AddUserDto", description = "添加用户参数")
@Data
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class AddUserDto {

    @ApiModelProperty(value = "用户昵称", required = true)
    @NotEmpty(message = "用户昵称不能为空")
    private String nickname;

    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "邮箱", required = true)
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

}

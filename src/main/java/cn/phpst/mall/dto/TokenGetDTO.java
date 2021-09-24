package cn.phpst.mall.dto;


import cn.phpst.mall.core.enumeration.LoginType;
import cn.phpst.mall.validators.TokenPassword;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter

public class TokenGetDTO {
    @NotBlank(message = "account不允许空")
    private String account;
    @TokenPassword(max = 30,message = "{token.password}")
    private String password;
    private LoginType loginType;
}

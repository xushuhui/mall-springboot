package cn.phpst.mall.dto;


import cn.phpst.mall.enumeration.LoginType;
import cn.phpst.mall.validators.TokenPassword;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

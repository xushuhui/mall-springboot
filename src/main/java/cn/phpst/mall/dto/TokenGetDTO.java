package cn.phpst.mall.dto;

import com.lin.missyou.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
@Getter
@PasswordEqual(message = "两次密码不相同")
public class TokenGetDTO {
    @Length(min=2, max=10, message = "xxxxx")
    private String name;
    private Integer age;

//@PasswordEqual

    private String password1;
    private String password2;
}

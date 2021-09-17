package cn.phpst.mall.validators;

import javax.validation.Payload;

public @interface PasswordEqual {
    String message() default "password not equal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

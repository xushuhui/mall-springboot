package cn.phpst.mall.validators;

public @interface PasswordEqual() {
    String message() default "password not equal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
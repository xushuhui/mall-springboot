package cn.phpst.mall.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordEqual,String> {

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
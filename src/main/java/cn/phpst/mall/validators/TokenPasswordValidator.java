package cn.phpst.mall.validators;

import cn.phpst.mall.dto.TokenGetDTO;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenPasswordValidator implements ConstraintValidator<TokenPassword, String> {
    private int min;
    private int max;
    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)){
            return true;
        }
        return s.length() >= this.min && s.length() <= this.max;
    }
    //第二个：自定义注解修饰的目标的类型
}

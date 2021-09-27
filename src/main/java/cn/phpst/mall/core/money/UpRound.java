package cn.phpst.mall.core.money;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class UpRound implements IMoneyDiscount {
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actualAmount = original.multiply(discount);
        BigDecimal finalAmount = actualAmount.setScale(2, RoundingMode.UP);
        return finalAmount;
    }
}

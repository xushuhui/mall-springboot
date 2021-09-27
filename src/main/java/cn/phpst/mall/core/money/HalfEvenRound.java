package cn.phpst.mall.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class HalfEvenRound implements IMoneyDiscount {
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actualAmount = original.multiply(discount);
        BigDecimal finalAmount = actualAmount.setScale(2, RoundingMode.HALF_EVEN);
        return finalAmount;
    }
}

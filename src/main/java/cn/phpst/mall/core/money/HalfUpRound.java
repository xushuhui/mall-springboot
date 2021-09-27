package cn.phpst.mall.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HalfUpRound implements IMoneyDiscount {
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actualAmount = original.multiply(discount);
        BigDecimal finalAmount = actualAmount.setScale(2, RoundingMode.HALF_UP);
        return finalAmount;
    }
}

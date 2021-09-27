package cn.phpst.mall.bo;

import cn.phpst.mall.dto.SkuInfoDTO;
import cn.phpst.mall.model.Sku;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SkuOrderBO {
    private BigDecimal actualPrice;
    private Integer count;
    private Long categoryId;

    public SkuOrderBO(Sku sku, SkuInfoDTO skuInfoDTO) {
        this.actualPrice = null;
        this.count = skuInfoDTO.getCount();
        this.categoryId = sku.getCategoryId();

    }

    public BigDecimal getTotalPrice() {
        return actualPrice.multiply(new BigDecimal(this.count));
    }
}

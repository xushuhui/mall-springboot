package cn.phpst.mall.model;


import cn.phpst.mall.dto.SkuInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter

public class OrderSku {

    private Long id;
    private Long spuId;
    private BigDecimal finalPrice;
    private BigDecimal singlePrice;
    private List<String> specValues;

    public OrderSku(SkuInfoDTO skuInfoDTO, Sku sku, List<String> specValues) {
        this.id = sku.getId();
        this.spuId = sku.getSpuId();
        this.finalPrice = sku.getActualPrice().multiply(new BigDecimal(skuInfoDTO.getCount()));
        this.singlePrice = sku.getActualPrice();
        this.specValues = specValues;
        this.count = skuInfoDTO.getCount();
        this.img = sku.getImg();
        this.title = sku.getTitle();
    }

    private Integer count;
    private String img;
    private String title;


}
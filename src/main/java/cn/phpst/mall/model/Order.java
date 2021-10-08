package cn.phpst.mall.model;


import cn.phpst.mall.dto.OrderAddressDTO;
import cn.phpst.mall.util.GenericAndJson;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name = "`order`")
@Where(clause = "delete_time is null ")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal totalPrice;
    private Integer totalCount;
    private String snapImg;
    private String snapTitle;
    private String snapItems;
    private String snapAddress;
    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Integer status;

    public void setSnapAddress(OrderAddressDTO address) {
        this.snapAddress = GenericAndJson.objectToJson(address);
    }

    public void setSnapItems(List<OrderSku> orderSkuList) {
        if (orderSkuList.isEmpty()) {
            return;
        }
        this.snapItems = GenericAndJson.objectToJson(orderSkuList);
    }

    public List<OrderSku> getSnpItems() {
        List<OrderSku> list = GenericAndJson.jsonToObject(this.snapItems, new TypeReference<List<OrderSku>>() {
        });
        return list;
    }

    public OrderAddressDTO getSnapAddress() {
        if (this.snapAddress == null) {
            return null;
        }
        OrderAddressDTO o = GenericAndJson.jsonToObject(this.snapAddress, new TypeReference<OrderAddressDTO>() {
        });
        return o;
    }
}
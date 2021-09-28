package cn.phpst.mall.model;

import cn.phpst.mall.util.ListAndJson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null ")
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;
    private Long categoryId;
    private Long rootCategoryId;

    @Convert(converter = ListAndJson.class)
    private List<Object> specs;
    private String code;
    private Integer stock;

    public BigDecimal getActualPrice() {
        return discountPrice == null ? this.price : this.discountPrice;
    }
//    public List<Spec> getSpecs(){
//        if (this.specs == null){
//            return Collections.emptyList();
//        }
//        return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>());
//    }
}

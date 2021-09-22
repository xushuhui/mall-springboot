package cn.phpst.mall.model;

import cn.phpst.mall.util.MapAndJson;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Where(clause = "delete_time is null")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String openid;

    private String nickname;

    private String email;

    private String mobile;

    private String password;

    private Long unifyUid;

    private String group;
    @Convert(converter = MapAndJson.class)
    private Map<String, Object> wxProfile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userCoupon", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "couponId"))
    private List<Coupon> couponList;
}
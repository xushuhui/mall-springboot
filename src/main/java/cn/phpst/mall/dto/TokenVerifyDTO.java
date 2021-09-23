
package cn.phpst.mall.dto;
import lombok.*;

@Builder
@Getter

public class TokenVerifyDTO {
    @NotBlank(message = "token不允许空")
    private String token;
   
}
package cn.phpst.mall.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UnifyResponse {
    private Integer Code;
    private String Message;
}

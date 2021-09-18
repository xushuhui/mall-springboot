package cn.phpst.mall.api;

import cn.phpst.mall.dto.TokenGetDTO;
import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.model.Spu;
import cn.phpst.mall.service.WechatAuthenticationService;
import cn.phpst.mall.vo.SpuSimplifyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")

public class TokenController {
    @Autowired
    WechatAuthenticationService wechatAuthenticationService;

    @PostMapping("")
    public Map<String,String> getToken(@RequestBody @Validated TokenGetDTO data) {
        Map<String,String> map = new HashMap<>();
        String token = null;
        switch (data.getLoginType()){
            case Wechat:
                wechatAuthenticationService.code2Session(data.getAccount());
                break;
            case Email:
                break;
            default:
                throw new NotFoundException(10003);
        }
        return map;
    }

}

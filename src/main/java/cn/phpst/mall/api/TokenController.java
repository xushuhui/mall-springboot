package cn.phpst.mall.api;

import cn.phpst.mall.dto.TokenGetDTO;
import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.service.WechatAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")

public class TokenController {
    @Autowired
    WechatAuthenticationService wechatAuthenticationService;

    @PostMapping("")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDTO data) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (data.getLoginType()) {
            case Wechat:
                token = wechatAuthenticationService.code2Session(data.getAccount());
                break;
            case Email:
                break;
            default:
                throw new NotFoundException(10003);
        }
        map.put("token", token);
        return map;
    }
    @PostMapping("/verify")
    public Map<String, Boolean> getToken(@RequestBody @Validated TokenVerifyDTO data) {
            Map<String, Boolean> map = new HashMap<>();
            Boolean valid = JwtToken.verifyToken(data.getToken());
            map.put("is_valid", valid);
            return map;
    }
}

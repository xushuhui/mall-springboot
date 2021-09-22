package cn.phpst.mall.service;

import cn.phpst.mall.dto.WechatSessionDTO;
import cn.phpst.mall.exception.http.ParameterException;
import cn.phpst.mall.model.User;
import cn.phpst.mall.repository.UserRepository;
import cn.phpst.mall.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class WechatAuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Value("{$wechat.code2session}")
    private String code2SessionUrl;

    @Value("{$wechat.appid}")
    private String appid;
    @Value("{$wechat.appsecret}")
    private String appsecret;

    public String code2Session(String code) {
        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.appsecret, code);
        RestTemplate rest = new RestTemplate();
        WechatSessionDTO session = rest.getForObject(url, WechatSessionDTO.class);


        return this.registerUser(session);
    }

    private String registerUser(WechatSessionDTO session) {
        String openid = session.getOpenid();
        if (openid == null) {
            throw new ParameterException(20004);
        }
        Optional<User> userOptional = this.userRepository.findByOpenid(openid);
        if (userOptional.isPresent()) {
            return JwtToken.makeToken(userOptional.get().getId());
        }
        User user = User.builder().openid(openid).build();
        userRepository.save(user);
        return JwtToken.makeToken(user.getId());
    }
}

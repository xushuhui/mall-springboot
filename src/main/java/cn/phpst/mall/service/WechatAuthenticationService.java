package cn.phpst.mall.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.Map;

@Service
public class WechatAuthenticationService {
    @Autowired
    private ObjectMapper mapper;

    @Value("{$wechat.code2session}")
    private String code2SessionUrl;

    @Value("{$wechat.appid}")
    private String appid;
    @Value("{$wechat.appsecret}")
    private String appsecret;
    public String code2Session(String code){
        String url = MessageFormat.format(this.code2SessionUrl,this.appid,this.appsecret,code);
        RestTemplate rest = new RestTemplate();
        String sessionText = rest.getForObject(url,String.class);
        try {
            Map<String,Object> session = mapper.readValue(sessionText,Map.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

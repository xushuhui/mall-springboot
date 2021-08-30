package cn.phpst.mall.core.configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@PropertySource(value = "classpath:config/codes.properties")
@Component
public class ExceptionCodeConfiguration {
    private Map<Integer,String> codes = new HashMap<>();

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public String getMessage(int code){
        String message = codes.get(code);
        return message;
    }
}

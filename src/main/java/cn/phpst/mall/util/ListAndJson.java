package cn.phpst.mall.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.phpst.mall.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Converter
public class ListAndJson implements AttributeConverter<List<Object>, String> {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(List<Object> objects) {
        try {
            return mapper.writeValueAsString(objects);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object> convertToEntityAttribute(String s) {
        try {
            if(s == null){
                return null;
            }
            List<Object> t = mapper.readValue(s, List.class);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}

package cn.phpst.mall.util;

import cn.phpst.mall.exception.http.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Converter;
import java.util.List;

@Converter
public class GenericAndJson {

    private static ObjectMapper mapper;

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o) {
        try {
            return GenericAndJson.mapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    public static <T> T jsonToObject(String s,  TypeReference<T> tr) {
        if (s == null) {
            return null;
        }
        try {
            T o = GenericAndJson.mapper.readValue(s, tr);
            return o;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

   public static <T> List<T> jsonToList(String s ) {
       if (s == null) {
           return null;
       }
       try {
//            T.class
           List<T> list = GenericAndJson.mapper.readValue(s, new TypeReference<List<T>>() {
           });
           return list;
       } catch (JsonProcessingException e) {
           e.printStackTrace();
           throw new ServerErrorException(9999);
       }
   }

   public static <T> T jsonToList(String s, TypeReference<T> tr) {
       if (s == null) {
           return null;
       }
       try {
           T list = GenericAndJson.mapper.readValue(s, tr);
           return list;
       } catch (JsonProcessingException e) {
           e.printStackTrace();
           throw new ServerErrorException(9999);
       }
   }
}


package com.jrx.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;


/**
 * @Author leek
 * @Date 2019-10-23 下午1:50
 * @Version 1.0
 * @Description
 */
public class JsonUtils {
    private static ObjectMapper mapper = null;
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    static {
        mapper = new ObjectMapper();
        mapper.setLocale(Locale.getDefault());
        mapper.setTimeZone(TimeZone.getDefault());
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static ObjectMapper getMapper() {
        if (null == mapper) {
            mapper = new ObjectMapper();
            mapper.setLocale(Locale.getDefault());
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        }
        return mapper;
    }

    public static String toString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("JSON转换异常{}", e);
            return "";
        }

    }


    public static <T> T toObjectBean(String jsonStr, Class<T> objClass) throws JsonParseException, JsonMappingException, IOException {
        return mapper.readValue(jsonStr, objClass);

    }
}

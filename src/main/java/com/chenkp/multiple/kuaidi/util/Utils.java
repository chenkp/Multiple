package com.chenkp.multiple.kuaidi.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Utils {

    public static String ObjToStr(Object obj)
    {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public static Map<String, Object> strToObject(String JsonStr, Class<?> cls)
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> obj = null;
        try
        {
            obj = (Map)mapper.readValue(JsonStr, cls);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return obj;
    }

    public static boolean isNull(String str)
    {
        if ((str != null) && (!"".equals(str))) {
            return false;
        }
        return true;
    }
}

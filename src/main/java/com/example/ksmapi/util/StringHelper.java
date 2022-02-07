package com.example.ksmapi.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class StringHelper {

    public static boolean isEmptyorNull(String str) {
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str) {
        if (isEmptyorNull(str)) return "";
        else return str;
    }
    public static Boolean isEmpty(Object object, int numberTobeNotNull) throws IllegalAccessException {
        for(Field field : object.getClass().getDeclaredFields()){
            Object result = field.get(object);
            System.out.printf("field: %s, data: %s ",field,result);
           if(result.equals("")){
               return false;
           }
        }
        return false;
    }

    public static boolean isValidInt(String str) {
        return StringUtils.isNumeric(str);
    }
}

package com.example.ksmapi.util;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenericHelper {
    public String getId(Class<?> aClass) {
        String upperLetter="";
        String className = getClassName(aClass);

        for(int i=0;i<className.length();i++){
            if(Character.isUpperCase(className.charAt(i)))
            {
                upperLetter+=""+className.charAt(i);
            }
        }
        return generateRandomGivenSuffix(upperLetter);
        /**
         * Your implementation goes here
         *
         * INSTRUCTION
         * 1. Remove line 17 [throw new UnsupportedOperationException("Not yet supported!");]
         * 2. Get the capitalized letter(s) from the className and return it.
         */
    }
    public static String generateRandomGivenSuffix(String suffix) {
        return suffix + "-" + UUID.randomUUID().toString();
    }
    public static String getClassName(Class<?>  aClass) {
        return aClass.getSimpleName();
    }


    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static int generateRandomNumberGivenUpperLimit(int upperLimit) {
        return RandomUtils.nextInt(0, upperLimit);
    }

    public static boolean isValidEnum(String type, Class enumClass) {
        return EnumUtils.isValidEnum(enumClass, type);
    }

    public static boolean isValidEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }
}

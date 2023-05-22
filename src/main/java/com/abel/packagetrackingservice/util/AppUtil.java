package com.abel.packagetrackingservice.util;

import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.Random;

public class AppUtil {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    public String generateAddressId(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }


    public static String sanitize(String data) {
        if (data.contains("_")) {
            data = data.replace("_", " ");
        } else if (data.contains("-")) {
            data = data.replace("-", " ");
        }
        return StringUtils.capitalize(data);
    }

//
//    public static <T> T sanitizeObject(Object object, Class<T> classOfT){
//        Gson gson = new Gson();
//        String json = Jsoup.clean(StringEscapeUtils.escapeHtml4(gson.toJson(object)), Safelist.basic());
//        return gson.fromJson(json, classOfT);
//    }

}

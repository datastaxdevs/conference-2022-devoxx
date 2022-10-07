package com.datastaxdev.utils;

public class ValidationUtils {
    
    public static void assertNotEmpty(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("This string parameter cannot be null nor empty");
        }
    }
    
    public static void assertNotNull(Object str) {
        if (str == null) {
            throw new IllegalArgumentException("This parameter cannot be null ");
        }
    }

}

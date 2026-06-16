package com.bank.mobile.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtil {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(
            "mobile-bank-message",
            Locale.of("fa")
    );

    public static String getMessage(String key) {
        try {
            return BUNDLE.getString(key);
        } catch (Exception e) {
            return "Key not found: " + key;
        }
    }

    public static String getMessage(String key, Object... args) {
        String pattern = getMessage(key);
        return MessageFormat.format(pattern, args);
    }
}
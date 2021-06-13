package com.example.luxpmtestapp;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {


    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";

    public static boolean isValidEmail(String target) {

        Matcher matcher = getPattern(EMAIL_PATTERN).matcher(target);
        return matcher.matches();
    }

    public static boolean isValidPass(String target) {

        Matcher matcher = getPattern(PASSWORD_PATTERN).matcher(target);
        return matcher.matches();

    }

    private static Pattern getPattern(String pattern) {

        return Pattern.compile(pattern);
    }
}

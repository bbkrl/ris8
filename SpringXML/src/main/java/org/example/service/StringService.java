package org.example.service;

import java.util.Locale;

public class StringService {
    String str;

    public StringService(String str) {
        this.str = str;
    }

    public String findSubstr(String substr) {
        substr = substr.toLowerCase();
        str = str.toLowerCase();
        if (str.contains(substr)) {
            str = str.toLowerCase();
            for (int i = 0; i < str.length() - substr.length(); i++) {
                if (str.startsWith(substr, i)) {
                    str = str.substring(0, i) + str.substring(i, i + substr.length()).toUpperCase(Locale.ROOT) + str.substring(i + substr.length());
                    break;
                }
            }
            return str;
        } else {
            return "No such substring found!";
        }
    }
}
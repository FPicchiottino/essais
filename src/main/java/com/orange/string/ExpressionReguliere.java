package com.orange.string;

import java.util.regex.Pattern;

public class ExpressionReguliere {
    public static void main(String... args) {
        String pattern1 = "https://.*/.*$";
        String pattern2 = "^(http|https)://.*\\.fr";
        String pattern3 = "^(http|https)://.*\\.fr";

        // Vérification des pattern avant test
        Pattern.compile(pattern1);
        Pattern.compile(pattern2);
        Pattern.compile(pattern3);

        // Test de chaque URL sur chacun des 3 patterns
        for (String url : args) {
            System.out.println("URL : " + url);

            boolean match1 = url.matches(pattern1);
            boolean match2 = url.matches(pattern2);
            boolean match3 = url.matches(pattern3);

            String result1 = match1 ? "Pattern 1 OK" : "Ne correspond pas au pattern 1";
            String result2 = match2 ? "Pattern 2 OK" : "Ne correspond pas au pattern 2";
            String result3 = match3 ? "Pattern 3 OK" : "Ne correspond pas au pattern 3";

            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
        }
    }
}

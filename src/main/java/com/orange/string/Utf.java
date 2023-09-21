package com.orange.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Utf {
    public static void main(String... args) {
        String origine = "�tre r�cup�r�";
        String convertie = "";

        try {
            convertie = URLDecoder.decode(origine, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Chaîne d'origine = " + origine);
        System.out.println("Chaîne convertie en UTF-8 = " + convertie);
    }
}

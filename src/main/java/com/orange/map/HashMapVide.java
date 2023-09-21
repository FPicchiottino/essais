package com.orange.map;

import java.util.HashMap;

public class HashMapVide {
    public static void main(String... args){
        HashMap<String, String> parametres = new HashMap<String, String>();

        parametres.put("cle1", "valeur 1");
        parametres.put("cle2", "valeur 2");

        String val3 = parametres.get("cle3");

        System.out.println("Valeur 3 = " + val3);
    }
}

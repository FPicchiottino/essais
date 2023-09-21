package com.orange.generic;

public class TestClasseGenerique {

    public static void main(String... args) {
        MaClasseGenerique<Integer, String> maClasse = new MaClasseGenerique<Integer, String>(1, "Valeur 1");

        Integer param1 = maClasse.getParam1();
        String param2 = maClasse.getParam2();
    }
}

package com.orange.string;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Coordonnee {
    public static void main(String... args){
        String coordOri = "45,23592410";
        String coordConv = coordOri;

        Double d = Double.parseDouble(coordOri.replaceAll(",", "."));
        NumberFormat f = new DecimalFormat("###.#######", new DecimalFormatSymbols(Locale.ENGLISH));
        coordConv = f.format(d);

        System.out.println("Coordonnée d'origine : " + coordOri);
        System.out.println("Coordonnée convertie : " + coordConv);
    }
}

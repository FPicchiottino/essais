package com.orange.coordonnees;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Tronquer {

    public static void main(String... args){
        String coord_x = "5415.51284898742368";
//        String coord_x = "";

//        System.out.println("Coordonnée d'origine = " + coord_x);
//        System.out.println("Coordonnée réduite = " + Tronquer.getCoordByFormat(coord_x));

        System.out.println("coord_x = " + coord_x);
        System.out.println("Convertie -> " + Tronquer.formaterCoordPourHisto(coord_x));
    }

    public static String getCoordByFormat(String coord){
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat df = (DecimalFormat) nf;

        df.setMaximumIntegerDigits(3);
        df.setMaximumFractionDigits(7);

        return df.format(Float.parseFloat(coord));
    }

    public static String formaterCoordPourHisto(String coord) {
        if ( coord != null && ! "".equals(coord) ) {
            try {
                NumberFormat f = new DecimalFormat("###.#######", new DecimalFormatSymbols(Locale.US));
                return f.format(Double.parseDouble(coord.replaceAll(",", ".")));
            } catch(NumberFormatException e) {
                return "null";
            }
        }

        return "null";
    }

}

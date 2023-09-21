package com.orange.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComparerDates {
    public static void main(String... args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date aujourdhui = new Date();
        Date d = null;
        try {
            d = sdf.parse(args[0]);
            System.out.println("Date du jour = " + sdf.format(aujourdhui));
            System.out.println("Date à comparer = " + sdf.format(d));

            if ( d.compareTo(aujourdhui) < 0 )
                System.out.println("Date du jour supérieure à la date passée en paramètre");
            else
                System.out.println("Date du jour inférieure ou égale à la date passée en paramètre");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

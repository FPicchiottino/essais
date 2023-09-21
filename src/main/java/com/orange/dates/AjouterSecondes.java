package com.orange.dates;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AjouterSecondes {
    public static void main(String... args){
        GregorianCalendar c = (GregorianCalendar) GregorianCalendar.getInstance();

//        c.add(Calendar.SECOND, 60);

        Date d1 = c.getTime();

        c.add(Calendar.SECOND, 300);

        Date d2 = c.getTime();
    }
}

package com.orange.dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormaterDate {
    public static void main(String... args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date d = new Date();

        System.out.println("Date système au format dd/MM/yyyy = " + sdf.format(d));
    }
}

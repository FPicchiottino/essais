package com.orange.sql;

import java.util.ArrayList;
import java.util.List;

public class OrListe {
    private static String getSQLJalons(List<String> jalons) {
        String sql = "";

        int i = 0;
        if ( ( jalons != null ) && (jalons.size() >0) ) {

            for (String j : jalons) {
                sql += (i == 0) ? " AND ( " : " OR ";
                sql += "JALONS LIKE '%" + j + "%'";

                i += 1;
            }

            sql += " ) ";
        }

        return sql;
    }

    public static void main(String... args) {
        List<String> liste = new ArrayList<String>();

        liste.add("jalon1");

        String sql = getSQLJalons(liste);

        System.out.println("SQL = " + sql);
    }
}

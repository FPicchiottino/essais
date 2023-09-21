package com.orange.string;

public class DecouperChaine {
//
//    public static void tronquerFloat(String f){
//        int posV = f.indexOf(",");
//        int posP = f.indexOf(".");
//
//        String newF = "";
//
//        if ( posV > 3 || posP > 3) {
//            newF = f.su
//        }
//
//        System.out.println(("Position virgule = " + posV));
//        System.out.println(("Position point = " + posP));
//    }

    public static void main(String... args) {
        String s = "commune,FCG|18/01/2023,FCT|29/06/2022";

        int pos = s.indexOf(",");

        String t = s.substring(pos+1);

        System.out.println("s = " + s);
        System.out.println("pos = " + pos);
        System.out.println("t = " + t);
//
//        DecouperChaine.tronquerFloat("352.152");
    }
}

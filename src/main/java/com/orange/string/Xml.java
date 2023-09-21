package com.orange.string;

public class Xml {
    public static void main(String... args) {
        String chaine = "<xml><blabla><ns2:codeEtape>4</ns2:codeEtape><ns2:codeSousEtape>A</ns2:codeSousEtape>";

        int debutEtape = chaine.indexOf("<ns2:codeEtape>");
        int debutSousEtape = chaine.indexOf("<ns2:codeSousEtape>");

        String etape = chaine.substring(debutEtape + 15, debutEtape + 16);
        String sousEtape = chaine.substring(debutSousEtape + 19, debutSousEtape + 20);

        System.out.println("Etape = " + etape);
        System.out.println("Sous Etape = " + sousEtape);
    }
}

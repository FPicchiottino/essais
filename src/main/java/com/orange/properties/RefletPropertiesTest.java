package com.orange.properties;

public class RefletPropertiesTest {
    public static void main(String... args) {
        RefletProperties rp = RefletProperties.getInstance();

        RefletProperties rp2 = RefletProperties.getInstance();

        System.out.println(rp.get("client.nom") + " " + rp.get("client.prenom") + " né le " + rp.get("client.dateNaissance"));
        System.out.println(rp2.get("client.nom") + " " + rp2.get("client.prenom") + " né le " + rp2.get("client.dateNaissance"));
    }
}

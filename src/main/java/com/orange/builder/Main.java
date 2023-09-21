package com.orange.builder;

public class Main {
    public static void main(String... args) {

//        User user1 = new User("PICCHIOTTINO", "François", "0633701037", "154 chemin des Croses 38530 BARRAUX");
//        User user2 = new User("CHABERT", "Marie-Blanche", null, null);

        User user2 = new User.UserBuilder()
                .withLastName("CHABERT")
                .withFirstName("Marie-Blanch")
                .build();
    }
}

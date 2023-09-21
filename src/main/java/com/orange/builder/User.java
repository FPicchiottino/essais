package com.orange.builder;

/**
 * Le Fluent Pattern Builder permet de construire un objet de manière partielle avec les informations dont on
 * dispose à sa création
 */
public class User {
    // Modèle
    private String lastName;
    private String firstName;
    private String phone;
    private String address;


    /**
     * Fluent Pattern Builder
     */
    public static class UserBuilder {
        // Le builder doit reprendre les propriétés du modèle qu'il représente
        private String lastName = "Nom indéfini";
        private String firstName = "Prénom indéfini";
        private String phone = "Téléphone indéfini";
        private String address = "Adresse indéfinie";

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            User user = new User();
            user.firstName = firstName;
            user.lastName = lastName;
            user.phone = phone;
            user.address = address;

            return user;
        }
    }


    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}

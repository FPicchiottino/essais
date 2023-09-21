package com.orange.jalons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DecouperJalons {

    /**
     *
     * @param args
     */
    public static void main(String... args){
        System.out.println("Test 1ère méthode :");
        System.out.println("-------------------");

        List<String> liste = new ArrayList<String>();
        liste.add("FCC|01/04/2022");
        liste.add("FCG|01/04/2022");
        liste.add("FCT|01/02/2023");

        String f = getJalonAdresseFermeeCuivreArcep("gp", liste);
        System.out.println("1. Jalon = " + f);

        f = getJalonAdresseFermeeCuivreArcep("", liste);
        System.out.println("2. Jalon = " + f);

        f = getJalonAdresseFermeeCuivreArcep("toto", liste);
        System.out.println("3. Jalon = " + f);

        f = getJalonAdresseFermeeCuivreArcep("toto", new ArrayList<String>());
        System.out.println("4. Jalon = " + f);

        System.out.println("");


        System.out.println("Test 2ème méthode :");
        System.out.println("-------------------");

        String j = getJalonAdresseFermeeCuivreArcep("gp", "FCC|01/04/2022,FCG|01/04/2022,FCT|01/02/2023", true);
        System.out.println("1. Jalon = " + j);

        j = getJalonAdresseFermeeCuivreArcep("gp", "", true);
        System.out.println("2. Jalon = " + j);

        j = getJalonAdresseFermeeCuivreArcep("gp", "FCC|01/05/2022,FCG|01/05/2022,FCT|01/02/2023", true);
        System.out.println("3. Jalon = " + j);

        j = getJalonAdresseFermeeCuivreArcep("", "FCC|01/05/2022,FCG|01/05/2022,FCT|01/02/2023", true);
        System.out.println("4. Jalon = " + j);

        j = getJalonAdresseFermeeCuivreArcep("toto", "FCC|01/05/2022,FCG|01/05/2022,FCT|01/02/2023", true);
        System.out.println("5. Jalon = " + j);
    }

    /**
     * Retourne le jalon prioritaire pour un profil
     *
     * @param profil profil du demandeur
     * @param jalons liste de jalons datés
     * @return
     */
    public static String getJalonAdresseFermeeCuivreArcep(String profil, List<String> jalons) {
        String jalon = "";

        String separateur = ",";

        // Liste des jalons prioritaires pour chaque liste en paramètre de la fonction
        String jalonsIntermediaires = "";

        if ( jalons != null ) {
            // Pour chaque liste de jalons datés
            for (String j : jalons) { // Exemple pour j: FCC|18/01/2022,FCG|01/02/2023
                // Le type de jalon est soit commune, soit adresse
                String typeJalon = j.split(separateur)[0];

                // Conservation des jalons
                String jal = j.substring(j.indexOf(separateur) + 1);

                // Identification du jalon prioritaire
                jalonsIntermediaires += ("".equals(jalonsIntermediaires) ? "" : separateur)
                        + getJalonAdresseFermeeCuivreArcep(profil, jal, true);
            }

            // On ne retient que le jalon prioritaire
            jalon = getJalonAdresseFermeeCuivreArcep(profil, jalonsIntermediaires, false); // Exemple pour
            // jalonsIntermediaires :
            // FCC|,FCG
        }

        // Retourne le jalon prioritaire
        return jalon;
    }

    /**
     * Retourne le jalon le plus élevé pour un profil et une liste de jalons donnés
     * (tient compte de la date échue ou non)
     *
     * @param profil       profil de l'appelant
     * @param jalons       liste de jalons daté ou non
     * @param verifierDate vérifier que la date des jalons est échue ou non
     * @return
     */
    private static String getJalonAdresseFermeeCuivreArcep(String profil, String jalons, boolean verifierDate) {
        // A ne traiter que si la liste de jalons est non vide
        if ((jalons != null) && !"".equals(jalons)) {
            // Récupération des priorités des jalons du profil
            String priorite = "FCT,FCG,FCC";

            // Récupération du format de date des jalons remontés en base
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date aujourdhui = new Date();

            List<String> listJalons = Arrays.asList(jalons.split(",")); // Exemple : FCC|18/01/2022,FCG|01/02/2023
            List<String> listPriorites = Arrays.asList(priorite.split(",")); // Exemple : FCC,FCG,FCT

            // Déroulement des jalons par priorité pour ne retenir que le premier
            for (String p : listPriorites) {
                // Déroulement des jalons
                for (String j : listJalons) {
                    if (j.contains(p)) {
                        // S'il faut vérifier que la date est échue pour le jalon trouvé
                        if (verifierDate) {
                            Date dateJalon;
                            try {
                                dateJalon = sdf.parse(j.split("\\|")[1]);

                                // Si la date du jalon est échue
                                if (aujourdhui.compareTo(dateJalon) >= 0)
                                    return j.split("\\|")[0];
                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } else {
                            return p;
                        }
                    }
                }
            }
        }

        return "";
    }

}

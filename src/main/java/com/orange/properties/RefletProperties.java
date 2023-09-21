package com.orange.properties;

//import org.apache.commons.lang.time.DateUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public final class RefletProperties {
    private static volatile RefletProperties instance = null;

    // Variables fonctionnelles
    private static Properties proprietes;
    private static Date dateMaj;   // Date de mise à jour

    private RefletProperties() {
        super();

        proprietes = new Properties();
        dateMaj = new Date();
    }

    /**
     * Recharge les informations présentes dans le fichier de propriétés
     */
    private static void loadFromFile() {
        try {
            // TODO améliorer l'accès au fichier de propriétés
            proprietes.load(new FileInputStream("/home/user/IdeaProjects/BidouillesIntelliJ/src/reflet.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recharge les informations depuis la base de données
     */
    private static void loadFromDatabase() {
    }

    private static void reload() {
       Date now = new Date();

        /*
         Si la date du jour est supérieure à la dernière mise à jour, rechargement du fichier de propriétés (<)

        if (DateUtils.truncatedCompareTo(dateMaj, now, Calendar.DAY_OF_MONTH) < 0) {
            loadFromFile();
        }*/
    }

    public String get(String propriete) {
        return (String)proprietes.get(propriete);
    }

    public static RefletProperties getInstance() {
        if (instance == null) {
            instance = new RefletProperties();
            loadFromFile();
        } else {
            reload();
        }

        return instance;
    }
}

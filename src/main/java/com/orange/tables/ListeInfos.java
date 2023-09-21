package com.orange.tables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListeInfos {
    public static void main(String[] args) {
        String input1 = "1=ROC;102=INCONNU;103=1;110=INCONNU;111=INCONNU;112=INCONNU;130=0,5:1|8:12;131=0,5:1|8:12;24=00154;26=038A;28=38027;35=INCONNU;39=INCONNU;";
        String input2 = "1=ROC;102=INCONNU;103=1;110=INCONNU;111=INCONNU;112=INCONNU;130=0,5:1|8:12;131=0,5:1|8:12;24=INCONNU;26=INCONNU;28=INCONNU;35=INCONNU;39=INCONNU;";
        String[] inputs = { input1, input2};

        String i24 = "INCONNU";
        String i26 = "INCONNU";
        String i28 = "INCONNU";

        String patternString = "(?<=24=)(\\w+)|(?<=26=)(\\w+)|(?<=28=)(\\w+)";
        Pattern pattern = Pattern.compile(patternString);

        for(String ip : inputs) {
            Matcher matcher = pattern.matcher(ip);

            while (matcher.find()) {
                if (matcher.group(1) != null && !"INCONNU".equals(matcher.group(1)))
                    i24 = matcher.group(1);

                if (matcher.group(2) != null && !"INCONNU".equals(matcher.group(2)))
                    i26 = matcher.group(2);

                if (matcher.group(3) != null && !"INCONNU".equals(matcher.group(3)))
                    i28 = matcher.group(3);
            }
        }

        System.out.println("Valeur de 24 : " + i24);
        System.out.println("Valeur de 26 : " + i26);
        System.out.println("Valeur de 28 : " + i28);
    }
}

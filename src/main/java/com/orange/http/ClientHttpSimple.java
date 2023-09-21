package com.orange.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class ClientHttpSimple {
    public static int getReponse(String url) {
        try {
            URL _url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 3128)));
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            conn.disconnect();

            return responseCode;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String... args) {
        System.out.println("Test de l'url : " + args[0]);

        int codeRetour = ClientHttpSimple.getReponse(args[0]);

        System.out.println("Code retour = " + codeRetour);
    }
}

package com.orange.booleen;

public class TestParse {
    public static void main(String[] args){
        boolean b = Boolean.parseBoolean("TRUE");

        if (b)
            System.out.println("OK, true");
        else
            System.out.println("KO, false");
    }
}

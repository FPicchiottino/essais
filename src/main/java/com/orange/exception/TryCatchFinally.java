package com.orange.exception;

public class TryCatchFinally {
    public static void main(String... args){
        try{
            int i = Integer.parseInt(args[0]);
            System.out.println(i);
        } catch(Exception e){
            System.out.println("Exception");
        } finally {
            System.out.println("Finally");
        }
    }
}

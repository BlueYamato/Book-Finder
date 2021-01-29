package com.example.bookfinderapp.api;

public class IPServerStatic {
    static String IP = "http://192.168.1.2:8080/";
    //static String IP = "http://192.168.100.2/";

    public static String getBaseIP(){
        String res = IP;
        res=res.replaceAll("http://","");
        res=res.replaceAll("/","");
        return res;
    }
}
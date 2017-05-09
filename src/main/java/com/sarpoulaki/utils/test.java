package com.sarpoulaki.utils;

/**
 * Created by admin on 5/9/2017.
 */
public class test {

    public static void main(String arg[]){
        EmailValidator em = new EmailValidator();
        String s = "email";
        System.out.println( em.validate(s));
    }
}

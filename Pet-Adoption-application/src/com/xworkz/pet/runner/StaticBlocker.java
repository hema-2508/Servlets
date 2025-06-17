package com.xworkz.pet.runner;

public class StaticBlocker {

    public static void test()
    {
        System.out.println("running static method...");
    }


    static {
        System.out.println("running static Block...");
        System.out.println("should use to init Static variables in a class ");
    }
}

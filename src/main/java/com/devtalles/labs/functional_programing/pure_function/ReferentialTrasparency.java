package com.devtalles.labs.functional_programing.pure_function;

public class ReferentialTrasparency {
    public static int triple(int x) {
        return x * 3;
    }

    public static void main(String[] args) {
        int response = triple(3) + 2; // rest -> 11 -- reduntante
        int calculate = 9 + 2; // rest -> 11 -- redundante

        System.out.println("Response 1: " + response);
        System.out.println("Response 2: " + calculate);
    }
}

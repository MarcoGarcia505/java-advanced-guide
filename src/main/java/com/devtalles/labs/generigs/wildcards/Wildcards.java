package com.devtalles.labs.generigs.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {

        List item = new ArrayList();
        item.add("TEST");
        item.add("LOCAL");
        item.add(10);
        item.add(false);

        printData(item);
        System.out.println("EXTENDS");
        List numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);
        sumNumbers(numbers);

        System.out.println("SUPER");
        addNumbers(numbers);
    }

    // Permite recorrrer la lista sin saber el tipo de dato mediante Object
    public static void printData(List<?> items){
        for (Object item: items){
            System.out.println(item);
        }
    }

    // Permite recorrer los elementos de la lista conociendo el tipo de dato
    public static void sumNumbers (List<? extends Number> numbers) {
        double suma = 0;
        for (Number num: numbers) {
            suma += num.doubleValue();
        }

        System.out.println(suma);
    }

    // No permite recorrer datos - solo agregar nuvos datos a la lista
    public static void addNumbers (List<? super Number> numbers) {
        numbers.add(99);
        numbers.add(1);
        numbers.add(29);
        numbers.add(9);
        Object num = numbers.get(1);
        System.out.println(num);
    }
}

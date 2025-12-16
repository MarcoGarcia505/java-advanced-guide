package com.devtalles.labs.generigs.object;

public class Main {
    public static void main(String[] args) {

        // Object -> puede convertirse en cualquier tipo de dato y ser reasignado a cualquier tipo
        Object number = Integer.parseInt("1");
        number = "coco";

        var name = "Local host";
        // name = 11; -> no podemos asignar un tipo de dato diferente al establecido

        System.out.println(number); // "coco"
        System.out.println(name);
    }
}

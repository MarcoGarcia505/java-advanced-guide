package com.devtalles.labs.classOptional;

import java.util.Optional;
import java.util.Scanner;

public class OrElseGetAndOrElseAndOrElseThrow {
    public static void main(String[] args) {
        // PROGRAMACION INPERATIVA
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Insert a name: ");
//        String name = scanner.nextLine();
//
//        Optional<String> optionalName = Optional.empty();
//
//        if (name.isEmpty()) {
//            name = optionalName.orElse("default value");
//        }
//
//        System.out.println(name);
//
//        scanner.close();

        // FORMA FUNCIONAL DE TRABAJAR CON OPTIONAL
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a name: ");
        String name = scanner.nextLine();

        Optional<String> nullableName = Optional.ofNullable(name)
                .filter(item -> !item.isEmpty());


        //-> Define un valor por defecto dependiendo si la cadena esta vacia
        String validName = nullableName.orElseGet(() -> "Default value");
        //-> Define un valor por defecto dependiendo si la cadena esta vacia
//        String validName = nullableName.orElse("Default value");
        //-> lanaza una exepcion en caso de que la cadena no contenga informacion
//        String validName = nullableName.orElseThrow(() -> new IllegalArgumentException("Invalid data, without data"));

        System.out.println(validName);

        scanner.close();

    }
}

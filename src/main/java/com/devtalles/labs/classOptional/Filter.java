package com.devtalles.labs.classOptional;

import java.util.Optional;

public class Filter {
    public static void main(String[] args) {
        Optional<String> id = Optional.of("123345");
        Optional<String> dni = id.filter(item -> item.startsWith("1"));
        System.out.println(dni.orElse("No value"));


        // OPTION 1 -> TASK
        Optional<String> email = Optional.ofNullable("        markopolo5050@outlook.com         ");
        Optional<String> validEmail = email
                .map(item -> item.trim())
                .filter(item -> item.contains("@"))
                .filter(item -> item.contains(".com"));

        System.out.println("email: " + validEmail.orElse("No valid Email"));


        // OPTION 2 -> TASK TEACHER
        email.map(item -> item.trim())
                .filter(item -> item.contains("@"))
                .ifPresent((message) -> System.out.println("Email name: " + message));


    }
}

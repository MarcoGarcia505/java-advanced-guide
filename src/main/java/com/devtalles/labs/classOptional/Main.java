package com.devtalles.labs.classOptional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // valida las cadenas
        Optional<String> name = Optional.of("Juan juega juegos");
        if (name.isPresent()) {
            System.out.println("This is the name: " + name.get());
        }

        // Si es que llega un valor null
        String nameUser = null;
        Optional<String> nick = Optional.ofNullable(nameUser);
        if (nick.isPresent()) {
            System.out.println("This is the nickname: " + name.get());
        } else {
            System.out.println("Nickname does not exist");
        }

        // Manejo de valoers vacios empty
        Optional<String> empty = Optional.empty();
        if (empty.isEmpty()) {
            System.out.println("We do not have information");
        } else {
            System.out.println("empty name: " + empty.get());
        }


        // agregando logica si el obtional contine un valor -> ifPresent
        Optional<String> validateName = Optional.of("Juan juega juegos local el prro");
        validateName.ifPresent(namePresent -> System.out.println("this is the name: " + namePresent));


    }
}

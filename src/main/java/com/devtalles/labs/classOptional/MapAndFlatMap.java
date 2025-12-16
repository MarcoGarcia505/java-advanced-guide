package com.devtalles.labs.classOptional;

import java.util.Optional;

public class MapAndFlatMap {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("LOCAL");
        // Map -> se encarga de evaluar si el valor esta presente
        // si esta presente ejecuta la funcion
        // si NO esta presente retorna Optional.empty()
        String mapName = name
                .map(item -> item.trim())
                .map(value -> value.toLowerCase())
                .orElse("default");

        System.out.println(mapName);

        // FlatMap -> se encarga de aplanar un optional de optionals
        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.of("value -> lcoal host"));
        //Se encarga de aplanar los optional de optional
        Optional<String> flatMapOptional = optionalOfOptional.flatMap(item -> item);
        System.out.println(flatMapOptional);
    }
}

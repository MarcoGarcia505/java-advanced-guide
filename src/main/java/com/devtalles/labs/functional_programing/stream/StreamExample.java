package com.devtalles.labs.functional_programing.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
//        System.out.println("FORMA 1 DE CREAR UN STREAM");
//        List<String> names = Arrays.asList("Juan", "Noe", "Pao", "Pedro");
//        Stream<String> streamNames = names.stream();
//        streamNames.forEach(item -> System.out.println(item));
//
//        System.out.println("FORMA 2 DE CREAR UN STREAM");
//        Stream<String> generateNamesStream = Stream.of("Juan", "pedro", "maria", "noe");
//        generateNamesStream.forEach(item -> System.out.println(item));
//
//
//        System.out.println("FORMA 3 DE CREAR UN STREAM");
//        String[] namesArray = {"Juan", "pedro", "maria", "noe"};
//        Stream<String> arrayNames = Arrays.stream(namesArray);
//        arrayNames.forEach(System.out::println);
//
//        System.out.println("FORMA 4 DE CREAR UN STREAM");
//        Stream<String> generateStream = Stream.generate(() -> "generate stream").limit(3);
//        generateStream.forEach(System.out::println);
//
//
//        System.out.println("FORMA 5 DE CREAR UN STREAM");
//        List<String> students = Arrays.asList("Juan", "Noe", "Pao", "Pedro");
//        students.stream()
//                .filter(item -> item.length() > 3)
//                .map(item -> item.toUpperCase())
//                .forEach(item -> System.out.println(item));


        // Los streams no puden ser consumidos mas de una ves
        Stream<String> createValidate = Stream.of("Juan", "Noe", "Pao", "Pedro");
        createValidate.forEach(System.out::println); // Stream consumido

        List<String> listStream = createValidate.toList();
        listStream.forEach(System.out::println); // Stream consumido -> Error
    }
}

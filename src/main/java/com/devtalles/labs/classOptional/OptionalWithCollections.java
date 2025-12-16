package com.devtalles.labs.classOptional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalWithCollections {
    public static void main(String[] args) {
        // Example 1 -> Obtener el primer elemento de una lista
        List<String> names = List.of("name1", "name2", "name3");
        Optional<String> findName = names.stream().findFirst();
        findName.ifPresent(item -> System.out.println("This is the value: " + item));

        // Example 2 -> Obtener el primer elemento de una lista
        List<String> emptyList = List.of();
        Optional<String> value = emptyList.stream().findFirst();
        System.out.println("The value: " + value.isPresent());

        // Exmaple 3 -> Validar si un string se eencuentar dentro de una lsita
        record Product(String name, double price){};

        List<Product> products = new ArrayList<>(List.of(new Product("iphone 17", 200), new Product("samsung", 400), new Product("tesla", 999)));
        Optional<Product> filterProduct = products.stream().filter(item -> item.name.equalsIgnoreCase("iphon 17")).findFirst();
        Product productProcess = filterProduct.orElse(new Product("EMPTY", 0));
        System.out.println("valid product" + productProcess.toString());
        filterProduct.ifPresent(item -> System.out.println(item.toString()));


        //Example 4 -> opcion ifPresetOrElse
        System.out.println("EXAMPLE 4");
        String valueName = null;
        Optional<String> valueN = Optional.ofNullable(valueName);

        valueN.ifPresentOrElse(
                (item) -> System.out.println("This is the value name: "+item),
                () -> System.out.println("Without value"));


        //Example 5 -> validate a list
        List<Optional<String>> listOptional = List.of(Optional.of("Hello"), Optional.empty(), Optional.of("Chau"));
        List<String> validLsit = listOptional.stream()
                .filter(item -> item.isPresent())
                .map(item -> item.get()).toList();

        System.out.println(validLsit);
    }
}

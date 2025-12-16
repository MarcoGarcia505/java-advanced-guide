package com.devtalles.labs.functional_programing.stream;

import com.devtalles.labs.functional_programing.record.ProductDto;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAndObjects {
    public static void main(String[] args) {
        List<ProductStreamDto> listProducts= List.of(
                new ProductStreamDto("Csuela", 200),
                new ProductStreamDto("Mause RGT", 500),
                new ProductStreamDto("Iphone 17", 400),
                new ProductStreamDto("Iphone 17", 999)
        );


        List<String> formatProducts = listProducts.stream()
                .map(item -> new ProductStreamDto(item.name(), item.price()*.9))
                .map(item -> String.format("%s: $%.2f", item.name(), item.price()))
                .toList();


        Map<String, List<ProductStreamDto>> rangeByPrice = listProducts.stream().collect(Collectors.groupingBy(item -> {
            return item.price() > 200 ? "caro" : "barato";
        }));

        Map<String, Long> countByRange = listProducts.stream()
                .collect(Collectors.groupingBy(item -> item.price() > 200 ? "caro" : "barato", Collectors.counting()));

//        System.out.println(rangeByPrice);
//        System.out.println(countByRange);
//
//        rangeByPrice.forEach((key, data) -> System.out.println(key + data));


        // 2.- Reduccion Matematica

        // redice -> pertenece a la programacion funcional
        // los acumuladores -> pertenecen a la programacion imperativa
        Double total = listProducts.stream().map(item -> item.price()).reduce(0.0, (sum, price) -> sum + price);
        System.out.println("total: " + total);

        String fomatDetailsProduct = listProducts.stream()
                .map(item -> item.name() + "( $" + item.price() + ")")
                .reduce("", (initialValue, nextValue) -> {
                    if (initialValue.isEmpty()) {
                        return nextValue;
                    } else {
                        return initialValue + " | " + nextValue;
                    }
                });

        System.out.println(fomatDetailsProduct);


        //Converciones entre colecciones

        Set<Double> changeFromatSet = listProducts.stream().map(item -> item.price()).collect(Collectors.toSet());
        System.out.println("changeFromatSet: " + changeFromatSet);

        // Manejo de valores repeotidos con el uso de un tercer elemento
        Map<String, Double> changeFormatMap = listProducts.stream()
                .collect(Collectors.toMap(
                item -> item.name(),
                itme -> itme.price(),
                        (oldValue, newValue) -> newValue // Con esto podemos definir que valor se queda dependiendo de valores repetidos
        ));

        System.out.println("changeFormatMap" + changeFormatMap);

        // Recorrer Map<String, double>
        List<ProductDto> changeFormatMatToList = changeFormatMap.entrySet().stream()
                .filter(item -> item.getValue() > 200)
                .map(item -> new ProductDto(item.getKey(), item.getValue()))
                .toList();

        System.out.println("changeFormatMatToList -> " + changeFormatMatToList);
    }
}

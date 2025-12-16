package com.devtalles.labs.functional_programing.record;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Uso actual de una clase inmutable
        Product product = new Product("Tesla", "Carro fater", 1000);
        System.out.println(product.getName() + product.getDescription());

        // Uso de un record que por defecto es una clase inmutable
        ProductDto productDto = new ProductDto("Raptor", "Ford faster", 4000);
        System.out.println(productDto.name() + productDto.description());
        productDto.cancelCar();
        System.out.println(productDto.KEY );
        System.out.println(productDto.KEY = "LCOASL HOST");
        System.out.println(productDto.KEY );

        List<ProductDto> listProducts= List.of(
                new ProductDto("Csuela", 200),
                new ProductDto("Mause RGT", 500),
                new ProductDto("Iphone 17", 400)
        );


        List<String> formatProducts = listProducts.stream()
                .map(item -> new ProductDto(item.name(), item.price()*.9))
                .map(item -> String.format("%s: $%.2f", item.name(), item.price()))
                .toList();


        Map<String, List<ProductDto>> rangeByPrice = listProducts.stream().collect(Collectors.groupingBy(item -> {
            return item.price() > 200 ? "caro" : "barato";
        }));

        Map<String, Long> countByRange = listProducts.stream().collect(Collectors.groupingBy(item -> item.price() > 200 ? "caro" : "barato", Collectors.counting()));

        System.out.println(rangeByPrice);
        System.out.println(countByRange);

        rangeByPrice.forEach((key, data) -> System.out.println(key + data));
    }
}

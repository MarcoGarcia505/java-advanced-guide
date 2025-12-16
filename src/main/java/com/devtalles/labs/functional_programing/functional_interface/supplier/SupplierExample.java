package com.devtalles.labs.functional_programing.functional_interface.supplier;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Pesado para utilizarse con el patron de diseno factory, Supplier esta pensado solo para retornar y no puede recibir parametros
        Supplier<Person> p1 = () -> new Person();

        Person person1 = p1.get();
        person1.setName("Juan");

        System.out.println(person1.getName());
    }
}

package com.devtalles.labs.functional_programing.record;

// En los record no hay necesidad de crear los getter, toString, hashCode
// devido a que los crea por default
public record ProductDto(String name, String description, double price) {
    // podemos hacer uso de atributos estaticos
    public static String KEY = "LCOAL HOST KEY";
    public static final String APIKEY = "LCOAL HOST KEY";

    // podemos recivir parametros parciales (No completos),
    // para poder crear un objeto a consideracion del requerimiento
    public ProductDto(String name, double price) {
        this(name, "", price);
    }

    // Empleo de metodos estaticos
    public static Boolean isActiveCar() {
        return true;
    }

    // Empleo de metodos
    public String cancelCar() {
        System.out.println("cancel car");
        return "return a String";
    }

}

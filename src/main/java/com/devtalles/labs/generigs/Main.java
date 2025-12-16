package com.devtalles.labs.generigs;

public class Main {
    public static void main(String[] args) {
        // La clase se encarga de tomar el tipo de dato establecido en la instancia de la clase
        Box<String> text = new Box<>("Polo");
        Box<Integer> number = new Box<>(1);

        System.out.println(text.getValue());
        System.out.println(number.getValue());

        // METODOS QUE RESIVEN COMO PARAMETRO UN GENERICO

        System.out.println(" --- USO DE GENERICOS EN LOS METODOS ---");
        Utility.printData(10);
        Utility.printData("con el coco");
        Utility.printData(false);
        Utility.printData(false, "Juan", 1000);

        // RESTRICCIONES EN LOS GENERICOS
        System.out.println(" --- RESTRICCIONES DE TIPO A LOS GENERICOS ---");
        MathUtils.printString("LCOASL HOST");
        //MathUtils.printString(100); // ERROR -> SOLO ACEPTA STRING LA EL METODO
        MathUtils.printNUmberAndString(25, "LCOASL HOST"); // Manejo de varios tipos de datos con restricciones
    }
}

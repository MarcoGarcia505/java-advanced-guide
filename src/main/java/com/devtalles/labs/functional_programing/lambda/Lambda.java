package com.devtalles.labs.functional_programing.lambda;

public class Lambda {
    public static void main(String[] args) {

        Operation opera = new Operation() {
            @Override
            public int operate(int x, int y) {
                return x + y;
            }
        };

        System.out.println(opera.operate(5,5));

        System.out.println("Implementation of the functions Lambda");
        Operation sum = (x, y) -> {
            return x + y;
        };

        Operation res = (x, y) -> {
            return x - y;
        };

        Operation ress = Operation.rest();
        System.out.println("Sum - lambda: " + sum.operate(5,10));
        System.out.println("Res - lambda: " + res.operate(5,10));
        System.out.println("Ress - lambda: " + ress.operate(10,10));
    }

    // Define una interface como parte de una interface en donde no podemos agregar mas de un metodo a la interface
    // debido a que lo empleamos como parte de una funcion
    @FunctionalInterface
    interface Operation{
        int operate(int x, int y);

        // Es posible agregar mas metodos pero solo con los siguientes modificadores - default, static
        default void indexText() {
            System.out.println("This is a test");
        }

        static Operation rest() {
            return (x, y) -> x - y;
        }
    }
}

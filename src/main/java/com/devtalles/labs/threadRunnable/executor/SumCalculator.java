package com.devtalles.labs.threadRunnable.executor;

import java.util.concurrent.*;

// Callable es una interface que te permite trabajar con genericos y te permite generar un metodo lcoal
public class SumCalculator implements Callable<Integer> {
    private Integer number1;
    private Integer number2;

    public SumCalculator(int num1, int num2) {
        this.number1 = num1;
        this.number2 = num2;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Init task sum numbers");

        // detiene el codigo hasta este punto haciendo una espera de 5 segundos
        Thread.sleep(5000);
        int sum  = number1 + number2;
        System.out.println("name thread: " + Thread.currentThread().getName());
        System.out.println("Task completed");
        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Declaramos los hilos con los que vamos a trabajar
        ExecutorService execute = Executors.newFixedThreadPool(2);

        // Creamos una instancia de la clase SumCalculator
        Callable<Integer> sumTask = new SumCalculator(10, 10);

        // Future nos permite capturar la respuesta de un metodo que se ejecuta en un hilo esto mediante la interface Callable
        Future<Integer> response = execute.submit(sumTask);

        // Mientras que la respuesta no este lista imprimimos el siguiente mensaje, eso es lo que nos permite el metodo isDone()
        while (!response.isDone()) {
            System.out.println("Procesing task....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }


        // el metodo get nos permite obtener el resultado de las tareas
        System.out.println("Result sum: " + response.get());

        // Terminamos el proceso con los hilos
        execute.shutdown();

    }
}

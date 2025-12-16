package com.devtalles.labs.threadRunnable.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVsExecutor {
    public static void main(String[] args) {
        // Consume demaciados recursoso debido a que no definimos la cantidad de hilos a ocupar
        // delegando la responsabilidad a el numero de iteraciones o la instanciacion de hilos
        System.out.println("Con Thread.............");
        for (int i = 0; i < 4000; i++) {
            new Thread( () -> System.out.println("Task Thread A" + Thread.currentThread().getName())).start();
        }


        // La opcion mas optima debido a que se encarga de gestionar el uso de hilos que definimos en el parametro del metodo newFixedThreadPool(NumeroHilos)
        System.out.println("Con Executor.............");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> System.out.println("Task Thread B" + Thread.currentThread().getName()));
        }

        // Cerramos el uso del recurso
        executor.shutdown();
    }
}

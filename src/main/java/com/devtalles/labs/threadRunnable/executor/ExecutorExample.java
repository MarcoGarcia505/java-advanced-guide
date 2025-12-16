package com.devtalles.labs.threadRunnable.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        // ExecutorService -> es un cordinador de tareas definiendo en donde las tareas se van a ejecutar y en que hilo se ejecutan
        // Executors.newFixedThreadPool -> se encarga de definir cuantos hilos se van a utilizar
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // execute() -> se encrag de ejecutra una tarea dentro del metodo
        executor.execute(() -> System.out.println("Task 1 " + Thread.currentThread().getName()));
        executor.execute(() -> System.out.println("Task 2 " + Thread.currentThread().getName()));
        executor.execute(() -> System.out.println("Task 3 " + Thread.currentThread().getName()));

        // shutdown() -> se encarga de cerrar el recurso ExecutorService
        executor.shutdown();
    }

}

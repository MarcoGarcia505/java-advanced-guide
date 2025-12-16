package com.devtalles.labs.threadRunnable.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TypeExecutorService {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Running task: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Task completed: " + Thread.currentThread().getName());
        };

        // Permite definir el uso de hilos que podemos usar
        System.out.println("Using newFixedThreadPool");
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            threadPool.execute(task);
        }
        threadPool.shutdown();

        // Dispone de todos los hilos siempre y cuando los procesos los necesiten (Uso ilimitado de hilos)
        System.out.println("Using newCacheThreadPool");
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            cacheThreadPool.execute(task);
        }
        cacheThreadPool.shutdown();


        // Dispone de solo 1 hilo para la gestion de tareas
        System.out.println("Using newCacheThreadPool");
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            singleThreadPool.execute(task);
        }
        singleThreadPool.shutdown();



    }
}

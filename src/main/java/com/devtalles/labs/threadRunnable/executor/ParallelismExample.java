package com.devtalles.labs.threadRunnable.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelismExample {
    public static void main(String[] args) throws InterruptedException {
        // Ejemoplo de paralelismo
        System.out.println("Executing newSingleThreadExecutor");
        ExecutorService servie = Executors.newFixedThreadPool(3);

        long start = System.currentTimeMillis();
        servie.execute(() -> task("task 1"));
        servie.execute(() -> task("task 2"));
        servie.execute(() -> task("task 3"));
        servie.shutdown();

        // demora maximo un minuto esperando a que las tereas se teerminen de ejecutar
        if (!servie.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Task late, exiting");
            servie.shutdown();
        }

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms");
    }


    public static void task(String nameTask) {
        System.out.println("Init task at: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed task at: " + Thread.currentThread().getName());
    }
}

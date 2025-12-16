package com.devtalles.labs.threadRunnable.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownComparison {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("Init task with executor: " + taskId + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("Task: " + taskId + " was interrupted");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println("ERROR" + ex.getMessage());
                    }
                    return;
                }
                System.out.println("End task");
            });
        }

        Thread.sleep(5000);

        boolean error = true;

        if (error) {
            System.out.println("Critical Error");
            // Detiene todos los hilos que estan en ejecucion retornado una lista los que fueron detenidos
            executorService.shutdownNow();
        } else {
            System.out.println("Completed all the task");
            // Termian las procesos de forma ordenada, permitiendo ejecutar todos los hilos independientemente que alla ocurrido un error
            // Apartir de que terminamos de cerrar el recurso ya no podremos seguir lanzando procesos debido a que el recurso lo apagamos o se termino
            executorService.shutdown();
        }

        // se encarga de esperarar a que las tareas terminen, notificandonos si estas tivieron algun error
        if (executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("all task completed");
        } else {
            System.out.println("Some task has errors");
        }
    }
}

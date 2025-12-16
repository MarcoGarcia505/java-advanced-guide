package com.devtalles.labs.threadRunnable.tareasProgramadas;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {
    public static void main(String[] args) {
        // Definicion de los hilos para el uso de tareas programadas
//        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(2);
//
//        // Tarea porgramada donde se despues de cuanto tiempo se ejecuta
//        schedule.schedule(() -> {
//            System.out.println("Execute after 4 seconds");
//        }, 4, TimeUnit.SECONDS);
//
//        schedule.schedule(() -> {
//            System.out.println("execute task after 5 seconds");
//            // cerrar el recurso para que no proese mas tareas
//            schedule.shutdown();
//        }, 5, TimeUnit.SECONDS);
//
//
//
//        // FORMA VIEJA DE HACER TAREAS PROGRAMADAS
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("execute task after 2 seconds");
//                // Termina el proceso
//                timer.cancel(); // si colocamos .cancel() fuera no ejecutaria la funcion debido a que Timmer funciona diferente que ScheduleExecute
//            }
//        }, 2000);

        // timer.cancel(); // no ejecuta el metodo timmer.schedule() por funcionamiento diferente



        // TAREAS RECURRENTES, BUCLE DE TAREAS RECURRENTES ATRAVES DEL TIEMPO?
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        // FORMA 1
//        executorService.scheduleAtFixedRate(() -> {
//            System.out.println("executing....");
//        }, 3, 3, TimeUnit.SECONDS);
//

        // FORMA 2
        Runnable task = new Runnable() {
            int conter = 0;
            @Override
            public void run() {
                System.out.println("executing task.....");
                conter++;
                if (conter > 3) {
                    System.out.println("exit task");
                    executorService.shutdown();
                }
            }
        };

        executorService.scheduleAtFixedRate(task, 3, 3, TimeUnit.SECONDS);

    }
}

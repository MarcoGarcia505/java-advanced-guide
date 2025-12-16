package com.devtalles.labs.threadRunnable.tareasProgramadas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskOnSpesificDate {
    public static void main(String[] args) {
        // Establecemos la fecha a ejecutar la funcion
        LocalDateTime timeDelay = LocalDateTime.of(2025, 12, 6,  0, 53);
        LocalDateTime now = LocalDateTime.now();

        // hacer calculo para obtener la fecha que existen entre ambas, esto va a brindar la cuenta regresiva para la ejecucion de la tarea
        long timeBetween = Duration.between(now, timeDelay).toMillis();


        // valida si la fecha ya paso
        if (timeBetween < 0) {
            System.out.println("The date has pass away");
            return;
        }

        // Los hilos nos permiten estar a la espera de ejecucion de las tareas, mediante el segundo parametro de tiempo
        // es decir que se ejecuta despues de determinado tiempo
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.schedule(() -> {
            System.out.println("task after ");
            service.shutdown();

            }, timeBetween, TimeUnit.MILLISECONDS);


    }
}

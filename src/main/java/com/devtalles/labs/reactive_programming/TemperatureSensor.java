package com.devtalles.labs.reactive_programming;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TemperatureSensor {
    public static void main(String[] args) throws InterruptedException{
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable<Double> temperature = interval.map(item -> {
            double temp = 20 * Math.random() * 15;
//            System.out.println("Actual temperature: " + temp);
            return temp;
        });

        temperature.filter(rule -> rule < 100).subscribe(
                t -> {
                    System.out.println("Actual temperature: " + t);
                    },
                throwable -> {
                    System.out.println("Error: " + throwable.getMessage());
                },
                () -> {
                    System.out.println("completed proces");
                }
                );

        Thread.sleep(10000);
    }
}

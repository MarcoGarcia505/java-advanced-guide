package com.devtalles.labs.reactive_programming;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParallelStreamVsStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);

        long start = System.currentTimeMillis();

        // USO STREAM
        list.stream().map(number -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }

            System.out.println("Procesing number: " + number);
            return number;
        }).forEach(number -> {
            System.out.println("Number: " +number);
        });

        // PARALLEL STREAM
        list.parallelStream().map(number -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }

            System.out.println("Procesing number: " + number);
            return number;
        }).forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.println("total time: " + (end - start) + " ms");
    }
}

package com.devtalles.labs.reactive_programming;

import io.reactivex.rxjava3.core.Observable;

public class ReactiveIntro {
    public static void main(String[] args) {
        // Observable -> es la representacion un flujo de datos que se pueden emitir a lo largo de la ejecucion
        // just -> un metodo estatico que emite los eventos secuencialmente
        Observable<String> courseStream = Observable.just("HTML", "CSS", "JAVA", "C");

        // subscribe -> es el que va a observar el flujo de datos y actuar en base a la respuesta
        courseStream.subscribe(
                item -> {System.out.println("Element: " + item);},
                error ->  {System.out.println("Error: " + error);},
                () -> {
                    System.out.println("Completed all task");
                }
        );
    }
}

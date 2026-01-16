package com.devtalles.labs.reactive_programming;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;

public class ReactiveScanner {
    public static void main(String[] args) {
        // PublicshSubject -> expone los datos a medida que van entrando
        PublishSubject<String> inputStream = PublishSubject.create();

        inputStream.subscribe(
                item -> {
                    System.out.println("Element: " + item.toUpperCase());
                },
                error -> {
                    System.out.println("Error: " + error.getMessage());
                },
                () -> {
                    System.out.println("Completed Execute");
                }
        );

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a word or insert 'exit' to close the program");
        while (true) {
            String word = scanner.nextLine();
            if (word.equalsIgnoreCase("exit")) {
                //onComplete() -> cierra el flujo de datos
                inputStream.onComplete();
                break;
            }
            // onNext() -> agrega datos al flujo
            inputStream.onNext(word);
        }
    }
}

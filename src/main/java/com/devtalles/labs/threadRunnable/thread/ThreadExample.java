package com.devtalles.labs.threadRunnable.thread;


// Con esta forma de crear hilos, limintamos a la clase de extender de otra clase, que contenga mas logica
// Herencia de la super clase Thred para poder gentionar o crear hilos
public class ThreadExample extends Thread{
    public String name;

    public ThreadExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++){
            System.out.println(name + "Message: " + i + "ejcuting the thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Start name: " + Thread.currentThread().getName());

        ThreadExample t1 = new ThreadExample("Thread 1");
        ThreadExample t2 = new ThreadExample("Thread 2");

        // Permite la ejecucion en paralelo, es decir que todo se ejecuta sin algun bloqueo
        t1.start();
        t2.start();


        // Esto bloquea los demas procesos hasta que se termine de ejecutar
        //t1.run();
        //t2.run();

        System.out.println("Ejecuting all the other functions");
    }
}

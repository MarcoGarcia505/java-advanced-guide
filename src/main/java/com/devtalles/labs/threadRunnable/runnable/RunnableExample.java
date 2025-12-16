package com.devtalles.labs.threadRunnable.runnable;

// Al implementar la interface Runnable permite tener mas versatilidad al momento de hacer herencia con otras clases
public class RunnableExample implements Runnable{

    private String name;

    public RunnableExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println(name + "Message: " + i + "ejcuting the thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Strat of the main threat " + Thread.currentThread().getName());

        // Hay que hacer esto mediante si se implementa la interface Runnable
        // Se declara un hilo el cual ejecuta un proceso en paralelo mediante el metodo start()
        Thread hi1 = new Thread(new RunnableExample("Process 1 "));
        Thread hi2 = new Thread(new RunnableExample("Process 2 "));

        // Ejecucuion de abos hilos
        hi1.start();
        hi2.start();


        System.out.println("End of the thread main");
    }
}

package com.devtalles.labs.generigs.queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> numbers = new Queue<>();

        numbers.enqueue(1);
        numbers.enqueue(3);
        numbers.enqueue(4);
        numbers.enqueue(46);

        numbers.print();

        System.out.println("See the first element: " + numbers.peek());
        System.out.println("Delete the first element: " + numbers.dequeue());

        numbers.print();


        Queue<String> names = new Queue<>();

        names.enqueue("Lola");
        names.enqueue("Pedro");
        names.enqueue("Juan");

        names.print();

    }
}

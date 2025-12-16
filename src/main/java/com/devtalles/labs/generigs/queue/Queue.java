package com.devtalles.labs.generigs.queue;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
    private final LinkedList<T> elemets = new LinkedList<>();


    public void enqueue(T data) {
        elemets.add(data);
        System.out.println("Element added: " + data);
    }

    public boolean isEmpty() {
        return elemets.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is enty");
        }

        return elemets.getFirst();
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }

        return elemets.removeFirst();
    }

    public void print() {
        for (Object o: elemets) {
            System.out.println(o);
        }
    }

}

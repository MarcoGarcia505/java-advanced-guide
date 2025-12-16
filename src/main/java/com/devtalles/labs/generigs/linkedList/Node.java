package com.devtalles.labs.generigs.linkedList;

public class Node<T>{
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

package com.devtalles.labs.generigs.stack;

public class Main {
    public static void main(String[] args) {
        // ESTRUCTURA DE DATOS
        // Stack ->  Last in - First out
        Stack<Integer> inetgerStack = new Stack<>();

        inetgerStack.push(1);
        inetgerStack.push(2);
        inetgerStack.push(3);

        Stack<String> names = new Stack<>();
        names.push("Juan");
        names.push("Pedro");
        names.push("Maria");

        System.out.println("Get the last element: " + inetgerStack.peek());
        System.out.println("Delete the last element: " + inetgerStack.pop());

        inetgerStack.print();
    }
}

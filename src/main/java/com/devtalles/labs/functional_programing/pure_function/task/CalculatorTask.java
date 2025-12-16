package com.devtalles.labs.functional_programing.pure_function.task;

public class CalculatorTask {

    public static void operateAndPrint(int x, int y, Operate op) {
        Integer result = op.operation(x, y);
        System.out.println("result: " + result);
    }

    public static void main(String[] args) {
        operateAndPrint(10, 10, (q, w) -> q + w);
        operateAndPrint(10, 10, (q, w) -> q - w);
        operateAndPrint(10, 10, (q, w) -> q / w);
        operateAndPrint(10, 10, (q, w) -> q * w);
    }
}


@FunctionalInterface
interface Operate {
    int operation (int x ,int  y);
}
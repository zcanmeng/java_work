package com.cm.homework12;

public class Homework {
    public static void main(String[] args) {
        Th1 th1 = new Th1();
        Th2 th2 = new Th2(th1);
        new Thread(th1).start();
        new Thread(th2).start();
    }
}

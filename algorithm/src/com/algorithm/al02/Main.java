package com.algorithm.al02;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.add(10);
        queue.add(20);
        queue.add(40);
        queue.add(30);
        queue.add(50);

        queue.get();

        queue.del();

        queue.get();
    }
}

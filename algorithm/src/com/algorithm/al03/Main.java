package com.algorithm.al03;

public class Main {
    public static void main(String[] args) {
        LoopQueue loopQueue = new LoopQueue(5);
        loopQueue.add(1);
        loopQueue.add(1);
        loopQueue.add(1);
        loopQueue.add(1);

        loopQueue.del();
        loopQueue.add(2);
        loopQueue.show();

    }
}

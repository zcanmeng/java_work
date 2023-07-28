package com.cm.homework12;

import java.util.Scanner;

public class Th2 implements Runnable{
    private Th1 th1;
    private Scanner scanner = new Scanner(System.in);

    public Th2(Th1 th1) {
        this.th1 = th1;
    }

    @Override
    public void run() {
        while (true){
            char next = scanner.next().toUpperCase().charAt(0);


            if(next=='D'){
                th1.setFlag(false);
            }

            System.out.println("退出");
            break;
        }
    }
}

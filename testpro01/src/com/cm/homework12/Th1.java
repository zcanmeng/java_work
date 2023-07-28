package com.cm.homework12;

public class Th1 implements Runnable {
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while(flag){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

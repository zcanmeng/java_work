package com.cm.homework13;

public class Account implements Runnable {
    private Integer money=1000;

    @Override
    public void run() {
        while (true){
            synchronized (this){


                if (money <= 0){
                    System.out.println("取款失败，余额不足");
                    break;
                }

                money-=100;
                System.out.println("取款成功余额为"+money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

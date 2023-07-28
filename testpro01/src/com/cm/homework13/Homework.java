package com.cm.homework13;

public class Homework {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account).start();
        new Thread(account).start();
    }
}

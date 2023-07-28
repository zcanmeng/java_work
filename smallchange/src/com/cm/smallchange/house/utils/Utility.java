package com.cm.smallchange.house.utils;

import java.util.Scanner;

public class Utility {

    public static char readChar(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int readInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

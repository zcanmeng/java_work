package com.cm.homework01;

import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(s);
        for(int i=stringBuffer.lastIndexOf(".")-3;i >0 ; i-=3){
                stringBuffer.insert(i,",");
        }
        System.out.println(stringBuffer.toString());
    }
}

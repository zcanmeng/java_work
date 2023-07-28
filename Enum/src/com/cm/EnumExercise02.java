package com.cm;

public class EnumExercise02 {
    public static void main(String[] args){
        Week[] values = Week.values();
        System.out.println("===所有星期的信息如下===");
        for(Week value:values){
            System.out.println(value.getName());
        }
    }
}

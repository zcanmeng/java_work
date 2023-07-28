package com.cm;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("小明",18);
        person.say();

        Person student = new Student("小红",18,1,98);
        student.say();
        int a=1;
        int b=2;
        boolean c=true;
        System.out.println(c||cc());
        if (cc()) {
        }
    }
    public static boolean cc(){
        return false;
    }
}

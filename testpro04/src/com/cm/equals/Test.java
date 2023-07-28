package com.cm.equals;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("小明",18,'男');
        Person person2 = new Person("小",18,'男');
        System.out.println(person1.equals(person2));
    }
}

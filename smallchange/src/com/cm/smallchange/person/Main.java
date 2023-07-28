package com.cm.smallchange.person;

public class Main {
    public static void main(String[] args) {
        Person[] person = new Person[4];
        person[0] = new Person("小明", 13, "学生");
        person[1] = new Person("小红", 25, "学生");
        person[2] = new Person("小绿", 50, "老师");
        person[3] = new Person("小李", 18, "学生");

        Person temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - 1 - i; j++) {
                if (person[j].getAge() < person[j + 1].getAge()) {
                    temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
    }
}

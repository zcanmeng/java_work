package com.cm.smallchange.teacher;

public class Professor extends Teacher {
    String name="xiaoming";
    public Professor(String name, int age, double salary) {
        super(name, age, "教授", salary, 1.3);
    }

    @Override
    public void introduce() {
        System.out.println("欢迎"+getPost());
        super.introduce();
    }
}

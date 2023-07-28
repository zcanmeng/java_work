package com.cm.smallchange.teacher;

public class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;
    private double garden;

    public Teacher(String name, int age, String post, double salary, double garden) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.garden = garden;
    }

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getGarden() {
        return garden;
    }

    public void setGarden(double garden) {
        this.garden = garden;
    }

    public void introduce(){
        System.out.println("姓名："+name+"\t年龄："+age+"\t职称："+post+"\t基本工资："+salary+"\t工资等级："+garden);
    }
}

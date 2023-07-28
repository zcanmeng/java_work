package com.cm.pojo;

public class User {
    private int age;
    private String name;

    public User() {
    }

    public User(String name){
        this.name=name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        System.out.println("hello无参");
    }

    public void hello(String name){
        System.out.println("hello有参："+name);
    }

    private void hello(int id,String name){
        System.out.println("private有参"+id+name);
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

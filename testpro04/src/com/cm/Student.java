package com.cm;

public class Student extends Person {
    private Integer id;
    private Integer score;

    public Student(){

    }

    public Student(Integer id, Integer score) {
        this.id = id;
        this.score = score;
    }

    public Student(String name, Integer age, Integer id, Integer score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

//    @Override
//    public void say(){
//        System.out.println("我的名字："+super.getName()+"年龄："+super.getAge()+"id:"+id+"score:"+score);
//    }
}

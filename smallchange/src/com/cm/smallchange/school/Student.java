package com.cm.smallchange.school;

public class Student extends Person{
    private String stuId;

    public Student(String name, char sex, int age, String stuId) {
        super(name, sex, age);
        this.stuId = stuId;
    }

    public void study(){
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String play() {
        return super.play()+"足球";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", sex=" + getSex() +
                ", age=" + getAge() +
                "stuId='" + stuId + '\'' +
                '}';
    }

    @Override
    public String prin() {
        return "学生的信息：\n"+super.prin()+"\n学号："+stuId+"\n我承诺，我会好好学习"+"\n"+play();
    }
}

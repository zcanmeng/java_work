package com.cm.smallchange.school;

public class Teacher extends Person {
    private int workAge;

    public Teacher(String name, char sex, int age, int workAge) {
        super(name, sex, age);
        this.workAge = workAge;
    }

    public void teach(){
        System.out.println("我承诺，我会认真教学");
    }

    @Override
    public String play() {
        return super.play()+"象棋";
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", sex=" + getSex() +
                ", age=" + getAge() +
                "workAge=" + workAge +
                '}';
    }

    @Override
    public String prin() {
        return "老师的信息：\n"+super.prin()+"\n工龄："+workAge+"\n我承诺，我会认真教学"+"\n"+play();
    }
}

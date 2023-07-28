package com.cm.smallchange.school;

public class Main {
    public static void main(String[] args) {
        Student student=new Student("小明",'男',18,"107");
        Student student1=new Student("小明",'男',18,"107");
        Teacher teacher=new Teacher("小红",'女',18,10);
        Teacher teacher1=new Teacher("小红",'女',18,10);
        System.out.println(student.play());
        student.study();
        System.out.println(student.prin());
        System.out.println(teacher.play());
        teacher.teach();
        System.out.println(teacher.prin());

        Person[] person = new Person[4];
        person[0]=student;
        person[1]=student1;
        person[2]=teacher;
        person[3]=teacher1;

        for (int i = 0; i < person.length; i++) {
            if (person[i] instanceof Student){
                ((Student)person[i]).study();
            }else if(person[i] instanceof Teacher){
                ((Teacher)person[i]).teach();
            }
        }

    }
}

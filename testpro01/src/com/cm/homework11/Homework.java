package com.cm.homework11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("小米",100.0,new MyDate(1,2,3)));
        list.add(new Employee("小米",100.0,new MyDate(1,3,3)));
        list.add(new Employee("小米",100.0,new MyDate(1,1,3)));

        for(Employee employee:list){
            System.out.println(employee);
        }

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i!=0){
                    return i;
                }

                return o1.getBirthday().compareTo(o2.getBirthday());


            }
        });

        for(Employee employee:list){
            System.out.println(employee);
        }

    }
}

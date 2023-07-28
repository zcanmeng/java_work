package com.cm.homework08;

import java.util.HashSet;
import java.util.Iterator;

public class Homework {
    public static void main(String[] args) {
        Employee employee1 = new Employee("小明",99,new MyDate(2000,10,1));
        Employee employee2 = new Employee("小明",99,new MyDate(2000,10,1));
        Employee employee3 = new Employee("小明",99,new MyDate(2000,11,1));

        HashSet<Employee> hashSet = new HashSet<>();
        hashSet.add(employee1);
        hashSet.add(employee2);
        hashSet.add(employee3);

        Iterator<Employee> iterator = hashSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

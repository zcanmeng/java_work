package com.cm.homework07;

import java.util.HashSet;
import java.util.Iterator;

public class HomeWork {
    public static void main(String[] args) {
        Employee employee1 = new Employee("小明",18);
        Employee employee2 = new Employee("小明",28);
        Employee employee3 = new Employee("小明",18);

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
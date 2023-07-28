package com.cm.homework07;

import java.util.Objects;

public class Employee {
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public Employee(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){
            return false;
        }
        Employee employee = (Employee) obj;
        return age==employee.getAge() && name.equals(employee.getName());

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }
}

package com.cm.polyparameter;

public class Work extends Employee{
    public Work(String name, Double salary) {
        super(name, salary);
    }

    public Work() {
    }

    @Override
    public Double getAnnual(){
        return super.getAnnual();
    }

    public void work(){
        System.out.println("员工："+super.getName()+"正在工作");
    }
}

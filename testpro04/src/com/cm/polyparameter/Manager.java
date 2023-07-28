package com.cm.polyparameter;

public class Manager extends Employee{
    private Double bonus;

    public Manager() {
    }

    public Manager(String name, Double salary, Double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public Double getAnnual() {
        return super.getAnnual()+bonus;
    }

    public void manage(){
        System.out.println("管理员："+getName()+"正在工作");
    }
}

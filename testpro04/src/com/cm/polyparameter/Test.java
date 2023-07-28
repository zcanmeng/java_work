package com.cm.polyparameter;

public class Test {
    public static void main(String[] args) {
        Work xiaoming = new Work("小明",3000.0);
        System.out.println(showEmpAnnual(xiaoming));
        testWork(xiaoming);

        Manager xiaohong = new Manager("小红",4000.0,3000.0);
        System.out.println(showEmpAnnual(xiaohong));
        testWork(xiaohong);
        System.out.println(xiaohong.getClass());
    }

    public static Double showEmpAnnual(Employee employee){
        return employee.getAnnual();
    }
    public static void testWork(Employee employee){
        if(employee instanceof Work){
            ((Work) employee).work();
        }else if(employee instanceof Manager){
            ((Manager) employee).manage();
        }
    }
}

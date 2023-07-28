package com.cm.homework05;

public class Car {
    private Double temperature;
    public Car(Double temperature){
        this.temperature=temperature;
    }

    class Air{
        public void flow(){
            if(temperature>40){
                System.out.println("吹冷气");
            }else if(temperature<0){
                System.out.println("吹暖风");
            }else {
                System.out.println("空调停止工作");
            }
        }
    }
}

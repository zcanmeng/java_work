package com.cm.homework06;

public enum  Color implements ToShow{
    RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),YELLOW(255,255,0),GREEN(0,255,0);
    private Integer redValue;
    private Integer greenValue;
    private Integer blueValue;

    private Color(Integer redValue,Integer greenValue,Integer blueValue){
        this.redValue=redValue;
        this.greenValue=greenValue;
        this.blueValue=blueValue;
    }
    public void show(){
        System.out.println(this.redValue);
        System.out.println(this.greenValue);
        System.out.println(this.blueValue);
    }
}

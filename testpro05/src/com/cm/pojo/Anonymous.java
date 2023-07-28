package com.cm.pojo;

public class Anonymous {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.p();
    }
}
class Outer{
    public void p(){
        Inner inner = new Inner(){
            public void cry(){
                System.out.println("嗷呜");
            }
        };
        System.out.println(inner.a);
    }
}

class Inner{
    public int a = 1;
}

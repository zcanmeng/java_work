package com.cm.homework06;

public class Book {
    private String name;
    private Integer money;

    public Book(String name,Integer money){
        this.name=name;
        this.money=money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "作者："+this.name+"价格"+this.money;
    }
}

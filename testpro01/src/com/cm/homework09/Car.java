package com.cm.homework09;

import java.util.Objects;

public class Car {
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Car(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() !=obj.getClass()) return false;

        Car car = (Car) obj;
        return this.name.equals(car.name) && this.price.equals(price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,price);
    }
}

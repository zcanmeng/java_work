package com.cm.collectionwork.homework02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        Car car1 = new Car("宝马",200000.0);
        Car car2 = new Car("东方",9990000.0);
        Car car3 = new Car("本田",2999000.0);
        Car car4 = new Car("一气",5400000.0);
        Car car5 = new Car("奥迪",3453400000.0);
        Car car6 = new Car("凯迪拉克",345220000.0);

        ArrayList<Car> list = new ArrayList<Car>();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);
        list.add(car6);

        for(Car car : list){
            System.out.println(car);
        }

        list.remove(5);

        Iterator<Car> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        boolean flog = list.contains(new Car("东方", 9990000.0));
        System.out.println(flog);

        int size = list.size();
        System.out.println("size:"+size);

        boolean empty = list.isEmpty();
        System.out.println("empty:"+empty);

        list.clear();
        for(Car car:list){
            System.out.println(car);
        }

        List<Car> list1 = new ArrayList<>();
        list1.add(car1);
        list1.add(car2);
        list1.add(car3);
        list.addAll(list1);
        Iterator<Car> iterator1 = list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        list.add(car5);
        boolean contain = list.containsAll(list1);
        System.out.println("containsAll:"+contain);

        list.removeAll(list1);
        for(Car car:list){
            System.out.println(car);
        }

        HashSet hashSet = new HashSet();
        hashSet.add(car1);
        hashSet.add(car2);
        car1.setName("小米");
        hashSet.remove(car1);

        Iterator iterator2 = hashSet.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}

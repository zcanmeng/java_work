package com.cm.homework06;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(new Book("红楼梦",100));
        list.add(new Book("红楼梦",122));
        list.add(new Book("红楼梦",999));
        list.add(new Book("红楼梦",611));
        list.add(new Book("红楼梦",133));


        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next());

        }
        System.out.println();


        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1=(Book)o1;
                Book b2=(Book)o2;
                return b1.getMoney()-b2.getMoney();
            }
        });

        iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next());

        }
    }
}

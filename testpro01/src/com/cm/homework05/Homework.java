package com.cm.homework05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("xx");
        list.add("hh");
        list.add("jj");
        list.add("kk");
        list.add("ll");
        list.add("mm");
        list.add("nn");
        list.add("bb");
        list.add("vv");
        list.add("cc");

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"   ");
        }
        System.out.println();

        list.add(1,"hello");
        String string= (String) list.get(4);
        System.out.println(string);
        list.remove(5);
        list.set(7,"jiujiu");
        iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"   ");
        }
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}

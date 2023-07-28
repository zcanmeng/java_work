package com.cm.homework09;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Homework {
    public static void main(String[] args){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("小明",100));
        linkedHashSet.add(new Car("小明",1010));
        linkedHashSet.add(new Car("小明",100));

        Iterator iterator = linkedHashSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

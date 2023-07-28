package com.cm.homework10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Homework {
    public static void main(String[] args){
        HashMap hashMap = new HashMap();
        hashMap.put("1","小明");
        hashMap.put("2","西奥吗");
        hashMap.put("3","小号");
        hashMap.put("4","大红");

        Set set = hashMap.keySet();
        for (Object obj:set) {
            System.out.println(obj +" "+ hashMap.get(obj));
        }

        System.out.println("--------------------------------");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj +" "+ hashMap.get(obj));

        }

        System.out.println("--------------------------------------");
        Set set1 = hashMap.entrySet();
        for (Object obj:set1){
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}

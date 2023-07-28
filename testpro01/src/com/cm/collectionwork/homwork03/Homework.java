package com.cm.collectionwork.homwork03;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);

        map.put("jack",2600);
        Set set = map.keySet();
        for(Object value:set){
            map.put(value,(Integer)map.get(value)+100);
        }

        for (Object key:set){
            System.out.println("key:"+key+"value:"+map.get(key));
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String key = (String)iterator.next();
            System.out.println("key:"+key+"value:"+map.get(key));
        }
        Set set1 = map.entrySet();
        for (Object value:set1){
            Map.Entry entry = (Map.Entry) value;
            System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());
        }
    }
}

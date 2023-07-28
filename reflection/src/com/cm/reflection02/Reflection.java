package com.cm.reflection02;

import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //获取User的Class对象
        Class<?> aClass = Class.forName("com.cm.pojo.User");

        //创建一个User对象
        Object o = aClass.newInstance();

        //获取private属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);


        System.out.println(o);
        //访问属性(如果是静态的o可以写成null，因为静态方法是公共的)
        name.set(o,"小明");
        Object o1 = name.get(o);
        System.out.println(o1);

        System.out.println(o);
    }
}

package com.cm.refection01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取User的Class
        Class<?> cls = Class.forName("com.cm.pojo.User");

        //通过public的无参构造器创建实例
        //获取无参构造
        Constructor<?> constructor = cls.getConstructor();
        //创建对象
        Object o = constructor.newInstance();
        System.out.println("无参构造："+o);

        //通过public的有参构造器创建实例
        //获取有参构造
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        //创建对象
        Object o2 = constructor1.newInstance( "小明");
        System.out.println("public有参构造；"+o2);

        //通过private的有参构造器创建实例
        //获取私有有参构造
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
        //爆破
        declaredConstructor.setAccessible(true);
        //创建对象
        Object o3 = declaredConstructor.newInstance(1,"红花");
        System.out.println("private有参构造："+o3);

    }
}

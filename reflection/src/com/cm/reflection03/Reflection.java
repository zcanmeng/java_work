package com.cm.reflection03;

import com.cm.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //获取User的Class对象
        Class<?> aClass = Class.forName("com.cm.pojo.User");

        //创建对象
        Object o = aClass.newInstance();

        //获取无参方法
        Method hello = aClass.getMethod("hello");
        hello.invoke(o);

        //获取有参方法
        Method method = aClass.getMethod("hello", String.class);
        method.invoke(o,"小明");

        //获取private有参方法
        Method hello1 = aClass.getDeclaredMethod("hello", int.class, String.class);
        //爆破
        hello1.setAccessible(true);
        //如果是静态方法可以写成null,如果由返回值就在前面接就行
        hello1.invoke(o,1,"小明");
    }
}

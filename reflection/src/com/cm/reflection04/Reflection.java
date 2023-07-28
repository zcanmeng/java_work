package com.cm.reflection04;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //获取PrivateTest的Class对象
        Class<?> aClass = Class.forName("com.cm.reflection04.PrivateTest");

        //创建对象
        Object o = aClass.newInstance();

        //获取方法
        Method getName = aClass.getMethod("getName");

        getName.invoke(o);

        //获取私有属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"小明");
        getName.invoke(o);

    }
}

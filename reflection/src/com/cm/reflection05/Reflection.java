package com.cm.reflection05;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Driver;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> file = Class.forName("java.io.File");

        Constructor<?>[] declaredConstructors = file.getDeclaredConstructors();
        Constructor<?> file1 = file.getDeclaredConstructor(String.class);
        Object o = file1.newInstance("E:/mynew.txt");
        Method createNewFile = file.getDeclaredMethod("createNewFile");
        createNewFile.invoke(o);


    }
}

package com.cm.reflection06;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.cm.reflection06.Test");
        //获取类的注解
        TableM annotation = aClass.getAnnotation(TableM.class);
        System.out.println(annotation.value());


        //获取字段的注解
        Field name = aClass.getDeclaredField("name");
        FieldM annotation1 = name.getAnnotation(FieldM.class);
        AnnotatedType annotatedType = name.getAnnotatedType();
        System.out.println(annotatedType);
        System.out.println(annotation1.name());
        System.out.println(annotation1.value());
    }
}

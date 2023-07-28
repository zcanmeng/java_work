package com.cm.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {
    public static void main(String[] args) {
        String context = "Java平台由Java虚拟机(Java Virtual Machine)和Java 应用编程接口(Application Programming Interface、简称API)构成。Java 应用编程接口为Java应用提供了一个独立于操作系统的标准接口，可分为基本部分和扩展部分。在硬件或操作系统平台上安装一个Java平台之后，Java应用程序就可运行。Java平台已经嵌入了几乎所有的操作系统。这样Java程序可以只编译一次，就可以在各种系统中运行。Java应用编程接口已经从1.1x版发展到1.2版。常用的Java平台基于Java1.8，最近版本为Java19。";

        //创建Pattern对象
        Pattern compile = Pattern.compile("[a-zA-Z]+");

        //获取matcher匹配器，按照pattern（模式/样式），到context中查找
        Matcher matcher = compile.matcher(context);

        //找到返回true
        while (matcher.find()){
            //匹配到的内容放在matcher.group中
            // matcher中有一个数组，int[] groups,下标0存储的是匹配字符串的开始位置，下标1为结束位置，并在oldLast记录结束位置+1
            System.out.println(matcher.group(0));
        }
    }
}

package com.cm.regexp02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {
    public static void main(String[] args) {
        String context = "我是你你不值一一一一提的可可可可可有可无";

        String reg = "(.)\\1+";

        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(context);
        String result = matcher.replaceAll("$1");
        System.out.println(result);
//        while (matcher.find()){
//            System.out.println(matcher.group(0));
//        }
    }
}

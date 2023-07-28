package com.cm.regexp03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {
    public static void main(String[] args) {
        String context = "zcanmeng@qq.com.";

        String reg = "^[\\w-]+@([a-zA-Z]+\\.)+[[a-zA-Z]]+$";

        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(context);

        if (matcher.find()){
            System.out.println("匹配成功");
        }else {
            System.out.println("匹配失败");
        }
    }
}

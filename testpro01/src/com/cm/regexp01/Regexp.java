package com.cm.regexp01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {
    public static void main(String[] args) {
        //查询是否是汉字
        String context = "1312311";

//        String reg = "^[\u0391-\uffe5]+$";

//        String reg ="^\\d{6}$";

        String reg = "^[1-9]\\d{4,9}$";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(context);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}

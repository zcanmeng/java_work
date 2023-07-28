package com.cm.utils;

import java.util.Scanner;

/**
 * 输入工具类
 */
public class ScannerUtil {
    //初始化
    private static Scanner scanner=new Scanner(System.in);

    /**
     * 读取字符串，根据传来的参数进行控制
     * @param num 控制需要几位，如果是0就
     * @return 返回一个字符串
     */
    public static String readString(int num){
        String s = scanner.next();
        if (s.length()>num){
            s=s.substring(0,num);
        }

        return s;
    }
}

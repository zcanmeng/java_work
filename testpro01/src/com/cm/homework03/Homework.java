package com.cm.homework03;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args){
        String s = reverse("abcdef", 1, 4);
        System.out.println(s);
    }
    public static String reverse(String str,int start,int end){
        char[] chars = str.toCharArray();
        for (int i = (end-start+1)/2;start<=i;start++,end--){
            char temp=chars[end];
            chars[end]=chars[start];
            chars[start]=temp;
        }
        String s = new String(chars);

        return s;
    }
}

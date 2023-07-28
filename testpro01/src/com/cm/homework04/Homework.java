package com.cm.homework04;

public class Homework {
    public static void main(String[] args){
        try {
            String s = userRegister("122", "123123", "2211.co@om");
            System.out.println(s);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    public static String userRegister(String name,String pass,String emil){

        int length = name.length();
        if(length<2||length>4){
            throw new RuntimeException("长度不正确，请输入长度为2-4个字符");
        }

        if(pass.length()!=6 || !isPassword(pass)){
            throw new RuntimeException("长度必须六位，并且密码必须是数字");
        }

        if(!isEmil(emil)){
            throw new RuntimeException("邮箱格式错误");
        }

        return "注册成功";
    }

    public static boolean isEmil(String emil){
        int i = emil.indexOf("@");
        int j = emil.indexOf(".");
        if(i>j || i==0 ||emil.isEmpty()){
            return false;
        }

        return true;
    }

    public static boolean isPassword(String pass){
        char[] chars = pass.toCharArray();
        for(int i =0;i<chars.length;i++){
            if(chars[i]<'0'||chars[i]>'9'){
                return false;
            }
        }

        return true;
    }
}

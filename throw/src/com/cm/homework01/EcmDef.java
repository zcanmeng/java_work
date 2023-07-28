package com.cm.homework01;

public class EcmDef {
    public static void main(String[] args) {

        try{
            if(args.length!=2){
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }

            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            int res = chu(num1, num2);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("数字计算错误");
        }catch (NumberFormatException e){
            System.out.println("转换类型不对");
        }
    }

    public static int chu(int num1,int num2){
        return num1/num2;
    }
}

package com.cm.math01;

import java.util.Date;

public class Math {
    public static void main(String[] args) {
        int num1=0;
        int num2 = 4;
        int sum = 0;

        for (int a =0;a<10;a++){
            for (int b =0;b<10;b++){
                if (b==a) continue;
                for (int c =0;c<10;c++){
                    if (c==b || c==a)continue;
                    for (int d =0;d<10;d++){
                        if (d==a || d==b || d==c) continue;
                        else {
                            num1=a*1000+b*100+c*10+d;
                            sum=d*1000+c*100+b*10+a;
                            if (sum==num1*num2){
                                System.out.println(num1);
                            }
                        }
                    }
                }
            }
        }
    }
}

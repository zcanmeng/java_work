package com.cm.homework02;

import java.util.Arrays;
import java.util.Comparator;

public class Homework {
    public static void main(String[] args) {
        Book[] book=new Book[5];
        book[0]=new Book("西游记",100.0);
        book[1]=new Book("jojo历险记",999.9);
        book[2]=new Book("成龙历险记",88.8);
        book[3]=new Book("老爹来咯",888.8);
        book[4]=new Book("要用魔法打败魔法",110000.0);

        Book book1 = new Book();

        test(book1);

        System.out.println(book1.getName());




//        Arrays.sort(book, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                Double result=o1.getPrice()-o2.getPrice();
//                if(result>0){
//                    return -1;
//                }else if(result<0){
//                    return 1;
//                }else {
//                    return 0;
//                }
//            }
//        });
//
//        System.out.println(Arrays.toString(book));
//
//        Arrays.sort(book, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getName().length()-o2.getName().length();
//            }
//        });
//
//        System.out.println(Arrays.toString(book));
    }

    public static void test(Book books){
        books.setName("111111111111");
    }
}

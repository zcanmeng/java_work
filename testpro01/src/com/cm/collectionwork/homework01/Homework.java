package com.cm.collectionwork.homework01;

import java.util.ArrayList;

public class Homework {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧","");
        News news2 = new News("男子突然想起2月前钓的鱼还在网兜里，捞起一看赶紧放生","");

        ArrayList arrayList = new ArrayList();

        arrayList.add(news1);
        arrayList.add(news2);

        for (int i = arrayList.size()-1;i>=0;i--){
            System.out.println(arrayList.get(i));
        }

        for (int i = arrayList.size()-1;i>=0;i--){
            News news = (News) arrayList.get(i);
            String title = news.getTitle();
            if (title.length()>15){
                String substring = title.substring(0, 15);
                news.setTitle(substring+"...");
                arrayList.set(i,news);
            }
        }

        for (int i = arrayList.size()-1;i>=0;i--){
            System.out.println(arrayList.get(i));
        }



    }
}

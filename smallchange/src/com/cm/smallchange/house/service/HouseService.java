package com.cm.smallchange.house.service;

import com.cm.smallchange.house.pojo.House;

public class HouseService {
    private House[] houses;//保存House数据

    public HouseService(){
        houses = new House[5];
        houses[0]=new House(1,"小明","116","湖北黄石",1000,"未出租");
        houses[1]=new House(2,"黎明","999","湖北黄石",1200,"未出租");
        houses[2]=new House(3,"蓬头","666","湖北黄石",4300,"未出租");
        houses[3]=new House(4,"嚣张","999","湖北黄石",4000,"未出租");
        houses[4]=new House(5,"通胀","000","湖北黄石",6000,"未出租");
    }

    public House[] list(){
        return houses;
    }

    public void add(House house){

        House[] newHouse=new House[houses.length+1];

        //拷贝到新数组
        for (int i = 0; i < houses.length; i++) {
            newHouse[i]=houses[i];
        }

        //添加
        house.setId(houses[houses.length-1].getId()+1);
        newHouse[houses.length]=house;

        houses=newHouse;

    }

    public void delete(int id){
        House[] newHouse=new House[houses.length-1];

        //拷贝到新数组
        for (int i = 0,flog=0; i < houses.length; i++) {
            if(houses[i].getId()==id){
                continue;
            }
            newHouse[flog]=houses[i];
            flog++;
        }

        houses=newHouse;
    }
}

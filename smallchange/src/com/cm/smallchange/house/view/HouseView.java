package com.cm.smallchange.house.view;

import com.cm.smallchange.house.pojo.House;
import com.cm.smallchange.house.service.HouseService;
import com.cm.smallchange.house.utils.Utility;

/**
 * 1.显示界面
 * 2.接收用户的输入
 * 3.调用HouseService完成对王五信息的各种操作
 */
public class HouseView {

    //控制退出
    private boolean loop = true;

    //接收操作码
    private char key = ' ';

    private HouseService houseService = new HouseService();


    //主菜单
    public void mainMenu() {
        do {
            System.out.println("---------------------房屋出租系统-------------------------");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出");
            System.out.print("请输入您的选择（1-6）：");

            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':

                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':

                    break;
                case '5':
                    listHouse();
                    break;
                case '6':

                    break;
                default:
                    System.out.println("输入有误！");
                    break;
            }

        } while (loop);
    }

    public void listHouse(){
        House[] houses = houseService.list();

        System.out.println("---------------------房屋列表-------------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        for (House house: houses) {
            System.out.println(house);
        }
    }

    public void addHouse(){
        House house = new House();
        System.out.print("姓名：");
        house.setName(Utility.readString());
        System.out.print("电话：");
        house.setPhone(Utility.readString());
        System.out.print("地址：");
        house.setAddress(Utility.readString());
        System.out.print("月租：");
        house.setRent(Utility.readInt());
        System.out.print("状态（未出租/已出租）：");
        house.setState(Utility.readString());

        houseService.add(house);
    }

    public void deleteHouse(){
        System.out.print("请选择待删除房屋编号：");
        houseService.delete(Utility.readInt());
    }
}

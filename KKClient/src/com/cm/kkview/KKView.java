package com.cm.kkview;


import com.cm.kkservice.UserClientService;
import com.cm.utils.ScannerUtil;

/**
 * 客户端界面
 */
public class KKView {

    private boolean loop = true;//控制是否显示菜单

    private String key="";//用于接收用户的键盘输入

    private UserClientService userClientService = new UserClientService();//用户服务

    public static void main(String[] args) {
        new KKView().mainMenu();
        System.out.println("客户端退出系统");
    }

    private void mainMenu(){
        while (loop){
            System.out.println("=================欢迎登录网络通信系统====================");
            System.out.println("\t\t1 登录系统");
            System.out.println("\t\t9 退出系统");
            System.out.print("请输入您的选择：");

            key = ScannerUtil.readString(1);

            //根据用户的输入，来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入账号：");
                    String userName= ScannerUtil.readString(50);
                    System.out.print("请输入密码：");
                    String password = ScannerUtil.readString(50);

                    //判断是否登录成功
                    if (userClientService.checkUser(userName,password)){//登录成功
                        System.out.println("=================欢迎(用户"+userName+")====================");

                        //二级菜单
                        while (loop){
                            System.out.println("=================网络通信系统二级菜单(用户"+userName+")====================");
                            System.out.println("\t\t1 显示在线用户列表");
                            System.out.println("\t\t2 群发消息");
                            System.out.println("\t\t3 私聊消息");
                            System.out.println("\t\t4 发送文件");
                            System.out.println("\t\t9 退出系统");
                            System.out.print("请输入你的选择：");

                            key=ScannerUtil.readString(1);
                            switch (key){
                                case "1":
                                    //显示在线用户列表
                                    userClientService.onLineFriendList();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    userClientService.sendGroup();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    userClientService.sendContent();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    userClientService.sendFile();
                                    break;
                                case "9":
                                    //退出
                                    userClientService.logout();
                                    loop=false;
                                    break;
                            }

                        }

                    }else {//登录服务器失败
                        System.out.println("登录失败！");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }

}

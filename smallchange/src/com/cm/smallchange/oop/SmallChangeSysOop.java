package com.cm.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOop {

    //定义变量
    private boolean loop = true;

    private Scanner scanner = new Scanner(System.in);
    private String key = "";

    //使用的金额
    private double money = 0;
    private double sum = 0;

    //时间
    private Date date = null;

    //格式化时间
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //使用详情
    private String details = "==================零钱通明细===================\n";

    private String exit = "";

    public void smallchange() {
        do {
            //菜单
            System.out.println("===================零钱通菜单=====================");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.print("请选择（1-4）：");
            key = scanner.next();

            //控制语句
            switch (key) {
                case "1":
                    showDetails();
                    break;
                case "2":
                    income();
                    break;
                case "3":
                    consume();
                    break;
                case "4":
                    quit();
                    break;
                default:
                    System.out.println("输入有误！");
            }

        } while (loop);

        System.out.println("零钱通系统已退出。。。");
    }

    private void showDetails() {
        System.out.println(details);
    }

    private void income() {
        System.out.print("收入金额为：");
        money = scanner.nextDouble();

        //收入小于0提示输入错误，并退出
        if (money < 0) {
            System.out.println("输入金额不能小于0！");
            return ;
        }
        sum += money;
        date = new Date();
        details += "收益入账\t" + money + "\t时间：" + simpleDateFormat.format(date) + "\t总金额：" + sum + "\n";
    }

    private void consume() {
        System.out.print("消费金额为：");
        money = scanner.nextDouble();

        //消费金额大于有的金额
        if (money > sum) {
            System.out.println("余额不足！");
            return;
        }
        sum -= money;
        date = new Date();
        details += "消费\t\t" + money + "\t时间：" + simpleDateFormat.format(date) + "\t总金额：" + sum + "\n";
    }

    private void quit() {
        System.out.println("退出");

        //限定只能输入y或n否则一直输入
        while (true) {
            System.out.print("确定退出吗？（y/n）：");
            exit = scanner.next();
            if ("y".equals(exit) || "n".equals(exit)) {
                break;
            }
        }
        if ("y".equals(exit)) {
            loop = false;
        }
    }
}

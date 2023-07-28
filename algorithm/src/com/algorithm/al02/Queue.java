package com.algorithm.al02;

public class Queue {
    private int maxSize;
    private int header;
    private int footer;
    private int[] arr;

    public Queue(int maxSize){
        this.maxSize=maxSize;//初始化数组大小
        arr=new int[maxSize];//初始化数组
        header=-1;//头部
        footer=-1;//尾部
    }

    //判断是否满了
    public boolean isFull(){
        return footer==maxSize-1;
    }

    //判断是否为空
    public boolean isEmpty(){
        return header == footer;
    }

    //存数据
    public void add(int n){
        //判断是否满了
        if (isFull()){
            System.out.println("数据满咯！");
            return;
        }

        footer++;
        arr[footer]=n;
    }

    //取数据
    public void del(){
        //检查是否为空
        if (isEmpty()){
            System.out.println("没有数据咯！");
            return;
        }

        header++;
    }

    //查看全部数据
    public void get(){
        if (isEmpty()){
            System.out.println("里面没有数据哦！");
        }

        for (int i = header+1;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}

package com.algorithm.al03;

public class LoopQueue {
    private int header;//头部
    private int footer;//尾部
    private int maxSize;//最大个数
    private int[] arr;//存储数据的数组

    //初始化
    public LoopQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        header=0;
        footer=0;
    }

    //判断是否满了
    private boolean isFull(){
        if ((footer+1)%maxSize==header){//由于footer为0，所以判断时需要+1，
            return true;
        }
        return false;
    }

    //判断是否为空
    private boolean isEmpty(){
        if (footer==header){
            return true;
        }

        return false;
    }

    //添加数据
    public void add(int num){
        if (isFull()){
            throw new RuntimeException("队列满咯！");
        }

        arr[footer]=num;
        //移向下一个位置
        footer=(footer+1)%maxSize;
    }

    //取出数据
    public int del(){
        if (isEmpty()){
            throw new RuntimeException("队列中没有数据！");
        }

        //返回的数据
        int num = arr[header];
        //移向下一个位置
        header=(header+1)%maxSize;

        return num;
    }

    //展示存储的数据
    public void show(){
        if (isEmpty()){
            throw new RuntimeException("队列中没有数据！");
        }

        for (int i = header;i<header+(footer+maxSize-header)%maxSize;i++){
            System.out.println(arr[i%maxSize]);
        }
    }
}

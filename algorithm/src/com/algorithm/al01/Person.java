package com.algorithm.al01;

import java.io.*;

public class Person {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Sparse sparse = new Sparse();
        int[][] arr={{0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,2,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},};


        arr[8][8]=1;
        int[][] result = sparse.changeSparse(arr);

        for (int i = 0 ;i < result.length;i++){
            for (int j = 0 ;j < result[i].length;j++){
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("数组：");

        int[][] change = sparse.changeArr(result);
        for (int i = 0;i<change.length;i++){
            for (int j = 0;j<change[i].length;j++){
                System.out.print(change[i][j]+"\t");
            }
            System.out.println();
        }

//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\编程\\a.data"));
//
//        objectOutputStream.writeObject(change);
//        objectOutputStream.close();

        //读取的数据
        System.out.println("恢复后的数据");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\编程\\a.data"));
        int[][] data = (int[][])objectInputStream.readObject();
        for (int i = 0;i<change.length;i++){
            for (int j = 0;j<change[i].length;j++){
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
        }
    }


}

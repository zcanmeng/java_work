package com.cm.Reader.homework01;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Homework {
    public static void main(String[] args) {
        FileReader fileReader = null;
        String src = "E:\\编程\\数据库\\数据库.txt";

        char[] data=new char[8];
        int leng=0;

        try {
            fileReader = new FileReader(src);
            while ((leng=fileReader.read(data))!=-1){
                System.out.print((new String(data,0,leng)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

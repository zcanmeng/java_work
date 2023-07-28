package com.cm.homework14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework {
    public static void main(String[] args) {
        FileInputStream fileInputStream =null;
        FileOutputStream fileOutputStream=null;

        String src ="E:\\编程\\ASKII.jfif";
        String target="E:\\编程\\askii.jpg";


        try {
            fileInputStream=new FileInputStream(src);
            fileOutputStream=new FileOutputStream(target);

            byte[] b = new byte[1024];
            int leng=0;

            while ((leng=fileInputStream.read(b))!=-1){
                fileOutputStream.write(b,0,leng);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

                try {
                    if (fileInputStream!=null){
                        fileInputStream.close();
                    }
                    if (fileOutputStream!=null){
                    fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}

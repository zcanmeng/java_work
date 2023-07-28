package com.cm.Reader.homework04;

import java.io.File;
import java.io.IOException;

public class Homework {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\编程\\mytemp");
        boolean exists = file.exists();
        if (!exists){
            file.mkdir();
            System.out.println("创建了");
            File txt = new File("E:\\编程\\mytemp\\hello.txt");
            boolean txtExists = txt.exists();
            if(!txtExists){
                txt.createNewFile();
            }else {
                System.out.println("文件已存在");
            }
        }else {
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File file1:files){
                    file1.delete();
                }
            }
            file.delete();
            System.out.println("文件已存在");
        }
    }
}

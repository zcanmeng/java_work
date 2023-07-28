package com.cm.Reader.homework03;

import java.io.*;

public class Homework {
    public static void main(String[] args) {
        BufferedInputStream bis=null;
        BufferedOutputStream bos = null;

        String src="E:\\编程\\ASKII.jfif";
        String target="E:\\编程\\ASKII副本.jfif";

        try {
            bis=new BufferedInputStream(new FileInputStream(src));
            bos=new BufferedOutputStream(new FileOutputStream(target));

            byte[] buf=new byte[1024];
            int length=0;

            while((length=bis.read(buf))!=-1){
                bos.write(buf,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis!=null){
                    bis.close();
                }
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

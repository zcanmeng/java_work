package com.cm.Reader.homework02;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class Homework {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        String src="E:\\编程\\数据库\\数据库.txt";
        String target="E:\\编程\\数据库\\数据库副本.txt";

        String data="";

        try {
            bufferedReader=new BufferedReader(new FileReader(src));
            bufferedWriter = new BufferedWriter(new FileWriter(target));

            while ((data=bufferedReader.readLine())!= null){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader!=null){
                    bufferedReader.close();
                }
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

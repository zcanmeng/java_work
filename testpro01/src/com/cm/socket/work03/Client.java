package com.cm.socket.work03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //获取socket服务
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);

        //获取输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //获取输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //输出数据
        Scanner scanner = new Scanner(System.in);
            System.out.print("请输入想问的问题：");
            String question = scanner.next();

            bufferedWriter.write(question);

            //写入
            bufferedWriter.flush();
            socket.shutdownOutput();

            //获取回复的信息
            String line = bufferedReader.readLine();
            System.out.println(line);


        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}

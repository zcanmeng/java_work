package com.cm.socket.work03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //监听9999端口数据
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("服务端准备完毕！");
        //接收数据，没接收到会阻塞
        Socket socket = serverSocket.accept();

        //获取输入流,并转为字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line=bufferedReader.readLine();

            if ("name".equals(line)){
                bufferedWriter.write("我是nove");
            }else if ("hobby".equals(line)){
                bufferedWriter.write("编写java程序");
            }else {
                bufferedWriter.write("你讲啥呢？");
            }

            //写入数据
            bufferedWriter.flush();

            //标记写完了
            socket.shutdownOutput();

        //关闭资源
        bufferedReader.close();
        bufferedWriter.close();
        serverSocket.close();
        socket.close();


    }
}

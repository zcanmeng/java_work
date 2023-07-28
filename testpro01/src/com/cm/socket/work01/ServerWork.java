package com.cm.socket.work01;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class ServerWork {
    public static void main(String[] args) throws IOException {
        //监听的端口
        ServerSocket serverSocket = new ServerSocket(9999);

        //接收客户端连接，没有连接会阻塞
        Socket accept = serverSocket.accept();
        System.out.println("连接上咯！");

        //获取输入流读取信息
        InputStream input = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        //缓冲
        String line="";
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        OutputStream output = accept.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
        bufferedWriter.write("hello,writer");
        bufferedWriter.flush();
        //标记输出完毕
        accept.shutdownOutput();

        //关闭资源
        bufferedReader.close();
        bufferedWriter.close();
        serverSocket.close();
        accept.close();
        System.out.println("收到退出！");
    }
}

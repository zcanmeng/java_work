package com.cm.socket.work02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //设置监听端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //等待接收信息
        Socket socket = serverSocket.accept();

        //获取输入流
        InputStream inputStream = socket.getInputStream();

        //获取输出流，用于保存图片
        FileOutputStream outputStream = new FileOutputStream("src\\tcp.jpg");

        //缓存
        byte[] buf = new byte[1024];

        //长度
        int length=0;

        //读取后进行保存
        while ((length=inputStream.read(buf))!=-1){
            outputStream.write(buf,0,length);
        }

        //返回告诉已接收
        OutputStream socketOutputStream = socket.getOutputStream();
        socketOutputStream.write("收到图片".getBytes());
        //提示输出结束
        socket.shutdownOutput();

        //结束关闭资源
        inputStream.close();
        outputStream.close();
        socketOutputStream.close();
        socket.close();
        serverSocket.close();

    }
}

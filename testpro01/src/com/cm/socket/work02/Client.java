package com.cm.socket.work02;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端，发送图片并接收信息
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //绑定服务端端口
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);

        //发送信息
        OutputStream socketOutputStream = socket.getOutputStream();

        //获取输入流，用来获取图片
        FileInputStream inputStream = new FileInputStream("E:\\编程\\ASKII.jfif");

        //缓存
        byte[] buf = new byte[1024];

        //长度
        int length=0;

        //读取并发送
        while ((length=inputStream.read(buf))!=-1){
            socketOutputStream.write(buf,0,length);
        }

        //输出完毕
        socket.shutdownOutput();

        //接收反馈信息
        InputStream socketInputStream = socket.getInputStream();
        //打印信息
        byte[] ouputBuf = new byte[1024];
        int ouputLength = 0;

        while ((ouputLength=socketInputStream.read(ouputBuf))!=-1){
            System.out.println(new String(ouputBuf,0,ouputLength));
        }

        //结束关闭资源
        socketInputStream.close();
        socketOutputStream.close();
        inputStream.close();
        socket.close();

    }
}

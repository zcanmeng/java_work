package com.cm.socket.datagramsocket;

import java.io.IOException;
import java.net.*;

/**
 * 发送端
 */
public class GramB {
    public static void main(String[] args) throws IOException {
        //监听8888端口
        DatagramSocket socket = new DatagramSocket(8888);

        //创建发送的信息
        byte[] data = "hello,明天吃火锅".getBytes();

        DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getByName("127.0.0.1"),9999);

        socket.send(packet);

        //创建缓存 最大64kb
        byte[] buf = new byte[1024];

        DatagramPacket outPacket = new DatagramPacket(buf,buf.length);

        //等待接收信息
        socket.receive(outPacket);

        //拆包
        byte[] outData = outPacket.getData();
        int length = outPacket.getLength();

        System.out.println(new String(outData,0,length));

        socket.close();
        System.out.println("发送完毕！");

    }
}

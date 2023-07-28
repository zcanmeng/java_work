package com.cm.socket.datagramsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 接收端
 */
public class GramA {
    public static void main(String[] args) throws IOException {
        //监听9999端口
        DatagramSocket socket = new DatagramSocket(9999);

        //创建缓存 最大64kb
        byte[] buf = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buf,buf.length);

        //等待接收信息
        socket.receive(packet);

        //拆包
        byte[] data = packet.getData();
        int length = packet.getLength();

        System.out.println(new String(data,0,length));

        //创建发送的信息
        byte[] outData = "好的,明天吃火锅".getBytes();

        DatagramPacket outPacket = new DatagramPacket(outData,outData.length, InetAddress.getByName("127.0.0.1"),8888);

        socket.send(outPacket);

        socket.close();
        System.out.println("退出接收！");
    }
}

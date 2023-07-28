package com.cm.socket.work04;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 接收端
 */
public class Clint {
    public static void main(String[] args) throws IOException {

        //监听端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        //发送的数据
        byte[] data = "四大名著是哪些".getBytes();

        //创建数据包
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 8888);

        //发送
        datagramSocket.send(packet);

        //缓存
        byte[] buf = new byte[1024];
        //接收数据的数据包
        packet = new DatagramPacket(buf,buf.length);
        //准备接收
        datagramSocket.receive(packet);

        //拆包
        int length = packet.getLength();
        byte[] data1 = packet.getData();
        System.out.println(new String(data1,0,length));

    }
}

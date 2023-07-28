package com.cm.socket.work04;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 接收端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //绑定端口
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        //缓存
        byte[] buf = new byte[1024];

        //创建数据包
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //等待接收
        datagramSocket.receive(packet);

        //拆包
        int length = packet.getLength();
        byte[] data = packet.getData();

        String s = new String(data, 0, length);
        System.out.println(s);
        if ("四大名著是哪些".equals(s)){
            byte[] write="四大名著是《红楼梦》，《水浒传》，《西游记》，《三国演义》".getBytes();
            packet = new DatagramPacket(write,write.length, InetAddress.getByName("127.0.0.1"),9999);
            datagramSocket.send(packet);
        }else {
            byte[] write = "what？".getBytes();
            packet = new DatagramPacket(write,write.length, InetAddress.getByName("127.0.0.1"),9999);
            datagramSocket.send(packet);
        }

        datagramSocket.close();

    }
}

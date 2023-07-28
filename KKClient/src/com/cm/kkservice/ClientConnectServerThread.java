package com.cm.kkservice;

import com.cm.kkcommon.Message;
import com.cm.kkcommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 */
public class ClientConnectServerThread extends Thread{
    //需要持有Socket
    private Socket socket=null;

    public ClientConnectServerThread(Socket socket){
        this.socket=socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("客户端线程");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) objectInputStream.readObject();

                //判断返回数据的类型
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){

                    //分割用户信息
                    String[] onlineUser = message.getContent().split(" ");

                    //显示在线用户列表
                    System.out.println("=============当前在线用户列表=================");
                    for (String value:onlineUser){
                        System.out.println("用户："+value);
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){//读取发送过来的信息
                    System.out.println(message.getSender()+"对"+message.getGetter()+"说："+message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_FAIL)){//发送失败返回的信息
                    System.out.println(message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_GROUP)){//发送失败返回的信息
                    System.out.println(message.getSender()+"对大家说："+message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){//接收文件
                    System.out.println("接收到"+message.getSender()+"发来的文件");

                    //输出流
                    FileOutputStream fileOutputStream = new FileOutputStream("E:/《WEB开发基础》课程设计报告（测试）.doc");

                    fileOutputStream.write(message.getFile());

                    fileOutputStream.close();
                }else {
                    System.out.println("是其他类型的message，暂不处理");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.cm.kkservice;

import com.cm.kkcommon.Message;
import com.cm.kkcommon.MessageType;
import com.cm.kkcommon.User;
import com.cm.utils.ScannerUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 该类完成用户登录验证和用户注册等等
 */
public class UserClientService {
    private User user = new User();
    private Socket socket=null;

    //登录，登录成功生成线程并保存到列表中
    public boolean checkUser(String name,String pwd) {
        boolean b = false;
        //注入用户信息
        user.setName(name);
        user.setPassword(pwd);

        try {
            //绑定服务器以及端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);

            //获取对象输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            //发送
            objectOutputStream.writeObject(user);


            //获取输入流
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            //获取返回的信息对象
            Message message = (Message)objectInputStream.readObject();

            if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){//登录成功
                b=true;

                //创建一个和服务器端保持通信的线程
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();

                //加入到线程集合中进行管理
                ManageClientConnectService.addClientConnectServerThread(name,clientConnectServerThread);
            }else {//登录失败
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return b;
    }

    //向服务器端请求在线用户列表
    public void onLineFriendList(){

        //发送一个Message，类型是MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(user.getName());

        //发送给服务器
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(ManageClientConnectService.getClientConnectServerThread(user.getName()).getSocket().getOutputStream());

            //发送
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //退出功能
    public void logout(){
        //封装退出信息
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getName());

        //把退出信息发送给服务端
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(ManageClientConnectService.getClientConnectServerThread(user.getName()).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);

            //退出
            System.out.println(user.getName()+"退出系统");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根据用户名私聊发送信息
    public void sendContent(){
        System.out.print("接收者名字:");
        String userName = ScannerUtil.readString(50);
        System.out.print("发送的信息：");
        //输入信息
        String content = ScannerUtil.readString(50);

        Message message = new Message();
        message.setSender(user.getName());
        message.setGetter(userName);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        message.setMesType(MessageType.MESSAGE_COMM_MES);

        //发送
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(ManageClientConnectService.getClientConnectServerThread(user.getName()).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //群发消息
    public void sendGroup(){
        //提示输入
        System.out.print("请输入要群发的消息：");
        String content = ScannerUtil.readString(100);

        //封装数据
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES_GROUP);
        message.setContent(content);
        message.setSender(user.getName());

        //发送
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(ManageClientConnectService.getClientConnectServerThread(user.getName()).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //发送文件
    public void sendFile(){
        FileInputStream fileInputStream=null;

        //接收者
        System.out.print("请输入接收者名字：");
        String getter = ScannerUtil.readString(50);

        //提示输入路径
        System.out.print("请输入绝对路径：");
        String path = ScannerUtil.readString(100);

        Message message = new Message();
        message.setSender(user.getName());
        message.setGetter(getter);
        message.setMesType(MessageType.MESSAGE_FILE_MES);

        //初始化一个数组接收文件
        int length = (int) new File(path).length();
        byte[] buf = new byte[length];

        //创建字节流
        try {
            fileInputStream = new FileInputStream(path);
            fileInputStream.read(buf);

            //将文件数组封装
            message.setFile(buf);
            message.setFileLen(length);

            //输出流
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(ManageClientConnectService.getClientConnectServerThread(user.getName()).getSocket().getOutputStream());

            //发送
            objectOutputStream.writeObject(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

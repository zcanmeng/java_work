package com.cm.kkserver;

import com.cm.kkcommon.Message;
import com.cm.kkcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

/**
 * 该类对应的对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{

    private Socket socket=null;

    private String userName=null;

    public ServerConnectClientThread(Socket socket,String userName){
        this.socket=socket;
        this.userName = userName;
    }

    public ServerConnectClientThread(){

    }

    @Override
    public void run() {//发送或接收消息

        //接收发给自己的离线信息
        List<Message> offlineList = OfflineUserContent.getContentListByUserName(userName);
        if (offlineList!=null){//有信息
            //删除离线信息
            OfflineUserContent.removeContent(userName);
            ObjectOutputStream objectOutputStream=null;
            for (Message message:offlineList){
                try {
                    //自己的输出流
                    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                    //发给自己
                    objectOutputStream.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        while (true){
            System.out.println("服务端和客户端"+userName+"保持通信，读取数据。。。");
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();

                //判断客户端请求
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND) ){
                    System.out.println(message.getSender()+"申请查看用户列表");

                    //获取在线用户列表
                    String onlineUser = ManageServerConnectService.getOnlineUser();

                    //封装返回的数据
                    Message result = new Message();

                    result.setContent(onlineUser);
                    result.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    result.setGetter(message.getSender());

                    //获取输出流
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    //返回的数据
                    objectOutputStream.writeObject(result);


                }else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){//退出
                    System.out.println("用户："+message.getSender()+"退出");
                    ManageServerConnectService.removeServerConnectClientThread(message.getSender());
                    //关闭socket
                    socket.close();
                    //退出
                    break;

                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){//接收转发数据
                    System.out.println(message.getSender()+"对"+message.getGetter()+"说："+message.getContent());
                    //判断是否存在该用户
                    ServerConnectClientThread serverConnectClientThread = ManageServerConnectService.getServerConnectClientThread(message.getGetter());


                    if (serverConnectClientThread!=null){//用户在线
                        //获取输出流
                        ObjectOutputStream objectOutputStream =
                                new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                        //转发信息
                        objectOutputStream.writeObject(message);
                    }else {//不在线
                        //获取离线信息列表
                        List<Message> contentListByUserName = OfflineUserContent.getContentListByUserName(message.getGetter());

                        if (contentListByUserName!=null){//以及有离线信息
                            contentListByUserName.add(message);//追加进去
                        }else {//不存在
                            Vector<Message> vector = new Vector<>();
                            vector.add(message);
                            OfflineUserContent.addContent(message.getGetter(),vector);
                        }

                    }
//                    else {//没找到
//                        ObjectOutputStream objectOutputStream =
//                                new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
//
//                        //包装回复信息
//                        Message result = new Message();
//                        result.setContent("用户未找到！");
//                        result.setMesType(MessageType.MESSAGE_COMM_MES_FAIL);
//                        objectOutputStream.writeObject(result);
//                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_GROUP)){//处理群发信息
                    System.out.println(message.getSender()+"群发了信息");
                    //获取所有在线
                    Map<String, ServerConnectClientThread> hm = ManageServerConnectService.getHm();
                    Set<String> strings = hm.keySet();

                    //循环发送信息
                    for (String value:strings){
                        if (value.equals(message.getSender())){
                            ObjectOutputStream objectOutputStream =
                                    new ObjectOutputStream(ManageServerConnectService.getServerConnectClientThread(value).getSocket().getOutputStream());
                            objectOutputStream.writeObject(message);
                        }
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){//转发文件
                    System.out.println(message.getSender()+"在给"+message.getGetter()+"发送文件");

                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(ManageServerConnectService.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream());
                    //发送
                    objectOutputStream.writeObject(message);
                }
                else {
                    System.out.println("其他类型的message，暂不处理");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

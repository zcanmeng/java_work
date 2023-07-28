package com.cm.kkserver;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 用于管理和客户端通信的线程
 */
public class ManageServerConnectService {
    private static Map<String,ServerConnectClientThread> hm=new HashMap<>();

    //添加线程对象到hm集合
    public static void addServerConnectClientThread(String userName,ServerConnectClientThread serverConnectClientThread){
        hm.put(userName,serverConnectClientThread);
    }

    //获取线程对象
    public static ServerConnectClientThread getServerConnectClientThread(String userName){
        ServerConnectClientThread serverConnectClientThread = hm.get(userName);

        return serverConnectClientThread;
    }

    //从集合中删除线程并返回该线程
    public static void removeServerConnectClientThread(String userName){
        hm.remove(userName);
    }

    //返回在线用户列表
    public static String getOnlineUser(){
        Set<String> strings = hm.keySet();

        //返回的字符串
        StringBuffer stringBuffer = new StringBuffer();
        for (String value:strings){
            stringBuffer.append(value+" ");
        }

        return stringBuffer.toString();
    }

    public static Map<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    public static void setHm(Map<String, ServerConnectClientThread> hm) {
        ManageServerConnectService.hm = hm;
    }
}

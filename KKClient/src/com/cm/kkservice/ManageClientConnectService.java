package com.cm.kkservice;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理客户端连接到服务器端的线程的类
 */
public class ManageClientConnectService {
    //线程管理集合
    private static Map<String,ClientConnectServerThread> hm=new HashMap<>();

    //将某个线程加入到集合
    public static void addClientConnectServerThread(String name,ClientConnectServerThread clientConnectServerThread){
        hm.put(name,clientConnectServerThread);
    }

    public static ClientConnectServerThread getClientConnectServerThread(String name){
        ClientConnectServerThread clientConnectServerThread = hm.get(name);

        return clientConnectServerThread;
    }
}

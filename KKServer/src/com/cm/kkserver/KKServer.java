package com.cm.kkserver;


import com.cm.kkcommon.Message;
import com.cm.kkcommon.MessageType;
import com.cm.kkcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 监听9999，等待客户端的连接，并保持通信
 */
public class KKServer {

    private ServerSocket ss = null;


    public static void main(String[] args) {
        new KKServer();
    }

    //模拟数据库
    private static Map<String,User> db = new HashMap<>();
    static {
        db.put("555",new User("555","123456"));
        db.put("666",new User("666","123456"));
        db.put("888",new User("888","123456"));
        db.put("999",new User("999","123456"));
        db.put("至尊宝",new User("至尊宝","123456"));
        db.put("紫霞仙子",new User("紫霞仙子","123456"));
        db.put("桃花不换酒",new User("桃花不换酒","123456"));
        db.put("路泊深山",new User("路泊深山","123456"));
        db.put("对眼欲穿",new User("对眼欲穿","123456"));
        db.put("空",new User("空","123456"));

    }

    public boolean checkUser(String userName,String password){
        boolean flag = false;

        //查找是否有该账户
        User user = db.get(userName);
        System.out.println(user);

        if (user!=null){//有该账户
            flag = user.getPassword().equals(password);
        }

        //返回值
        return flag;
    }

    public KKServer(){
        System.out.println("服务端再9999端口监听。。。");
        try {
            ss=new ServerSocket(9999);

            //启动推送服务
            new Thread(new SendNewsToAllThread()).start();

            while (true){//持续监听
                Socket socket = ss.accept();
                //得到输入流
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User)objectInputStream.readObject();


                //得到输出流
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();

                boolean flag =checkUser(user.getName(),user.getPassword());

//                System.out.println(flag);
                //验证用户
                if (flag){//合法用户
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复
                    objectOutputStream.writeObject(message);

                    //创建线程
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getName());

                    //启动线程
                    serverConnectClientThread.start();

                    //添加到集合中管理
                    ManageServerConnectService.addServerConnectClientThread(user.getName(),serverConnectClientThread);
                }
                else {//登录失败
                    System.out.println("用户 id="+user.getName()+"验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    objectOutputStream.writeObject(message);
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

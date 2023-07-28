package com.cm.kkserver;

import com.cm.kkcommon.Message;
import com.cm.kkcommon.MessageType;
import com.cm.utils.ScannerUtil;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

public class SendNewsToAllThread implements Runnable {

    @Override
    public void run() {
        while (true){
            //输入推送消息
            System.out.print("推送的消息：");
            String news = ScannerUtil.readString(200);

            //封装数据
            Message message = new Message();
            message.setSender("系统");
            message.setMesType(MessageType.MESSAGE_COMM_MES_GROUP);
            message.setContent(news);

            //获取所有用户
            Map<String, ServerConnectClientThread> hm = ManageServerConnectService.getHm();
            Set<String> key = hm.keySet();
            for (String value:key){
                try {
                    ObjectOutputStream objectOutputStream =
                            new ObjectOutputStream(ManageServerConnectService.getServerConnectClientThread(value).getSocket().getOutputStream());

                    objectOutputStream.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

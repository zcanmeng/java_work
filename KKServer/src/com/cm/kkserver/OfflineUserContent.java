package com.cm.kkserver;

import com.cm.kkcommon.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfflineUserContent {
    private static Map<String,List<Message>> offlineContent = new HashMap<>();

    public static Map<String, List<Message>> getOfflineContent() {
        return offlineContent;
    }

    public static void setOfflineContent(Map<String, List<Message>> offlineContent) {
        OfflineUserContent.offlineContent = offlineContent;
    }

    //根据用户名获取列表
    public static List<Message> getContentListByUserName(String userName){
        List<Message> content = offlineContent.get(userName);

        return content;
    }

    //添加离线信息列表
    public static void addContent(String userName,List<Message> messages){
        offlineContent.put(userName,messages);
    }

    //删除离线信息列表
    public static void removeContent(String userName){
        offlineContent.remove(userName);
    }
}

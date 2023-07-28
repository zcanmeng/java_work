package com.cm.kkcommon;

/**
 * 表示信息类型
 */
public interface MessageType {

    String MESSAGE_LOGIN_SUCCEED="1";//登录成功
    String MESSAGE_LOGIN_FAIL="2";//登录失败
    String MESSAGE_COMM_MES = "3";//普通信息包
    String MESSAGE_COMM_MES_FAIL="4";//发送失败
    String MESSAGE_COMM_MES_GROUP="5";//群发消息
    String MESSAGE_GET_ONLINE_FRIEND = "6";//要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND = "7";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "8";//客户端请求退出
    String MESSAGE_FILE_MES="9";//发送文件
}

package com.cm.kkcommon;

import java.io.Serializable;
import java.util.Arrays;

public class Message implements Serializable{
    private static final long serialVdersionUID =1l;

    private String sender;
    private String getter;
    private String content;
    private String sendTime;
    private String mesType;

    //文件
    private byte file[];
    private int fileLen;

    public Message() {
    }

    public Message(String sender, String getter, String content, String sendTime, String mesType, byte[] file, int fileLen) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.sendTime = sendTime;
        this.mesType = mesType;
        this.file = file;
        this.fileLen = fileLen;
    }

    public static long getSerialVdersionUID() {
        return serialVdersionUID;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", getter='" + getter + '\'' +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", mesType='" + mesType + '\'' +
                ", file=" + Arrays.toString(file) +
                ", fileLen=" + fileLen +
                '}';
    }
}

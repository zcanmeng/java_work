package com.cm.socket.work01;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 */
public class Work {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        OutputStream output = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
        bufferedWriter.write("hello,writer,server");
        bufferedWriter.flush();
        //标记输出完毕
        socket.shutdownOutput();

        InputStream input = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        String line="";
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        socket.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

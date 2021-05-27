package com.killer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 定义服务端的接收程序，接受socket
 * Created by killer on 21-5-18.
 */
public class MyServer {
    public static void startServer(int port) throws Exception {
        //定义服务端套接字
        ServerSocket serverSocket = new ServerSocket(port);

        //定义客户端套接字
        Socket socket = null;
        while (true) {
            socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            OutputStream outputStream = socket.getOutputStream();

            MyRequest myRequest = new MyRequest(inputStream);

            MyResponse myResponse = new MyResponse(outputStream);


            String method = new MyMapping().getMapping().get(myRequest.getRequestUri());

            if (null != method) {
               Class<MyHttpServerlet>  myHttpServerletClass=(Class<MyHttpServerlet>)Class.forName(method);

                MyHttpServerlet myHttpServerlet=myHttpServerletClass.newInstance();

                myHttpServerlet.service(myRequest,myResponse);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        startServer(10010);
    }
}

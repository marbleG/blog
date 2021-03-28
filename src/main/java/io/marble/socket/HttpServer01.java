package io.marble.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try (Socket accept = serverSocket.accept();) {
                service(accept);
            }
        }
    }

    public static void service(Socket socket) {
        try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream());) {
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio1";
            //显示告诉报文长度
            printWriter.println("Content-Length:" + body.getBytes(StandardCharsets.UTF_8).length);
            //报文头和报文体通过空行分割
            printWriter.println();
            printWriter.write(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

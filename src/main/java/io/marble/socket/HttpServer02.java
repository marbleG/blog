package io.marble.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程客户端
 */
public class HttpServer02 {

    public static void main(String[] args) throws IOException {

        System.out.println(Runtime.getRuntime().availableProcessors());
        ServerSocket serverSocket = new ServerSocket(8802);
        while (true) {
            final Socket accept = serverSocket.accept();
            new Thread(() -> {
                service(accept);
            }).start();
        }
    }

    public static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            Thread.sleep(5);

            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio2";
            //显示告诉报文长度
            printWriter.println("Content-Length:" + body.getBytes(StandardCharsets.UTF_8).length);
            //报文头和报文体通过空行分割
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

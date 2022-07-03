package org.example;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServerSocketExample {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(300);
        Socket socket = serverSocket.accept();
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println("Connection: Keep-Alive");
        writer.println();

        System.out.println("Write text:");
        Scanner scanner = new Scanner(System.in);

        String str = null;
        while ( !(str = scanner.nextLine()).equals("exit")) {
            writer.println(str);
        }

        scanner.close();
        socket.close();
    }
}

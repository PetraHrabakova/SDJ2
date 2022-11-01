package SocketsBuildUp.server;

import SocketsBuildUp.util.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void startServer() {
        System.out.println("Starting server...");
        try{
            ServerSocket serverSocket = new ServerSocket(2910);
            ConnectionPool connectionPool = new ConnectionPool();

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                ServerSocketHandler ssh = new ServerSocketHandler(socket, connectionPool);
                connectionPool.addClient(ssh);
                Thread t = new Thread(ssh);
                t.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

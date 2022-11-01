package Exercise2.server;

import Exercise2.util.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void startServer() {
        System.out.println("Starting server...");
        try{
            int idCounter = 1;
            ServerSocket serverSocket = new ServerSocket(2910);
            ConnectionPool connectionPool = new ConnectionPool();

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client " + idCounter + " connected");

                ServerSocketHandler ssh = new ServerSocketHandler(socket, connectionPool);
                connectionPool.addClient(ssh);
                Message m = new Message("Client id: " + idCounter);
                connectionPool.broadcast(m, idCounter);

                Thread t = new Thread(ssh);
                t.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

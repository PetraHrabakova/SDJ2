package server.network;

import server.model.DataModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
  private DataModel model;

  public SocketServer(DataModel model) {
    this.model = model;
  }

  public void startServer() {
    try {
      System.out.println("Starting server...");
      ServerSocket welcomeSocket = new ServerSocket(2910);

      while(true) {
        Socket socket = welcomeSocket.accept();

        // new Thread for each client
        new Thread(new SocketHandler(socket, model)).start();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

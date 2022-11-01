package Exercise2.server;

import Exercise2.util.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ConnectionPool connectionPool;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;


  public ServerSocketHandler(Socket socket, ConnectionPool connectionPool) {
    this.socket = socket;
    this.connectionPool = connectionPool;
    try {
      inFromClient = new ObjectInputStream(socket.getInputStream());
      outToClient = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override public void run() {
    try
    {
      while (true)
      {
        Message read = (Message) inFromClient.readObject();
        System.out.println("Received from client: " + read);

        if (read.getMessageBody().equalsIgnoreCase("exit"))
        {
          socket.close();
          connectionPool.removeClient(this);
          System.out.println("Client disconnected");
          break;
        }

        String output = read.getMessageBody();
        int id = output.charAt(output.length()-1);
        Message m = new Message("Client id: " + id);
        connectionPool.broadcast(m, id);
      }
    }
    catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void sendMessage(Message message) {
    try {
      outToClient.writeObject(message);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

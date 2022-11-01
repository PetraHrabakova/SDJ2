package Exercise2.client;

import Exercise2.server.ConnectionPool;
import Exercise2.util.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private ConnectionPool connectionPool;
  private ObjectInputStream inFromServer;
  private ObjectOutputStream outToServer;


  public ClientSocketHandler(Socket socket, ConnectionPool connectionPool) {
    this.socket = socket;
    this.connectionPool = connectionPool;
    try {
      inFromServer = new ObjectInputStream(socket.getInputStream());
      outToServer = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    try
    {
      while (true)
      {
        Message read = (Message) inFromServer.readObject();
        System.out.println("Received: " + read);

        if (read.getMessageBody().equalsIgnoreCase("exit"))
        {
          socket.close();
          // connectionPool.removeClient(this);
          System.out.println("Server disconnected");
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
      outToServer.writeObject(message);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

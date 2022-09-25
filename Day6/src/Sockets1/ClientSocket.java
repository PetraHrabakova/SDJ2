package Sockets1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket
{
  public static void main(String[] args)
  {
    try
    {
      Socket client = new Socket ("localhost", 2910);
      System.out.println("Client is started");

      ObjectOutputStream outToServer = new ObjectOutputStream((client.getOutputStream()));
      outToServer.writeObject("HELLO");

      ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());
      String answer = (String) inFromServer.readObject();
      System.out.println("Client received: " + answer);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}

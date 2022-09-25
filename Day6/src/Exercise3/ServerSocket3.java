package Exercise3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class ServerSocket3
{
  public static void main(String[] args)
  {
    System.out.println("Starting server...");

    try
    {
      ServerSocket welcomeSocket = new ServerSocket(2910);
      while (true)
      {
        Socket client = welcomeSocket.accept();
        System.out.println("Client connected!");
        System.out.println("How can I help you?");

        ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
        String o = (String) inFromClient.readObject();

        while (!(o.equals("stop")))
        {
          if (o.equals(("upper case").toLowerCase()))
          {
            String answer = o.toUpperCase();
            ObjectOutputStream outFromClient = new ObjectOutputStream(
                client.getOutputStream());
            outFromClient.writeObject(answer);
            System.out.println("Server sent: " + answer);
            inFromClient = new ObjectInputStream(client.getInputStream());
            o = (String) inFromClient.readObject();
          }
          else if (o.equals(("lower case").toLowerCase()))
          {
            String answer = o.toLowerCase();
            ObjectOutputStream outFromClient = new ObjectOutputStream(
                client.getOutputStream());
            outFromClient.writeObject(answer);
            System.out.println("Server sent: " + answer);
            inFromClient = new ObjectInputStream(client.getInputStream());
            o = (String) inFromClient.readObject();
          }
        }
      }
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

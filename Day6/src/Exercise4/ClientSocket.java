package Exercise4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket
{
  public static void main(String[] args)
  {
    try
    {
      Socket client = new Socket ("localhost", 5678);
      System.out.println("Client is started");

      Scanner sc = new Scanner(System.in);

      // Send "connect to the Server to initiate connection
      ObjectOutputStream outToServer = new ObjectOutputStream((client.getOutputStream()));
      outToServer.writeObject("connect");

      ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());
      String answer = (String) inFromServer.readObject();

      while (!(answer.equals("Disconnected"))) {
        if (answer.equals("Username? "))
        {
          System.out.println("Client received: " + answer);
          System.out.println("Enter username: ");
          String username = sc.nextLine();
          outToServer = new ObjectOutputStream((client.getOutputStream()));
          outToServer.writeObject(username);
        }
        else if (answer.equals("Password? "))
        {
          System.out.println("Client received: " + answer);
          System.out.println("Enter password: ");
          String password = sc.nextLine();
          outToServer = new ObjectOutputStream((client.getOutputStream()));
          outToServer.writeObject(password);
        }
        else {
          System.out.println("Client received: " + answer);
        }
        inFromServer = new ObjectInputStream(client.getInputStream());
        answer = (String) inFromServer.readObject();
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

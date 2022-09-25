package Exercise3;

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
      Socket client = new Socket ("localhost", 2910);

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter your input: ");
      String input = sc.nextLine();

      while (!(input.equals("stop")))
      {
        ObjectOutputStream outToServer = new ObjectOutputStream((client.getOutputStream()));
        outToServer.writeObject(input);

        ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());
        String answer = (String) inFromServer.readObject();
        System.out.println("Client received: " + answer);

        System.out.println("Enter your input: ");
        input = sc.nextLine();
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

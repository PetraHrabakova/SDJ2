package Exercise2;

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
      Socket client1 = new Socket ("localhost", 2910);
      Socket client2 = new Socket ("localhost", 2910);
      Socket client3 = new Socket ("localhost", 2910);

      System.out.println("Client 1 is started");
      System.out.println("Client 2 is started");
      System.out.println("Client 3 is started");

      Scanner input1 = new Scanner(System.in);
      System.out.println("Enter your input 1: ");

      Scanner input2 = new Scanner(System.in);
      System.out.println("Enter your input 2: ");

      Scanner input3 = new Scanner(System.in);
      System.out.println("Enter your input 3: ");

      ObjectOutputStream outToServer1 = new ObjectOutputStream((client1.getOutputStream()));
      outToServer1.writeObject(input1.nextLine());
      ObjectInputStream inFromServer1 = new ObjectInputStream(client1.getInputStream());
      String answer1 = (String) inFromServer1.readObject();
      System.out.println("Client received: " + answer1);

      ObjectOutputStream outToServer2 = new ObjectOutputStream((client2.getOutputStream()));
      outToServer2.writeObject(input2.nextLine());
      ObjectInputStream inFromServer2 = new ObjectInputStream(client2.getInputStream());
      String answer2 = (String) inFromServer2.readObject();
      System.out.println("Client received: " + answer2);

      ObjectOutputStream outToServer3 = new ObjectOutputStream((client3.getOutputStream()));
      outToServer3.writeObject(input1.nextLine());
      ObjectInputStream inFromServer3 = new ObjectInputStream(client3.getInputStream());
      String answer3 = (String) inFromServer3.readObject();
      System.out.println("Client received: " + answer3);
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

package Exercise4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket4
{
  public static void main(String[] args)
  {
    String[] array = {"Username? ", "Password? ", "Approved"};
    System.out.println("Starting server...");

    try {
      ServerSocket welcomeSocket = new ServerSocket(5678);
      while (true) {
          Socket client = welcomeSocket.accept();
          System.out.println("Client connected!");

          ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
          String o = (String) inFromClient.readObject();
          System.out.println("Server received: " + o);

          if (o.equals(("connect").toLowerCase())) {
            // Username ?
            String answer = array[0];
            System.out.println("Server sent: " + answer);
            ObjectOutputStream outFromClient = new ObjectOutputStream(client.getOutputStream());
            outFromClient.writeObject(answer);

            inFromClient = new ObjectInputStream(client.getInputStream());
            o = (String) inFromClient.readObject();
            System.out.println("Server received: " + o);

            // Password ?
            answer = array[1];
            System.out.println("Server sent: " + answer);
            outFromClient = new ObjectOutputStream(client.getOutputStream());
            outFromClient.writeObject(answer);

            inFromClient = new ObjectInputStream(client.getInputStream());
            o = (String) inFromClient.readObject();
            System.out.println("Server received: " + o);

            // Approved
            answer = array[2];
            System.out.println("Server sent: " + answer);
            outFromClient = new ObjectOutputStream(client.getOutputStream());
            outFromClient.writeObject(answer);
          }
          else {
            String answer = "Disconnected";
            ObjectOutputStream outFromClient = new ObjectOutputStream(client.getOutputStream());
            outFromClient.writeObject(answer);
          }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

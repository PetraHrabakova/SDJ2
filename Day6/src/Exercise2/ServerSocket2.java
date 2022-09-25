package Exercise2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket2
{
  public static void main(String[] args)
  {
    System.out.println("Starting server...");

    try {
      ServerSocket welcomeSocket = new ServerSocket(2910);
      while (true) {
          Socket client = welcomeSocket.accept();
          System.out.println("Client connected!");

          ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
          String o = (String) inFromClient.readObject();
          System.out.println("Received from the client: " + o);

          String answer = o.toUpperCase();
          ObjectOutputStream outFromClient = new ObjectOutputStream(client.getOutputStream());
          outFromClient.writeObject(answer);
          System.out.println("Server sent: " + answer);

      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

package FunctionalityExercise.client;

import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
  {
    ClientImpl client = new ClientImpl();
    client.initializeConnection(); // Get access to the server

    Scanner scan = new Scanner(System.in);
    String read = "";

    while(true) {
      System.out.println("Option > ");

      read = scan.nextLine();
      if (read.equalsIgnoreCase("exit")) break;

      else {
        if (read.equalsIgnoreCase("upper"))
        {
          System.out.println("Input >");
          String input = scan.nextLine();
          System.out.println("Result > " + client.toUpperCase(input));
        }
        else if (read.equalsIgnoreCase("lower"))
        {
          System.out.println("Input >");
          String input = scan.nextLine();
          System.out.println("Result > " + client.toLowerCase(input));
        }
        else {
          System.out.println("Did not understand :(");

        }
      }
    }
  }
}

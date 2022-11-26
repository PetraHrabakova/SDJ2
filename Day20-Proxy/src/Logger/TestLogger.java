package Logger;

public class TestLogger
{
  public static void main(String[] args)
  {
    ConsoleLogger sparseLogger = new ConsoleLogger("sparse");
    ConsoleLogger verboseLogger = new ConsoleLogger("verbose");

    sparseLogger.log("Yo sup, how you doin?");
    sparseLogger.log("Error message sup");
    verboseLogger.log("Yo yo you looking good");
    verboseLogger.log("This might be an error message");
  }
}

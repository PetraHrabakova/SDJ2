package Exercise3;

public class Example1
{
  public static void main(String[] args)
  {
    Thread numberThread = new Thread(new Numbers(5));
    Thread letterThread = new Thread(new Letters(5));

    numberThread.start();
    letterThread.start();

  }
}

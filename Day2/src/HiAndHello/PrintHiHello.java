package HiAndHello;

public class PrintHiHello
{
  public static void main(String[] args)
  {
    Thread helloThread = new Thread(new Hello());
    Thread hiThread = new Thread(new Hi());

    helloThread.start();
    hiThread.start();
  }
}

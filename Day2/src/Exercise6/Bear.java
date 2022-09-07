package Exercise6;

public class Bear implements Runnable
{
  @Override
  public void run() {
    System.out.println("Beer is feeling tired");
    System.out.println("Beer goes to sleep");

    try {
      Thread.sleep(10000);
      System.out.println("Happy bear");
    } catch (InterruptedException e) {
      System.out.println("Angry bear! Grrrr!");
    }
  }



}

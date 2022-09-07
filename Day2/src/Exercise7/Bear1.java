package Exercise7;

public class Bear1 implements Runnable
{
  private Thread bear2;
  private Thread bear3;

  public Bear1(Thread bear2, Thread bear3) {
    this.bear2 = bear2;
    this.bear3 = bear3;
  }

  @Override
  public void run() {
    System.out.println("Beer is feeling tired");
    System.out.println("Beer goes to sleep");

    try {
      Thread.sleep(10000);
      System.out.println("Happy bear");
    } catch (InterruptedException e) {
      System.out.println("Angry bear! Grrrr!");
      bear2.start();
      bear3.start();
    }
  }



}

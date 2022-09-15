package Exercise3;

public class Mailbox implements Runnable
{
  private long maxFrequency;
  private int count;
  private static long RUNTIME = 100000;

  public Mailbox(int count) {
    this.count = count;
  }

  public void run() {
    waitingForMails();
  }

  private void waitingForMails() {
    while (maxFrequency < RUNTIME) {
      try {
        Thread.sleep(RUNTIME/count);
        System.out.println("New mail in your mailbox...");
        maxFrequency+=count;
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

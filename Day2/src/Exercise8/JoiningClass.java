package Exercise8;

public class JoiningClass implements Runnable
{
  private int x;
  private int y;
  private Thread threadClass;

  public JoiningClass(int x, int y, Thread threadClass) {
    this.x = x;
    this.y = y;
    this.threadClass = threadClass;
  }

  @Override
  public void run() {
    try {
      threadClass.join();
      for (int i = x; i <= y; i++) {
        System.out.println(i);
      }
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }


  }
}

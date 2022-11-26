package WritersPreferenceReadWrite;

public class Reader implements Runnable
{
  WritersPreferenceReadWrite sr;
  private int sleepTime;

  public Reader(WritersPreferenceReadWrite sr, int sleepTime) {
    this.sr = sr;
    this.sleepTime = sleepTime;
  }
  @Override public void run()
  {
    while (true) {
      try {
        Thread.sleep(sleepTime);
        sr.acquireRead();
        System.out.println("Reading. Shared data: " + sr.doRead());
        sr.releaseRead();
      } catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}

package ReadersPreferenceReadWrite;

public class Writer implements Runnable
{
  ReadersPreferenceReadWrite sr;
  private int sleepTime;

  public Writer(ReadersPreferenceReadWrite sr, int sleepTime) {
    this.sr = sr;
    this.sleepTime = sleepTime;
  }
  @Override public void run()
  {
    while (true) {
      try {
        Thread.sleep(sleepTime);
        sr.acquireWrite();
        sr.doWrite();
        sr.releaseWrite();
      } catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

}

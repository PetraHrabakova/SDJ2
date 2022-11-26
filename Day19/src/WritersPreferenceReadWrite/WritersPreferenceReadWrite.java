package WritersPreferenceReadWrite;

public class WritersPreferenceReadWrite implements ReadWrite
{
  private int readers;
  private boolean isWriting;
  private int waitingWriters;
  private int sharedData;

  public WritersPreferenceReadWrite() {
    readers = waitingWriters = 0;
    isWriting = false;
    sharedData = 0;
  }

  @Override public synchronized void acquireRead() {
    while (isWriting || waitingWriters > 0) {
      try {
        wait();
      } catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    readers++;
  }

  @Override public synchronized void releaseRead() {
    readers--;
    if (readers == 0) {
      notifyAll();
    }
  }

  @Override public synchronized void acquireWrite() {
    waitingWriters++;
    while (readers > 0 || isWriting) {
      try {
        wait();
      } catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingWriters--;
    isWriting = true;
  }

  @Override public synchronized void releaseWrite() {
    isWriting = false;
    notifyAll();
  }

  public void doWrite() {
    sharedData++;
    System.out.println("Writing");
  }
  public int doRead() {
    return sharedData;
  }
}

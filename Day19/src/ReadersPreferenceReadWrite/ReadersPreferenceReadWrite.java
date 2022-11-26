

package ReadersPreferenceReadWrite;

public class ReadersPreferenceReadWrite implements ReadWrite
{
  private int activeReaders, writers, waitingReaders;
  private int sharedData;

  public ReadersPreferenceReadWrite() {
    activeReaders = writers = waitingReaders = 0;
    sharedData = 0;
  }

  @Override public synchronized void acquireRead() {
    waitingReaders++;
    while (writers > 0) {
      try {
        wait();
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
    }
    waitingReaders--;
    activeReaders++;
  }

  @Override public synchronized void releaseRead() {
    activeReaders--;
    if (activeReaders == 0) {
      notifyAll();
    }
  }

  @Override public synchronized void acquireWrite() {
    while (activeReaders > 0 || writers > 0 || waitingReaders > 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    writers++;
  }

  @Override public synchronized void releaseWrite() {
    writers--;
    notifyAll();
  }

  public void doWrite() {
    sharedData++;
  }
  public int doRead() {
    return sharedData;
  }
}

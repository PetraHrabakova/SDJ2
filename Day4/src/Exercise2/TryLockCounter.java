package Exercise2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockCounter
{
  private int count;
  private Lock lock = new ReentrantLock();

  public void inc()
  {
    if (lock.tryLock())
    {
      count++;
      lock.unlock();
    }
    else {
      System.out.println("Lock in use, going to sleep");
      try {
        Thread.sleep(1);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public synchronized int get() {
    return count;
  }
}



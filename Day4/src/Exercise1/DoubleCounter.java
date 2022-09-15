package Exercise1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoubleCounter
{
  private int countA;
  private int countB;

  private Lock lockA = new ReentrantLock();
  private Lock lockB = new ReentrantLock();

  public void incA() {
    synchronized (lockA) {
      countA++;
    }
  }

  public void incB() {
    synchronized (lockB) {
      countB++;
    }
  }

  public int getA() {
    synchronized (lockA) {
      return countA;
    }
  }

  public int getB() {
    synchronized (lockB) {
      return countB;
    }
  }
}

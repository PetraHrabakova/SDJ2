package valuables;

import log.Log;
import utility.collection.ListADT;
import utility.collection.ArrayList;

public class BlockingQueueForDeposit<ValuablesMultiton> implements Deposit<ValuablesMultiton>
{
  private int capacity;
  private ListADT<ValuablesMultiton> deposit;

  public BlockingQueueForDeposit(int capacity) {
    this.capacity = capacity;
    deposit = new ArrayList<>();
  }

  @Override public synchronized void put(ValuablesMultiton valuable) {
    while (isFull()) {
      if (valuable == null)
      {
        throw new IllegalStateException();
      }
      Log.getInstance().addLog(Thread.currentThread().getName() + " is waiting because Deposit is full");
      try {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    deposit.add(valuable);
    notifyAll();
  }

  @Override public synchronized ValuablesMultiton take() {
    while (isEmpty()) {
      Log.getInstance().addLog(Thread.currentThread().getName() + " is waiting because Deposit is empty");
      try {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    notifyAll();
    return deposit.remove(0);
  }

  @Override public synchronized boolean isEmpty()
  {
    return deposit.isEmpty();
  }

  @Override public synchronized boolean isFull() { return deposit.size() == capacity;}

  public String toString() {
    return "";
  }
}
